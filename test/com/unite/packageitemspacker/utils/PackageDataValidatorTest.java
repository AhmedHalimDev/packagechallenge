package com.unite.packageitemspacker.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.unite.packageitemspacker.exception.BusinessException;
import com.unite.packageitemspacker.model.Item;
import com.unite.packageitemspacker.model.PackageData;
import com.unite.packageitemspacker.utils.PackageDataValidator;

public class PackageDataValidatorTest {

	@Test
	public void validate_validPackageData_Success() {
		Item item1 = new Item(1, new BigDecimal(10), new BigDecimal(50));
		Item item2 = new Item(2, new BigDecimal(45), new BigDecimal(70));
		List<Item> items = new ArrayList<Item>();
		items.add(item1);
		items.add(item2);
		PackageData packageData = new PackageData(new BigDecimal(90), items);
		boolean valid = false;
		try {
			valid = PackageDataValidator.validate(packageData);
		} catch(BusinessException ex) {
		}
		assertTrue(valid);
	}

	@Test
	public void validate_invalidPackageDataWeight_Failure() {
		Item item1 = new Item(1, new BigDecimal(10), new BigDecimal(50));
		Item item2 = new Item(2, new BigDecimal(45), new BigDecimal(70));
		List<Item> items = new ArrayList<Item>();
		items.add(item1);
		items.add(item2);
		PackageData packageData = new PackageData(new BigDecimal(110), items);
		boolean valid = false;
		try {
			valid = PackageDataValidator.validate(packageData);
		} catch(BusinessException ex) {
		}
		assertFalse(valid);
	}

	@Test
	public void validate_invalidItemWeight_Failure() {
		Item item1 = new Item(1, new BigDecimal(10), new BigDecimal(50));
		Item item2 = new Item(2, new BigDecimal(150), new BigDecimal(70));
		List<Item> items = new ArrayList<Item>();
		items.add(item1);
		items.add(item2);
		PackageData packageData = new PackageData(new BigDecimal(90), items);
		boolean valid = false;
		try {
			valid = PackageDataValidator.validate(packageData);
		} catch(BusinessException ex) {
		}
		assertFalse(valid);
	}

	@Test
	public void validate_invalidItemCost_Failure() {
		Item item1 = new Item(1, new BigDecimal(10), new BigDecimal(50));
		Item item2 = new Item(2, new BigDecimal(20), new BigDecimal(150));
		List<Item> items = new ArrayList<Item>();
		items.add(item1);
		items.add(item2);
		PackageData packageData = new PackageData(new BigDecimal(90), items);
		boolean valid = false;
		try {
			valid = PackageDataValidator.validate(packageData);
		} catch(BusinessException ex) {
		}
		assertFalse(valid);
	}

	@Test
	public void validate_invalidItemsNumberPerPackage_Failure() {
		Item item1 = new Item(1, new BigDecimal(10), new BigDecimal(50));
		Item item2 = new Item(2, new BigDecimal(20), new BigDecimal(20));
		Item item3 = new Item(1, new BigDecimal(10), new BigDecimal(50));
		Item item4 = new Item(2, new BigDecimal(20), new BigDecimal(20));
		Item item5 = new Item(1, new BigDecimal(10), new BigDecimal(50));
		Item item6 = new Item(2, new BigDecimal(20), new BigDecimal(20));
		Item item7 = new Item(1, new BigDecimal(10), new BigDecimal(50));
		Item item8 = new Item(2, new BigDecimal(20), new BigDecimal(20));
		Item item9 = new Item(1, new BigDecimal(10), new BigDecimal(50));
		Item item10 = new Item(2, new BigDecimal(20), new BigDecimal(20));
		Item item11 = new Item(1, new BigDecimal(10), new BigDecimal(50));
		Item item12 = new Item(2, new BigDecimal(20), new BigDecimal(20));
		Item item13 = new Item(1, new BigDecimal(10), new BigDecimal(50));
		Item item14 = new Item(2, new BigDecimal(20), new BigDecimal(20));
		Item item15 = new Item(1, new BigDecimal(10), new BigDecimal(50));
		Item item16 = new Item(2, new BigDecimal(20), new BigDecimal(20));
		List<Item> items = new ArrayList<Item>();
		items.add(item1);
		items.add(item2);
		items.add(item3);
		items.add(item4);
		items.add(item5);
		items.add(item6);
		items.add(item7);
		items.add(item8);
		items.add(item9);
		items.add(item10);
		items.add(item11);
		items.add(item12);
		items.add(item13);
		items.add(item14);
		items.add(item15);
		items.add(item16);
		PackageData packageData = new PackageData(new BigDecimal(90), items);
		boolean valid = false;
		try {
			valid = PackageDataValidator.validate(packageData);
		} catch(BusinessException ex) {
		}
		assertFalse(valid);
	}

}
