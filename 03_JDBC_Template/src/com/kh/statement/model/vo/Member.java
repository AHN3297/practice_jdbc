package com.kh.statement.model.vo;

import java.sql.Date;
import java.util.Objects;

/*
 * VO(Value Object) => 값 객체
 * => 테이블의 한 행에 대한 데이터를 기록할 저장용 객체
 * 
 * VO가 가져야할 특성 = 불변성
 * 
 * VO클래스의 필드 구성 자체를MEMBER테이블의 컬럼들과 유사하게 구성
 * SEQUENCE및 DEFAULT값을 조건으로 사용하는 경우
 * 해당 필드를 제외한 나머지 필드값을 초기화 할 수 있는 생성자를 추가로 구성해둘것
 */

public class Member {
	private int userNo; // USERNO NUMBER PRIMARY KEY,
    private String userId; //USERID VARCHAR2(15) UNIQUE NOT NULL,
    private String userPwd; //USERPWD VARCHAR2(20) NOT NULL,
    private String userName; //USERNAME VARCHAR2(15) NOT NULL,
    private String Email;  //EMAIL VARCHAR2(30),
    private Date enrollDate; //ENROLLDATE DATE DEFAULT SYSDATE NOT NULL
    // DB의  테이블을 참고하여 컬럼과 유사하게 구성
    
	
    public Member(String userId, String userPwd, String userName, String email) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.Email = email;
	}
    
	
	public Member() {
		super();
	}


	public Member(int userNo, String userId, String userPwd, String userName, String email, Date enrollDate) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.Email = email;
		this.enrollDate = enrollDate;
	}


	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", Email=" + Email + ", enrollDate=" + enrollDate + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(Email, enrollDate, userId, userName, userNo, userPwd);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(Email, other.Email) && Objects.equals(enrollDate, other.enrollDate)
				&& Objects.equals(userId, other.userId) && Objects.equals(userName, other.userName)
				&& userNo == other.userNo && Objects.equals(userPwd, other.userPwd);
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
    
}
