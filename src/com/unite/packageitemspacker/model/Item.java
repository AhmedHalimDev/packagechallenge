package com.unite.packageitemspacker.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Item implements Comparable<Item> {

	private Integer id;
	private BigDecimal weight;
	private BigDecimal cost;

	public Item(int id, BigDecimal weigth, BigDecimal cost) {
		this.id = id;
		this.weight = weigth;
		this.cost = cost;
	}

	public Integer getId() {
		return id;
	}

	public void setIndex(Integer id) {
		this.id = id;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Item)) {
			return false;
		}
		Item otherItem = (Item) o;
		return Objects.equals(id, otherItem.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "PackageData [id=" + id + ", weight=" + weight + ", cost=" + cost + "]";
	}

	@Override
	public int compareTo(Item item2) {
		return this.getId().compareTo(item2.getId());
	}

}