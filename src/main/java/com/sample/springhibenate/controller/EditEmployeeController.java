package com.sample.springhibenate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sample.springhibenate.service.EmployeeService;
import com.sample.springhibenate.vo.EmployeeVO;

@Controller
public class EditEmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EditEmployeeController.class);

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listEmployees(ModelMap map) {
		LOGGER.info("Retiieving all employees to show...");
		map.addAttribute("employee", new EmployeeVO());
		map.addAttribute("employeeList", employeeService.getAllEmployees());

		return "editEmployeeList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute(value = "employee") EmployeeVO employee, BindingResult result) {
		LOGGER.info("Adding new employee to organization : {}", employee);
		if(result.hasErrors()) {
			return "redirect:/";
		}
		employeeService.addEmployee(employee);
		return "redirect:/";
	}

	@RequestMapping("/delete/{employeeId}")
	public String deleteEmplyee(@PathVariable("employeeId") Integer employeeId) {
		LOGGER.info("Trying to delete employee with employeeId : {}", employeeId);
		employeeService.deleteEmployee(employeeId);
		return "redirect:/";
	}

	public void setEmployeeManager(EmployeeService employeeManager) {
		this.employeeService = employeeManager;
	}
}
