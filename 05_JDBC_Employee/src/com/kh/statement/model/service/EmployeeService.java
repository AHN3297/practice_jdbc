package com.kh.statement.model.service;

import static com.kh.common.JDBCTemplate.close;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.common.JDBCTemplate;
import com.kh.common.Template;
import com.kh.statement.model.dao.EmployeeDao;
import com.kh.statement.model.vo.Employee;

public class EmployeeService {
	private EmployeeDao employeeDao = new EmployeeDao();
	
	public List<Employee> findAll() {
		SqlSession session = Template.getSqlSession();
		List<Employee> employee = employeeDao.findAll(session);
		session.close();
		return employee;
		
	}
	public List<Employee> findByDept(String dept){
		SqlSession session = Template.getSqlSession();
		List<Employee> employees = employeeDao.findByDept(session, dept);
		session.close();
		return employees;
		
		
	}
	
	public List<Employee> findByJob(String job){
		SqlSession session = Template.getSqlSession();
		List<Employee> employees = employeeDao.findByJob(session, job);
		session.close();
		return employees;
		
	}
	
	public Employee selectAll(int num) {
		SqlSession session = Template.getSqlSession();
		Employee employee = employeeDao.selectAll(session, num);
		session.close();
		return employee;
	}
	
	public int update(Employee employee) {
		SqlSession session = Template.getSqlSession();
		int result = employeeDao.update(session, employee);
		if(result > 0) {
			session.commit();
		}
		session.close();
		return result;
	}
	
	public int delete(Employee employee) {
		SqlSession session = Template.getSqlSession();
		int result = employeeDao.delete(session, employee);
		if(result > 0) {
			session.commit();
		}
		session.close();
		return result;
	}
	/*
	
	public List<Employee> findByDept(String dept){
		
		return executeQuery(conn -> new EmployeeDao().findByDept(conn,dept));
	}
	
	public List<Employee> findByJob(String job){
		
		return executeQuery(conn -> new EmployeeDao().findByJob(conn,job));
	}
	
	public Employee selectAll(int num) {
		Employee employee =null;
		if(num > 0) {
			employee = new EmployeeDao().selectAll(conn , num);
		}
		JDBCTemplate.close(conn);
		
		return employee;
	}
	public int update(Employee employee) {
		int result = new EmployeeDao().update(conn, employee);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}
		close(conn);
		
		return result;
	} 
	
	public int delete(Employee employee) {
		int result = new EmployeeDao().delete(conn, employee);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}
		close(conn);
		
		return result;
	}
	*/
	

}
