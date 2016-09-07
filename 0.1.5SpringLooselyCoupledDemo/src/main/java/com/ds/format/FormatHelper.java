package com.ds.format;

import com.ds.format.impl.JsonFormatGenerator;

public class FormatHelper implements FormatGenerator {
	FormatGenerator formatGenerator;

	public FormatHelper(){
		formatGenerator = new JsonFormatGenerator();
	}

	public void generateFormat(){
		formatGenerator.generateFormat();
	}

}