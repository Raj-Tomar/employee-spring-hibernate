package com.raj.employee.service;

import java.util.List;

import com.raj.beans.EmployeeBean;

public interface EmployeeService {

	public String saveOrUpdateEmployee(EmployeeBean employee);
	public List<EmployeeBean> getAllEmployee();
	public EmployeeBean getEmployeeById(Integer id);
	public String deleteEmployee(Integer id);
}
