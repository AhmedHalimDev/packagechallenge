package com.unite.packageitemspacker.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.Test;

import com.unite.packageitemspacker.exception.BusinessException;
import com.unite.packageitemspacker.model.PackageData;
import com.unite.packageitemspacker.utils.PackageDataParser;

public class PackageDataParserTest {

    @Test
    public void parse_validPackageDataLine_Success () {
        String packageDataLine = "30 : (1,20,€60) (2,30,€70)";
        PackageData packageData = PackageDataParser.parse(packageDataLine);
        assertNotNull(packageData);
        assertFalse(packageData.getItems().isEmpty());
        assertEquals(packageData.getItems().size(), 2);
        assertEquals(packageData.getWeightLimit(), new BigDecimal(30));
    }

    @Test
    public void parse_invalidPackageDataLine_Failure () {
        String packageDataLine = "30,, [1,20,€60)[2,€70)";
        PackageData packageData = null;
        try {
        	packageData = PackageDataParser.parse(packageDataLine);
        }
        catch (BusinessException ex) {
        }
        assertNull(packageData);
    }
}
