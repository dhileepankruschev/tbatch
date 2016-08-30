package com.ds.readers;

import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.ds.Product;

public class R3_XmlFileReader {
	public static StaxEventItemReader<Product> getReader(){
		StaxEventItemReader<Product> reader = new StaxEventItemReader<Product>();
		reader.setResource(new ClassPathResource("input/3-product.xml"));
		reader.setFragmentRootElementName("product");
		reader.setUnmarshaller(getProductUnmarshallerJax2());
		return reader;
	}

	private static Jaxb2Marshaller getProductUnmarshallerJax2() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(Product.class);
		
		return marshaller;
	}
	
}
