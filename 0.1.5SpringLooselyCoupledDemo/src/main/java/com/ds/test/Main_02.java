package com.ds.test;

import com.ds.format.FormatHelper;

public class Main_02 {
	
	/*
	 * you only need to manage a single helper class
	 * 
	 * however the helper class is still tightly coupled to JsonFormatGenerator
	 */
	public static void main(String[] args) {
		FormatHelper format = new FormatHelper();
		format.generateFormat();
	}
}
