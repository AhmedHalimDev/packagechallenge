package com.unite.packageitemspacker.service;

import java.util.List;

import com.unite.packageitemspacker.model.PackageData;
import com.unite.packageitemspacker.utils.PackageDataValidator;
import com.unite.packageitemspacker.utils.PackageFileParser;
import com.unite.packageitemspacker.utils.output.OutputFormatterAPI;
import com.unite.packageitemspacker.utils.output.PrintingOutputHandler;

public class PackageChallengeProcessor {

	private static final PackageChallengeProcessor INSTANCE = new PackageChallengeProcessor();
	private static final OutputFormatterAPI outputFormatter = new PrintingOutputHandler();

	private PackageChallengeProcessor() {
	}

	public static PackageChallengeProcessor getInstance() {
		return INSTANCE;
	}

	public void process(String fileName) {
		List<PackageData> packagesData = PackageFileParser.parseInputFile(fileName);
		packagesData.stream().forEach(packageData -> PackageDataValidator.validate(packageData));
		for (PackageData packageData : packagesData) {
			PackageTargetItemsResolver.resolvePackageItems(packageData, packageData.getItems());
			outputFormatter.output(packageData.getItems());
		}
	}
}
