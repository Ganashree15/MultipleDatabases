package com.service;

import com.model.EmployeeA;
import com.model.EmployeeB;

public interface EmployeeService {

	void persistEmployees(EmployeeA employeeA, EmployeeB employeeB) throws Exception;

}
