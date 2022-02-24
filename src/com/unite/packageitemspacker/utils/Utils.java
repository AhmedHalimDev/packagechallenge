package com.unite.packageitemspacker.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Utils {

	private Utils() {
	}

	public static int round(BigDecimal number) {
		return number.setScale(0, RoundingMode.HALF_UP).intValue();
	}

}
