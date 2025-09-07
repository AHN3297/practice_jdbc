package com.kh.statement.model.dto;

import java.util.Objects;

public class AddDTO {
	private int empId;
	private String newSalary;
	private String newDeptCode;
	private String newJobCode;
	public AddDTO(int empId, String newSalary, String newDeptCode, String newJobCode) {
		super();
		this.empId = empId;
		this.newSalary = newSalary;
		this.newDeptCode = newDeptCode;
		this.newJobCode = newJobCode;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getNewSalary() {
		return newSalary;
	}
	public void setNewSalary(String newSalary) {
		this.newSalary = newSalary;
	}
	public String getNewDeptCode() {
		return newDeptCode;
	}
	public void setNewDeptCode(String newDeptCode) {
		this.newDeptCode = newDeptCode;
	}
	public String getNewJobCode() {
		return newJobCode;
	}
	public void setNewJobCode(String newJobCode) {
		this.newJobCode = newJobCode;
	}
	@Override
	public String toString() {
		return "AddDTO [empId=" + empId + ", newSalary=" + newSalary + ", newDeptCode=" + newDeptCode + ", newJobCode="
				+ newJobCode + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(empId, newDeptCode, newJobCode, newSalary);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddDTO other = (AddDTO) obj;
		return empId == other.empId && Objects.equals(newDeptCode, other.newDeptCode)
				&& Objects.equals(newJobCode, other.newJobCode) && Objects.equals(newSalary, other.newSalary);
	}
	
	
	

}
