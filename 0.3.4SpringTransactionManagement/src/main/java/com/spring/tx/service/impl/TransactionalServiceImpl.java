package com.spring.tx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.tx.dao.TableOneDao;
import com.spring.tx.dao.TableTwoDao;
import com.spring.tx.entity.TableOne;
import com.spring.tx.entity.TableTwo;
import com.spring.tx.service.TransactionalService;

@Service
public class TransactionalServiceImpl implements TransactionalService {

	@Autowired
	private TableOneDao tableOneDao;
	
	@Autowired
	private TableTwoDao tableTwoDao;
	
//	@Override
	@Transactional(rollbackFor=Exception.class)
	public void persist(TableOne tableOne, TableTwo tableTwo) throws Exception {
		
		tableOneDao.save(tableOne);
		tableTwoDao.save(tableTwo);
	}

}
