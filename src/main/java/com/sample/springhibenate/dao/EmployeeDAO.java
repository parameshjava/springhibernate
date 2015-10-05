package com.sample.springhibenate.dao;

import java.util.List;
import com.sample.springhibenate.vo.EmployeeVO;

public interface EmployeeDAO {
	
	public void addEmployee(EmployeeVO employee);

	public List<EmployeeVO> getAllEmployees();

	public void deleteEmployee(Integer employeeId);
}