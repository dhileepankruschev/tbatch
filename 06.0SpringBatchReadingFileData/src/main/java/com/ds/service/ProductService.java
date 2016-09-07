package com.ds.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ds.Product;
import com.google.gson.Gson;

@Service
public class ProductService {

	public List<Product> getProducts() {
		File file = new File("input/4-product.json");

		return fetchDataFromJson(file.getAbsolutePath());
	}

	private List<Product> fetchDataFromJson(String filePath) {
		Product[] products = null;
		try {
			StringBuffer jb = new StringBuffer();
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			products = new Gson().fromJson(reader, Product[].class);

		} catch (FileNotFoundException e) {
			System.out.println("File not found with path " + filePath);
		}
		return Arrays.asList(products);
	}

}
