package com.sample.springhibenate.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sample.springhibenate.vo.EmployeeVO;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDaoImpl.class);

	@Override
	public void addEmployee(EmployeeVO employee) {
		this.sessionFactory.getCurrentSession().save(employee);
		LOGGER.info("Inserted Employee information : {}", employee);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeVO> getAllEmployees() {
		LOGGER.info("Getting the list of employees to display....");
		return this.sessionFactory.getCurrentSession().createQuery("from EmployeeVO").list();
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		LOGGER.info("Trying to load employee with id : {} before delete...");
		EmployeeVO employee = (EmployeeVO) sessionFactory.getCurrentSession().load(EmployeeVO.class, employeeId);
		if (null != employee) {
			this.sessionFactory.getCurrentSession().delete(employee);
			LOGGER.info("Employee with id : {} found and dleted successfully...", employeeId);
		} else {
			LOGGER.info("Employee with id : {} was not found to delete", employeeId);
		}
	}
}
