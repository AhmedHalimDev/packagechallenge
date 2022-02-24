package com.unite.packageitemspacker.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PackageData {

	private BigDecimal weightLimit;
	private List<Item> items;

	public PackageData(BigDecimal weightLimit) {
		this.weightLimit = weightLimit;
		this.items = new ArrayList<>();
	}

	public PackageData(BigDecimal weightLimit, List<Item> items) {
		this.weightLimit = weightLimit;
		this.items = items;
	}

	public BigDecimal getWeightLimit() {
		return weightLimit;
	}

	public void setWeightLimit(BigDecimal weightLimit) {
		this.weightLimit = weightLimit;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "PackageData [weightLimit=" + weightLimit + ", items=" + items + "]";
	}

}