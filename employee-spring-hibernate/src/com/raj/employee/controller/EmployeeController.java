package com.raj.employee.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.raj.beans.EmployeeBean;
import com.raj.employee.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeSerivce;
	
	private static Logger logger = Logger.getLogger(EmployeeController.class);
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Model model){
		logger.info("home controller");
		try{
			model.addAttribute("employee", new EmployeeBean());
			model.addAttribute("employeeList", employeeSerivce.getAllEmployee());
		}
		catch(Exception e){
			logger.error("Exception: "+e.getMessage());
		}
		return "employee";
	}
	
	
	@RequestMapping(value="/saveOrUpdateEmployee", method=RequestMethod.POST)
	public String saveOrUpdateEmployee(@ModelAttribute("employee") EmployeeBean employee){
		logger.info("saveOrUpdateEmployee controller");
		try{
			String status = employeeSerivce.saveOrUpdateEmployee(employee);
			logger.info("Status of saveOrUpdate: "+status);
		}
		catch(Exception e){
			logger.error("Exception: "+e.getMessage());
		}
		return "redirect:/";
	}
	
	@RequestMapping(value="/updateEmployee/{id}", method=RequestMethod.GET)
	public String getEmployeeById(@PathVariable("id")Integer id, Model model){
		logger.info("getEmployeeById in controller");
		String status = null;
		EmployeeBean bean = null;
		try {
			bean = employeeSerivce.getEmployeeById(id);
			if(null == bean){
				status = "redirect:/";
			}
			else{
				model.addAttribute("employee", bean);
				status = "employee";
			}
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage());
		}
		return status;
	}
	
	@RequestMapping(value="/deleteEmployee/{id}", method=RequestMethod.GET)
	public String deleteEmployee(@PathVariable("id")Integer id){
		logger.info("deleteEmployee in controller");
		try {
			String status = employeeSerivce.deleteEmployee(id);
			logger.info("deleteEmployee Status: "+status);
		} catch (Exception e) {
			logger.error("Exception : "+e.getMessage());
		}
		return "redirect:/";
	}
}
