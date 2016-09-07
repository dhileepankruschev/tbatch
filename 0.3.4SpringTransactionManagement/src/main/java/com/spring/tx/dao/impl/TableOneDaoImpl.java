package com.spring.tx.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.tx.dao.TableOneDao;
import com.spring.tx.dao.TableTwoDao;
import com.spring.tx.entity.TableOne;
import com.spring.tx.entity.TableTwo;

@Service
public class TableOneDaoImpl implements TableOneDao {
	
	@Autowired
	private TableTwoDao tableTwoDao;

	private EntityManager entityManager;

	@PersistenceContext(unitName="PersistenceUnit1")
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

		
//	@Override
	public void save(TableOne tableOne) {
		entityManager.persist(tableOne);
		TableTwo table2 = new TableTwo();
		table2.setValue("value3");
		
		try {
			tableTwoDao.saveAnother(table2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
