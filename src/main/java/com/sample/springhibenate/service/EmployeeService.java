package com.sample.springhibenate.service;

import java.util.List;

import com.sample.springhibenate.vo.EmployeeVO;

public interface EmployeeService {
	public void addEmployee(EmployeeVO employee);
    public List<EmployeeVO> getAllEmployees();
    public void deleteEmployee(Integer employeeId);
}
