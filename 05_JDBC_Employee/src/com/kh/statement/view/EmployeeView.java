package com.kh.statement.view;

import java.util.List;
import java.util.Scanner;

import com.kh.statement.controller.EmployeeController;
import com.kh.statement.model.vo.Employee;

public class EmployeeView {
	Scanner sc = new Scanner(System.in);
	EmployeeController ec = new EmployeeController();
	
	/*
	 * 	1. 회원 전체 조회(사번, 사원명, 급여, 부서명, 직급명)
		-> JOB, DEPARTMENT JOIN
		findAll()
		2. 부서명을 입력받아 부서가 동일한 사원 조회(총무부 입력시 총무부인 사원들만 조회되도록)
		-> JOB JOIN
		findByDept()
		3. 직급명을 입력받아 직급이 동일한 사원 조회(과장 입력시 과장인 사원들만 조회되도록)
		-> DEPARTMENT JOIN
		findByJob()
		4. 사원 상세 조회(사번을 입력받아서 모든 컬럼 값 조회)
		selectAll()
		5. 급여가 높은 상위 다섯명 조회
		-> ROWNUM 또는 OFFSET 사용
		highSalary()
		6. 급여가 낮은 하위 다섯명 조회
		-> ROWNUM 또는 OFFSET 사용
		rowSalary()
		7. 사원 추가 기능
		addEmp()
		8. 사원 정보 수정(사번을 입력받아 급여, 직급, 부서 수정)
		update()
		9. 사원 퇴사 기능(사번을 입력받아 퇴사 여부, 퇴사일 수정)
		delete()
		모든 SQL문은 xml파일에서 입력받아 사용
		DBMS접속정보는 properties파일에서 입력받아 사용
	 */
	
	public void mainMenu() {
		while(true) {
			System.out.println("======= 사원 관리 시스템 =======");
			System.out.println("1. 회원 전체 조회");
			System.out.println("2. 부서명으로 사원조회");
			System.out.println("3. 직급명으로 사원조회");
			System.out.println("4. 사원 상세 조회");
			System.out.println("5. 급여높은 top5");
			System.out.println("6. 급여낮은 top5");
			System.out.println("7. 사원추가");
			System.out.println("8. 사원 정보 수정");
			System.out.println("9. 퇴사하기");
			System.out.println("0. 프로그램종료");
			System.out.println("메뉴선택ㄱㄱ > ");
			int menuNum = sc.nextInt();
			sc.nextLine();
			
			switch(menuNum) {
			case 1 : findAll(); break;
			case 2 : findByDept(); break;
			case 3 : findByJob(); break;
			case 4 : selectAll(); break;
			//case 5 : highSalary();break;
			//case 6 : rowSalary();break;
			case 7 : addEmp();break;
			case 8 : update();break;
			case 9 : delete();break;
			case 0 : System.out.println("종료할게~"); return;
			default : System.out.println("잘못된 입력값입니다.");
			}
			
		}
		
	}
	public void findAll() {
		System.out.println("\n회원전체 조회 페이지입니다.");
		List<Employee> employees = ec.findAll();
		// EmployeeController로 보내기
		System.out.println("조회된 사원 수는" + employees.size()+"명입니다.");
		if(employees.isEmpty()) {
			System.out.println("조회결과가 존재하지않습니다");
		} else {
			for(Employee employee : employees) {
				System.out.println("================================");
				System.out.println("사번 : " + employee.getEmpId() + ", ");
				System.out.println("사원명 : " + employee.getEmpName() + ", ");
				System.out.println("급여 : " + employee.getSalary() + ", ");
				System.out.println("부서명 : " + employee.getDeptTitle() + ", ");
				System.out.println("직급명 : " + employee.getJobName() + ", ");
				System.out.println("================================");
			}
		}
		
		
		
	}
	public void findByDept() {
		System.out.println("\n부서명으로 사원을 검색하는 페이지입니다.");
		System.out.println("부서명을 입력해주세요.");
		String dept = sc.nextLine();
		
		List<Employee> employees = ec.findByDept(dept);
		
		System.out.println("조회된 사원 수는" + employees.size()+"명입니다.");
		if(employees.isEmpty()) {
			System.out.println("조회결과가 존재하지않습니다");
		} else {
			for(Employee employee : employees) {
				System.out.println("================================");
				System.out.println("사번 : " + employee.getEmpId() + ", ");
				System.out.println("사원명 : " + employee.getEmpName() + ", ");
				System.out.println("급여 : " + employee.getSalary() + ", ");
				System.out.println("부서명 : " + employee.getDeptTitle() + ", ");
				System.out.println("직급명 : " + employee.getJobName() + ", ");
				System.out.println("================================");
			}
		}
		
		
	}
	
	public void findByJob() {
		System.out.println("\n직급명으로 사원을 검색하는 페이지입니다.");
		System.out.println("직급명을 입력해주세요.");
		String job = sc.nextLine();
		
		List<Employee> employees = ec.findByJob(job);
		
		System.out.println("조회된 사원 수는" + employees.size()+"명입니다.");
		if(employees.isEmpty()) {
			System.out.println("조회결과가 존재하지않습니다");
		} else {
			for(Employee employee : employees) {
				System.out.println("================================");
				System.out.println("사번 : " + employee.getEmpId() + ", ");
				System.out.println("사원명 : " + employee.getEmpName() + ", ");
				System.out.println("급여 : " + employee.getSalary() + ", ");
				System.out.println("부서명 : " + employee.getDeptTitle() + ", ");
				System.out.println("직급명 : " + employee.getJobName() + ", ");
				System.out.println("================================");
			}
		}
		
		
	}
	
	public void selectAll() {
		System.out.println("사원 상세 조회 페이지입니다.");
		System.out.println("사번을 입력ㄱㄱ > ");
		int num  = sc.nextInt();
		sc.nextLine();
		
		
		Employee employee = ec.selectAll(num);
		
		if(employee != null) {
			System.out.println("< "+num + "번 사원의 상세정보입니다. >");
			System.out.println("사번 : " + employee.getEmpId());
			System.out.println("이름 : " + employee.getEmpName());
			System.out.println("주민번호 : " + employee.getEmpNo());
			System.out.println("이메일 : " + employee.getEmail());
			System.out.println("휴대폰 번호 : " + employee.getPhone());
			System.out.println("부서 이름 : " + employee.getDeptTitle());
			System.out.println("직급 이름 : " + employee.getJobName());
			System.out.println("연봉 : " + employee.getSalary() * 12);
			System.out.println("급여 레벨 : " + employee.getSalLevel());
			System.out.println("보너스 : " + employee.getBonus());
			System.out.println("관리 번호 : " + employee.getManagerId());
			System.out.println("입사일 : " + employee.getHireDate());
			System.out.println("퇴사일 : " + employee.getEntDate());
			System.out.println("퇴사 여부 : " + employee.getEntYn());
			
		} else {
			System.out.println("조회 결과가 없습니다.");
			System.out.println("사번을 다시 확인해주세요.");
		}
		
		while(true) {
			System.out.println("목록으로 돌아가시려면 '돌아가기'를 입력해주세요");
			String exit = sc.nextLine();
			if("돌아가기".equals(exit)) {
				return;
			}
			
		}
		
	}
	public void addEmp() {
		System.out.println("--사원추가");
		
		
		
	}
	
	public void update() {
		System.out.println("\n회원정보 수정 서비스입니다.");
		// 아이디랑 비밀번호랑 새 비밀번호받아서
		// 아이디랑 비밀번호 있는거 있으면 새 비밀번호로 바꾸기
		
		System.out.println("사번을 입력해주세요");
		int empId = sc.nextInt();
		
		System.out.print("새 급여: ");
	    int salary = sc.nextInt();

	    System.out.print("새 부서코드: ");
	    String deptCode = sc.next();

	    System.out.print("새 직급코드: ");
	    String jobCode = sc.next();
		
		int result = ec.update(empId, salary, deptCode, jobCode);
		
		if(result >0) {
			 System.out.println("사원정보변경에 성공 ㅊㅊ");
		}else {
			 System.out.println("사원정보변경에 실패");
		}
	}
	
	public void delete() {
		System.out.println("잘가");
		System.out.println("사번을 입력해주세요");
		int empId = sc.nextInt();
		sc.nextLine();
		int result = ec.delete(empId);
		if(result > 0) {
			System.out.println("성공하였습니다.");
		} else {
			System.out.println("실패하였습니다.");
		}
		
		
	}
	


}
