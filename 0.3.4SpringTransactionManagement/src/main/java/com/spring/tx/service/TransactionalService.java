package com.spring.tx.service;

import com.spring.tx.entity.TableOne;
import com.spring.tx.entity.TableTwo;

public interface TransactionalService {

	void persist(TableOne tableOne, TableTwo tableTwo) throws Exception;
	
}
