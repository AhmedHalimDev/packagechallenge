package com.unite.packageitemspacker.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com.unite.packageitemspacker.exception.BusinessException;
import com.unite.packageitemspacker.model.PackageData;
import com.unite.packageitemspacker.utils.PackageFileParser;

public class PackageFileParserTest {

	@Test
    public void parseInputFile_correctFile_Success() {
		String filePath = "resources\\packages.txt";
		List<PackageData> packagesList = PackageFileParser.parseInputFile(filePath);

		assertNotNull(packagesList);
		assertFalse(packagesList.isEmpty());
		assertEquals(packagesList.size(), 4);

		PackageData firstPackageData = packagesList.get(0);
		assertEquals(firstPackageData.getWeightLimit(), new BigDecimal(81));
		assertEquals(firstPackageData.getItems().size(), 6);

		PackageData secondPackageData = packagesList.get(1);
		assertFalse(secondPackageData.getItems().isEmpty());
		assertEquals(secondPackageData.getWeightLimit(), new BigDecimal(8));
    }


	@Test
    public void parseInputFile_notExistFile_Failure() {
		List<PackageData> packagesList = null;
		try {
			String filePath = "resources\\anotherFile.txt";
			packagesList = PackageFileParser.parseInputFile(filePath);
		} catch(BusinessException ex) {
		}
		assertNull(packagesList);
	}

}
