package com.kh.statement.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.statement.model.vo.Employee;


public class EmployeeDao {
	public List<Employee> findAll(SqlSession session){
		return session.selectList("employeeMapper.findAll");
	}
	
	public List<Employee> findByDept(SqlSession session, String dept){
		return session.selectList("employeeMapper.findByDept", dept);
	}
	
	public List<Employee> findByJob(SqlSession session, String job){
		return session.selectList("employeeMapper.findByJob", job);
	}
	
	public Employee selectAll(SqlSession session, int num){
		return session.selectOne("employeeMapper.selectAll",num);
		
	}
	
	public int update(SqlSession session, Employee employee) {
		return session.update("employeeMapper.update", employee);
	}
	
	public int delete(SqlSession session, Employee employee) {
		return session.delete("employeeMapper.delete", employee);
	}
	/*
	
	private Properties prop = new Properties();
	
	public EmployeeDao(){
		try {
			prop.loadFromXML(new FileInputStream("resources/employee-Mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Employee> findAll(Connection conn) {
		List<Employee> employees = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("findAll");
		System.out.println("성공!");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Employee employee = new Employee(rset.getInt("EMP_ID")
										  ,rset.getString("EMP_NAME")
										  ,rset.getInt("SALARY")
										  ,rset.getString("DEPT_TITLE")
										  ,rset.getString("JOB_NAME"));
										  
				employees.add(employee);
				                          
			}
			rset = pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return employees;
	}
	
	public List<Employee> findByDept(Connection conn, String dept){
		
		List<Employee> employees = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("findByDept");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  dept);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Employee employee = new Employee(rset.getInt("EMP_ID")
										  ,rset.getString("EMP_NAME")
										  ,rset.getInt("SALARY")
										  ,rset.getString("DEPT_TITLE")
										  ,rset.getString("JOB_NAME"));	 
				employees.add(employee);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		return employees;
	}
	
	public List<Employee> findByJob(Connection conn, String job){
			
			List<Employee> employees = new ArrayList();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("findByJob");
			System.out.println("성공?");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,  job);
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					Employee employee = new Employee(rset.getInt("EMP_ID")
											  ,rset.getString("EMP_NAME")
											  ,rset.getInt("SALARY")
											  ,rset.getString("DEPT_TITLE")
											  ,rset.getString("JOB_NAME"));	 
					employees.add(employee);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			
			
			return employees;
		}
	
	public Employee selectAll(Connection conn, int num) {
		Employee employee = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAll");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  num);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				 employee = new Employee(rset.getInt("EMP_ID")
										,rset.getString("EMP_NAME")
										,rset.getString("EMP_NO")
										,rset.getString("EMAIL")
										,rset.getString("PHONE")
										,rset.getString("DEPT_TITLE")
										,rset.getString("JOB_NAME")
										,rset.getInt("SALARY")
										,rset.getString("SAL_LEVEL")
										,rset.getDouble("BONUS")
										,rset.getInt("MANAGER_ID")
										,rset.getString("HIRE_DATE")
										,rset.getString("ENT_DATE")
										,rset.getString("ENT_YN")
										);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return employee;
		
		
		
	}
	
	public int update(Connection conn, Employee employee) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("update");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  employee.getSalary());
			pstmt.setString(2,  employee.getDeptCode());
			pstmt.setString(3,  employee.getJobCode());
			pstmt.setInt(4,  employee.getEmpId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int delete(Connection conn, Employee employee) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("delete");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  employee.getEmpId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	*/

}
