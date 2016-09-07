package com.ds.test;

import com.ds.format.FormatGenerator;
import com.ds.format.impl.JsonFormatGenerator;
import com.ds.format.impl.XmlFormatGenerator;

public class Main_01 {

	/*
	the problem is the “format” is coupled tightly to JsonFormatGenerator
	*/
	public static void main(String[] args) {
		FormatGenerator format = new JsonFormatGenerator();
		format.generateFormat();
		
	}

}
