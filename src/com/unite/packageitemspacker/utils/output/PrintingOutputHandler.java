package com.unite.packageitemspacker.utils.output;

import java.util.List;
import java.util.stream.Collectors;

import com.unite.packageitemspacker.model.Item;

public class PrintingOutputHandler implements OutputFormatterAPI {

	private static final String DEFAULT_EMPTY_VALUE = "-";

	@Override
	public void output(List<Item> items) {
		String output = items.stream().map(Item::getId).map(String::valueOf).collect(Collectors.joining(", "));
		System.out.println(output.isEmpty() ? DEFAULT_EMPTY_VALUE : output);
	}

}