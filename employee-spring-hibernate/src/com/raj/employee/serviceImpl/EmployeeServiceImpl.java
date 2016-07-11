package com.raj.employee.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.beans.EmployeeBean;
import com.raj.employee.dao.EmployeeDao;
import com.raj.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDao employeeDao;
	private static Logger logger = Logger.getLogger(EmployeeServiceImpl.class);
	
	@Override
	public String saveOrUpdateEmployee(EmployeeBean employee) {
		logger.info("saveOrUpdateEmployee serviceImpl");
		String status = null;
		try{
			status = employeeDao.saveOrUpdateEmployee(employee);
			logger.info("saveOrUpdateEmployee Status in serviceImpl"+status);
		}
		catch(Exception e){
			logger.error("Exception: "+e.getMessage());
		}
		return null;
	}

	@Override
	public List<EmployeeBean> getAllEmployee() {
		logger.info("getAllEmployee serviceImpl");
		List<EmployeeBean> employeeList = null;
		try{
			employeeList = employeeDao.getAllEmployee();
			System.out.println("Total Employee: "+employeeList.size());
		}
		catch(Exception e){
			logger.error("Exception: "+e.getMessage());
		}
		return employeeList;
	}

	@Override
	public EmployeeBean getEmployeeById(Integer id) {
		logger.info("getAllEmployee serviceImpl");
		EmployeeBean bean = null;
		try {
			bean = employeeDao.getEmployeeById(id);
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage());
		}
		return bean;
	}

	@Override
	public String deleteEmployee(Integer id) {
		logger.info("getAllEmployee serviceImpl");
		String status = null;
		try {
			status = employeeDao.deleteEmployee(id);
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage());
		}
		return status;
	}

}
