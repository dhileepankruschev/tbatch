package com.spring.tx.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.tx.dao.TableTwoDao;
import com.spring.tx.entity.TableTwo;

@Service
public class TableTwoDaoImpl implements TableTwoDao {

	private EntityManager entityManager;

	@PersistenceContext(unitName="PersistenceUnit2")
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

//	@Override
	public void save(TableTwo tableTwo) throws Exception {
		entityManager.persist(tableTwo);
		
		
		
//		
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public void saveAnother(TableTwo tableTwo) throws Exception {
		
		entityManager.persist(tableTwo);
		throw new Exception("Force transaction rollback");
	}

}
