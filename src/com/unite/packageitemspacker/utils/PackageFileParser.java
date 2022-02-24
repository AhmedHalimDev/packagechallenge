package com.unite.packageitemspacker.utils;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.unite.packageitemspacker.exception.BusinessException;
import com.unite.packageitemspacker.model.PackageData;

public class PackageFileParser {

	private PackageFileParser() {
	}

	public static List<PackageData> parseInputFile(String fileName) {
		if (fileName == null || fileName.isEmpty()) {
			throw new BusinessException("Invalid file path, it may be null or empty.");
		}
		List<PackageData> packagesData = new ArrayList<>();
		try (Stream<String> stream = Files.lines(Paths.get(fileName), Charset.defaultCharset())) {
			List<String> inputDataLines = stream.collect(Collectors.toList());
			if (!inputDataLines.isEmpty()) {
				for (String inputLine : inputDataLines) {

					packagesData.add(PackageDataParser.parse(inputLine));
				}
			} else {
				throw new BusinessException("Invalid empty input file");
			}
			return packagesData;
		}
		catch (Exception e) {
			throw new BusinessException("Invalid input file, error in parsing.");
		}
	}
}
