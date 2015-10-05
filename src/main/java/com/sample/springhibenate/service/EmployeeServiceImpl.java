package com.sample.springhibenate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.springhibenate.dao.EmployeeDAO;
import com.sample.springhibenate.vo.EmployeeVO;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
    private EmployeeDAO employeeDAO;

	@Override
	@Transactional
	public void addEmployee(EmployeeVO employee) {
		employeeDAO.addEmployee(employee);
	}

	@Override
	@Transactional
	public List<EmployeeVO> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}

	@Override
	@Transactional
	public void deleteEmployee(Integer employeeId) {
		employeeDAO.deleteEmployee(employeeId);
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
}
