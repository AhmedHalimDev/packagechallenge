package com.unite.packageitemspacker.utils.output;

import java.util.List;

import com.unite.packageitemspacker.model.Item;

@FunctionalInterface
public interface OutputFormatterAPI {

	void output(List<Item> items);

}
