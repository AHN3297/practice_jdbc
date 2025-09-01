package com.kh.statement.view;

import java.sql.Date;
import java.util.Scanner;

import com.kh.statement.controller.MusicController;

public class MusicView {
	// View -> Controller -> Dao 로 보낸다
	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();
	
	/**
	 * 메인메뉴 출력
	 */
	public void mainmenu() {
		/*
		 * 음악번호(int)
		 * 음악이름(String)
			가수이름(String)
			장르(String)
			재생시간(String / 5:45)
			앨범판매수(inst)
			발매일(date)
		 */
		
		while(true) {
			System.out.println("==== 음악 관리 프로그램 ====");
			System.out.println("1. 음악 추가");
			System.out.println("2. 음악 전체 조회");
			System.out.println("3. 음악 이름으로 조회");
			System.out.println("4. 가수 이름으로 조회");
			System.out.println("5. 장르로 조회");
			System.out.println("6. 음악 정보 변경하기");
			System.out.println("7. 음악 삭제하기");
			System.out.println("9. 프로그램 종료");
			System.out.println("메뉴 번호를 입력해주세요 > ");
			int menuNo= sc.nextInt();
			sc.nextLine();
			
			switch(menuNo) {
			case 1 : plusMusic();break;
			case 2 : break;
			case 3 : break;
			case 4 : break;
			case 5 : break;
			case 6 : break;
			case 7 : break;
			case 9 : System.out.println("프로그램을 종료합니다."); return;
			default : System.out.println("잘못된 메뉴 선택입니다.");
			
			}
			
		}
		
	}
	/**
	 * Music 테이블에 ISERT할 값을 사용자가 입력받는 화면 출력
	 * 
	 * 컬럼에 INSERT할 값들을 모두 입력받은 후 입력받은 값 컨트롤러로 전달
	 */
	public void plusMusic() {
		System.out.println("==== 음악 추가 ====");
		
		System.out.println("음악의 이름을 입력해주세요 > ");
		String musicName = sc.nextLine();
		System.out.println("가수의 이름을 입력해주세요");
		String singer = sc.nextLine();
		System.out.println("장르를 입력해주요");
		String genre = sc.nextLine();
		System.out.println("재생시간을 입력해주세요 예) 5분30초 > ");
		String playTime = sc.nextLine();
		System.out.println("앨범 판매수를 입력해주세요");
		int albumSell = sc.nextInt();
		sc.nextLine();
		System.out.print("발매 날짜를 입력해주세요 (예: 2021-05-17) > ");
		Date releaseDate = Date.valueOf(sc.nextLine());
		
		int result = mc.plusMusic(musicName, singer, genre, playTime, albumSell, releaseDate);
		
		if(result > 0 ) {
			System.out.println("음악추가에 성공했습니다.");
		} else {
			System.out.println("음악추가에 실패하였습니다.");
		}
		
	}
	
	
	
}
