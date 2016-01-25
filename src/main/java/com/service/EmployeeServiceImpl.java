package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EmployeeADAO;
import com.dao.EmployeeBDAO;
import com.model.EmployeeA;
import com.model.EmployeeB;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeADAO employeeADAO;

	@Autowired
	EmployeeBDAO employeeBDAO;

	@Override
	public void persistEmployees(EmployeeA employeeA, EmployeeB employeeB) throws Exception {
		System.out.println("Persist A");

		employeeADAO.persistEmployee(employeeA);
		System.out.println("Persist A OK - persist B");
		employeeBDAO.persistEmployee(employeeB);
		System.out.println("Persist B okk");

	}

}
