package com.spring.tx.dao;

import com.spring.tx.entity.TableTwo;

public interface TableTwoDao {

	void save(TableTwo tableTwo) throws Exception;
	void saveAnother(TableTwo tableTwo) throws Exception;
	
}
