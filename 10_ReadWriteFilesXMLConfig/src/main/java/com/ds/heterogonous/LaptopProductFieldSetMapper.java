package com.ds.heterogonous;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class LaptopProductFieldSetMapper implements FieldSetMapper<LaptopProduct> {
	public LaptopProduct mapFieldSet(FieldSet fieldSet) throws BindException {
		LaptopProduct laptop = new LaptopProduct();
		laptop.setId(fieldSet.readString("PRODUCT_ID"));
		laptop.setName(fieldSet.readString("NAME"));
		laptop.setDescription(fieldSet.readString("DESCRIPTION"));
		laptop.setPrice(fieldSet.readBigDecimal("PRICE"));
		return laptop;
	}
}