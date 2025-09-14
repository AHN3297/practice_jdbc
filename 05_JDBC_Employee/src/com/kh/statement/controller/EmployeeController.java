package com.kh.statement.controller;

import java.util.List;

import com.kh.statement.model.dto.AddDTO;
import com.kh.statement.model.service.EmployeeService;
import com.kh.statement.model.vo.Employee;


public class EmployeeController {
	
	public List<Employee> findAll() {
			
			List<Employee> employees = new EmployeeService().findAll();
			
			return employees;
		}
	public List<Employee> findByDept(String dept) {
		
		List<Employee> employees = new EmployeeService().findByDept(dept);
		
		return employees;
	}
	
	public List<Employee> findByJob(String job) {
		
		List<Employee> employees = new EmployeeService().findByJob(job);
		
		return employees;
	}
	
	public Employee selectAll(int num) {
		return new EmployeeService().selectAll(num);
		
	}
	
	public int update(int empId, int salary, String deptCode, String jobCode) {
		Employee employee = new Employee();
		employee.setEmpId(empId);
		employee.setSalary(salary);
		employee.setDeptCode(deptCode);
		employee.setJobCode(jobCode);
		
		int result = new EmployeeService().update(employee);
		
		return result;
	}
	
	public int delete(int empId) {
		Employee employee = new Employee();
		employee.setEmpId(empId);
		
		
		int result = new EmployeeService().delete(employee);
		
		return result;
	}


}
