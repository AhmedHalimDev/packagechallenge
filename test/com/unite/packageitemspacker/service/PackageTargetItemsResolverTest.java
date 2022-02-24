package com.unite.packageitemspacker.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.unite.packageitemspacker.exception.BusinessException;
import com.unite.packageitemspacker.model.Item;
import com.unite.packageitemspacker.model.PackageData;
import com.unite.packageitemspacker.service.PackageTargetItemsResolver;

public class PackageTargetItemsResolverTest {

	@Test
	public void resolvePackageItems_validPackageHasTwoItemsToBePacked_Success() {
		Item item1 = new Item(1, new BigDecimal(10), new BigDecimal(50));
		Item item2 = new Item(2, new BigDecimal(45), new BigDecimal(70));
		List<Item> items = new ArrayList<Item>();
		items.add(item1);
		items.add(item2);
		PackageData packageData = new PackageData(new BigDecimal(90), items);
		try {
			PackageTargetItemsResolver.resolvePackageItems(packageData, packageData.getItems());
		} catch(BusinessException ex) {
		}
		assertNotNull(packageData);
		assertFalse(packageData.getItems().isEmpty());
		assertEquals(packageData.getItems().size(), 2);
	}

	@Test
	public void resolvePackageItems_validPackageOnlyOneItemWillBePacked_Success() {
		Item item1 = new Item(1, new BigDecimal(40), new BigDecimal(20));
		Item item2 = new Item(2, new BigDecimal(80), new BigDecimal(45));
		List<Item> items = new ArrayList<Item>();
		items.add(item1);
		items.add(item2);
		PackageData packageData = new PackageData(new BigDecimal(90), items);
		try {
			PackageTargetItemsResolver.resolvePackageItems(packageData, packageData.getItems());
		} catch(BusinessException ex) {
		}
		assertNotNull(packageData);
		assertFalse(packageData.getItems().isEmpty());
		assertEquals(packageData.getItems().size(), 1);
		assertEquals(packageData.getItems().get(0).getWeight(), new BigDecimal(80));
		assertEquals(packageData.getItems().get(0).getCost(), new BigDecimal(45));
	}

	@Test
	public void resolvePackageItems_validPackageNoItemWillBePacked_Success() {
		Item item1 = new Item(1, new BigDecimal(30), new BigDecimal(20));
		Item item2 = new Item(2, new BigDecimal(50), new BigDecimal(45));
		List<Item> items = new ArrayList<Item>();
		items.add(item1);
		items.add(item2);
		PackageData packageData = new PackageData(new BigDecimal(20), items);
		try {
			PackageTargetItemsResolver.resolvePackageItems(packageData, packageData.getItems());
		} catch(BusinessException ex) {
		}
		assertNotNull(packageData);
		assertTrue(packageData.getItems().isEmpty());
		assertEquals(packageData.getItems().size(), 0);
	}
}
