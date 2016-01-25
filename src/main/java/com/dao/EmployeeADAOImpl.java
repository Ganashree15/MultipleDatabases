package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.EmployeeA;

@Service
public class EmployeeADAOImpl implements EmployeeADAO {

	@PersistenceContext(unitName = "PersistenceUnitA")
	private EntityManager entityManager;

	@Transactional("transactionManagerA")
	@Override
	public void persistEmployee(EmployeeA employee) {
		entityManager.persist(employee);
	}

}