package com.ds.heterogonous;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class MobileProductFieldSetMapper implements FieldSetMapper<MobileProduct> {
	public MobileProduct mapFieldSet(FieldSet fieldSet) throws BindException {
		MobileProduct mobile = new MobileProduct();
		mobile.setId(fieldSet.readString("PRODUCT_ID"));
		mobile.setName(fieldSet.readString("NAME"));
		mobile.setDescription(fieldSet.readString("DESCRIPTION"));
		mobile.setPrice(fieldSet.readBigDecimal("PRICE"));
		return mobile;
	}
}