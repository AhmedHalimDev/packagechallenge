package com.unite.packageitemspacker.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.unite.packageitemspacker.model.Item;
import com.unite.packageitemspacker.model.PackageData;
import com.unite.packageitemspacker.utils.Utils;

public class PackageTargetItemsResolver {

	private PackageTargetItemsResolver() {
	}

	public static void resolvePackageItems(PackageData packageData, List<Item> items) {
		if (items.isEmpty()) {
			return;
		}
		int weightLimit = Utils.round(packageData.getWeightLimit());
		BigDecimal[][] costs = new BigDecimal[items.size() + 1][weightLimit + 1];
		int counter = 1;
		for(Item item : items) {
			for (int weightCounter = 1; weightCounter <= weightLimit; weightCounter ++) {
				costs[counter][weightCounter] = getPreviousItemMaximumCost(costs, counter, weightCounter);
				if (item.getWeight().compareTo(new BigDecimal(weightCounter)) <= 0) {
					BigDecimal itemMaximumCost = getItemMaxCost(costs, item, counter, weightCounter);

					if (itemMaximumCost.compareTo(costs[counter][weightCounter]) >= 0) {
						costs[counter][weightCounter] = itemMaximumCost;
					}
				}
			}
			counter++;
		}
		packageData.setItems(filterPackageItems(items, weightLimit, costs));
	}

	private static BigDecimal getPreviousItemMaximumCost(BigDecimal[][] costs, int indexCounter, int weigthCounter) {
		BigDecimal previousItemCost = costs[indexCounter - 1][weigthCounter];
		if (previousItemCost != null) {
			return previousItemCost;
		}
		return BigDecimal.ZERO;
	}

	private static List<Item> filterPackageItems(List<Item> items, int weightLimit, BigDecimal[][] costs) {
		List<Item> packageItems = new ArrayList<>();

		int weightCounter = weightLimit;
		int sizeCounter = items.size();
		BigDecimal cost = costs[sizeCounter][weightCounter];
		while (cost != null && cost.compareTo(BigDecimal.ZERO) > 0) {
			if (costs[sizeCounter][weightCounter] != costs[sizeCounter - 1][weightCounter]) {
				Item item = items.get(sizeCounter - 1);
				weightCounter -= Utils.round(item.getWeight());
				packageItems.add(item);
			}
			sizeCounter--;
			cost = costs[sizeCounter][weightCounter];
		}
		Collections.sort(packageItems);
		return packageItems;
	}

	private static BigDecimal getItemMaxCost(BigDecimal[][] costs, Item item, int indexCounter, int weightCounter) {
		BigDecimal maximumCostWithoutItemWeight = costs[indexCounter - 1][weightCounter - Utils.round(item.getWeight())];
		return maximumCostWithoutItemWeight == null ? item.getCost() : maximumCostWithoutItemWeight.add(item.getCost());
	}

}