package com.ds.format;


public class FormatHelperSpring implements FormatGenerator {
	FormatGenerator formatGenerator;

	public void generateFormat(){
		formatGenerator.generateFormat();
	}

	public FormatGenerator getFormatGenerator() {
		return formatGenerator;
	}

	public void setFormatGenerator(FormatGenerator formatGenerator) {
		this.formatGenerator = formatGenerator;
	}

	
}