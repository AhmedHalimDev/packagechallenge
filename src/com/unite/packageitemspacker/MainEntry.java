package com.unite.packageitemspacker;

import com.unite.packageitemspacker.service.PackageChallengeProcessor;

public class MainEntry {
	public static void main(String[] args) {
		PackageChallengeProcessor.getInstance().process("resources\\packages.txt");
	}
}