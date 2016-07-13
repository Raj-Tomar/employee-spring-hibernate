package com.raj.employee.daoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.raj.beans.EmployeeBean;
import com.raj.employee.dao.EmployeeDao;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	 @Autowired
	 private SessionFactory sessionFactory;
	 private Session session = null;
	 private Transaction tx = null;
	 
	 private static Logger logger = Logger.getLogger(EmployeeDaoImpl.class);

	@Override
	public String saveOrUpdateEmployee(EmployeeBean employee) {
		logger.info("saveOrUpdateEmployee daoImpl");
		String status = "0";
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			if(null == employee.getId()){
				session.save(employee);
				tx.commit();
				status = "1";
			}else{
				session.update(employee);
				tx.commit();
				status = "1";
			}
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage());
		}
		return status;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<EmployeeBean> getAllEmployee() {
		logger.info("getAllEmployee daoImpl");
		List<EmployeeBean> list = null;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("From EmployeeBean");
			list = query.getResultList();
			logger.info("Total Employee: "+list.size());
		}
		catch(Exception e){
			logger.error("Exception: "+e.getMessage());
		}
		return list;
	}

	@Override
	public EmployeeBean getEmployeeById(Integer id) {
		logger.info("getEmployeeById daoImpl");
		EmployeeBean bean = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			bean = session.get(EmployeeBean.class, id);
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage());
		}
		return bean;
	}

	@Override
	public String deleteEmployee(Integer id) {
		logger.info("deleteEmployee daoImpl");
		String status = "0";
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			EmployeeBean bean = session.load(EmployeeBean.class, id);
			if(null != bean){
				session.delete(bean);
				tx.commit();
				status = "1";
			}
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage());
		}
		return status;
	}

}
