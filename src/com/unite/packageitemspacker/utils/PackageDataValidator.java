package com.unite.packageitemspacker.utils;

import java.math.BigDecimal;

import com.unite.packageitemspacker.exception.BusinessException;
import com.unite.packageitemspacker.model.Item;
import com.unite.packageitemspacker.model.PackageData;

public class PackageDataValidator {

	public static final int MAX_WEIGHT = 100;
	public static final int MAX_COST = 100;
	public static final int MAX_ITEMS_SIZE_IN_PACKAGE = 15;

	private PackageDataValidator() {
	}

	public static boolean validate(PackageData packageData) {
		if (packageData == null)
			throw new BusinessException("Invalid Package Data.");
		if (!validatePackageMaximumWeight(packageData))
			throw new BusinessException("Invalid package maximum weight, it may exceeds the maximum limit (" + MAX_WEIGHT + "), totalWeight: " + packageData.getWeightLimit());
		if (!validateItemMaxSize(packageData))
			throw new BusinessException("Invalid number of items per package, Max items possible is " + MAX_ITEMS_SIZE_IN_PACKAGE);
		if (!invalidItemsWeightExists(packageData))
			throw new BusinessException("Invalid item weight due to max item weight possible is " + MAX_WEIGHT);
		if (!invalidItemsCostExists(packageData))
			throw new BusinessException("Invalid item cost due to max item cost possible is " + MAX_COST);

		return true;
	}

	private static boolean validatePackageMaximumWeight(PackageData packageData) {
		return packageData.getWeightLimit().compareTo(BigDecimal.ZERO) > 0  && packageData.getWeightLimit().compareTo(new BigDecimal(MAX_WEIGHT)) <= 0;
	}

	private static boolean validateItemMaxSize(PackageData packageData) {
		return packageData.getItems().size() <= MAX_ITEMS_SIZE_IN_PACKAGE;
	}

	private static boolean invalidItemsWeightExists(PackageData packageData) {
		for (Item item : packageData.getItems()) {
			if(item.getWeight().compareTo(new BigDecimal(MAX_WEIGHT)) > 0 || item.getWeight().compareTo(BigDecimal.ZERO) <= 0)
				return false;
		}
		return true;
	}

	private static boolean invalidItemsCostExists(PackageData packageData) {
		for (Item item : packageData.getItems()) {
			if(item.getCost().compareTo(new BigDecimal(MAX_COST)) > 0 || item.getCost().compareTo(BigDecimal.ZERO) <= 0)
				return false;
		}
		return true;
	}

}
