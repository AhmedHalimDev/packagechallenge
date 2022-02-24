package com.unite.packageitemspacker.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.unite.packageitemspacker.exception.BusinessException;
import com.unite.packageitemspacker.model.Item;
import com.unite.packageitemspacker.model.PackageData;

public class PackageDataParser {

	private static final String PACKAGE_ITEM_TEMPLATE_REGEX = "\\((.*?)\\)";

	private PackageDataParser() {
	}

	public static PackageData parse(String packagesData) {
		try {
			BigDecimal weightLimit = new BigDecimal(packagesData.split(" : ")[0]);
			PackageData packageData = new PackageData(weightLimit);
			packageData.setItems(retrieveItemsData(packagesData));
			return packageData;
		}
		catch (Exception ex) {
			throw new BusinessException("Invalid package data from line data -> [" + packagesData +"]");
		}
	}

	private static List<Item> retrieveItemsData(String packagesData) {
		List<Item> items = new ArrayList<>();
		Matcher matcher = Pattern.compile(PACKAGE_ITEM_TEMPLATE_REGEX).matcher(packagesData);
		while (matcher.find()) {
			items.add(retrieveItemData(matcher.group(1)));
		}
		return items;
	}

	private static Item retrieveItemData(String data) {
		try {
			String[] packageDataList = data.split(",");
			Integer id = Integer.parseInt(packageDataList[0]);
			BigDecimal weight = new BigDecimal(packageDataList[1]);
			BigDecimal cost = new BigDecimal(packageDataList[2].substring(1));
			return new Item(id, weight, cost);
		}
		catch (Exception ex) {
			throw new BusinessException("Invalid item data from package input line -> [" + data +"]");
		}
	}
}
