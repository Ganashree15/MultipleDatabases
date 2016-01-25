package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.EmployeeB;

@Service
public class EmployeeBDAOImpl implements EmployeeBDAO {

	@PersistenceContext(unitName = "PersistenceUnitB")
	private EntityManager entityManager;

	@Transactional("transactionManagerB")
	@Override
	public void persistEmployee(EmployeeB employee) throws Exception {
		entityManager.persist(employee);
		// throw new Exception();
	}
}