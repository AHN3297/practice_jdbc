package com.kh.statement.view;

import java.util.List;
import java.util.Scanner;

import com.kh.statement.controller.MusicController;
import com.kh.statement.model.vo.Music;

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
			System.out.println("6. 음악 이름 변경하기");
			System.out.println("7. 음악 삭제하기");
			System.out.println("9. 프로그램 종료");
			System.out.println("메뉴 번호를 입력해주세요 > ");
			int menuNo= sc.nextInt();
			sc.nextLine();
			
			switch(menuNo) {
			case 1 : plusMusic(); break;
			case 2 : findAll(); break;
			case 3 : findByName(); break;
			case 4 : findBySinger(); break;
			case 5 : findByGenre();break;
			case 6 : update(); break;
			case 7 : delete(); break;
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
		String releaseDate = sc.nextLine();
		
		int result = mc.plusMusic(musicName, singer, genre, playTime, albumSell, releaseDate);
		
		if(result > 0 ) {
			System.out.println("음악추가에 성공했습니다.");
		} else {
			System.out.println("음악추가에 실패하였습니다.");
		}
		
	}
	public void findAll() {
		
		System.out.println("\n === 전체 음악 조회 === ");
		List<Music> musics = mc.findAll();
		
		System.out.println("\n조회된 총 음악수는 " + musics.size() + "입니다.");
		if(musics.isEmpty()) {
			System.out.println("조회결과가 존재하지않습니다.");
		} else {
			for(Music music : musics) {
				System.out.println("=====================================");
				System.out.println(music.getMusicNum() + "번 음악");
				System.out.println("음악 : "+ music.getMusicName() + ", ");
				System.out.println("가수 : " + music.getSingerName() + ", ");
				System.out.println("장르 : " + music.getGenreName() + ", ");
				System.out.println("재생시간 : "+ music.getPlayTime() + ", ");
				System.out.println("앨범 총 판매수(집계되지않으면 0) : "+ music.getAlbumSell() + ", ");
				System.out.println("앨범(노래) 발매일 : " + music.getReleaseDate() + ", ");
				System.out.println("=====================================");
			}
		}
	}
	public void findByName() {
		System.out.println("\n노래 이름 키워드로 검색");
		System.out.println("검색하고자 하는 키워드를 입력해주세요 >");
		String name = sc.nextLine();
		
		List<Music> musics = mc.findByName(name);
		//뷰에서는 뭘해줘야하나
		if(musics.isEmpty()) {
			System.out.println("조회결과가 존재하지않습니다.");
		}else {
			for(int i = 0; i <musics.size(); i++) {
				System.out.println(musics.get(i));
			}
			
		}
		
	}
	
	public void findBySinger() {
		System.out.println("\n 가수 이름으로 검색하는 서비스 입니다.");
		System.out.print("가수를 입력해주세요 > ");
		String singerName = sc.nextLine();
		
		Music singer = mc.findBySinger(singerName);
		
		if(singer != null) {
			System.out.println(singerName+ "님의 검색 결과 입니다.");
			System.out.println("========================================");
			System.out.println("노래 제목 : " + singer.getMusicName() + ", ");
			System.out.println("가수 이름 : " + singer.getSingerName() + ", ");
			System.out.println("장르 : " + singer.getGenreName() + ", ");
			System.out.println("재생시간 : " + singer.getPlayTime() + ", ");
			System.out.println("앨범 총 판매수(집계되지않으면 0) : " + singer.getPlayTime());
			System.out.println("앨범(노래) 발매일 : " + singer.getReleaseDate() + ", ");
			System.out.println("========================================");
			System.out.println();
			
		}else {
			System.out.println("가수 이름이 존재하지 않습니다");
		}
		
	}
	
	public void findByGenre() {
		System.out.println("\n 장르로 검색하는 서비스 입니다.");
		System.out.print("노래 장르를 입력해주세요 > ");
		String genreName = sc.nextLine();
		
		Music genre = mc.findByGenre(genreName);
		
		if(genre != null) {
			System.out.println(genreName+ "님의 검색 결과 입니다.");
			System.out.println("========================================");
			System.out.println("노래 제목 : " + genre.getMusicName() + ", ");
			System.out.println("가수 이름 : " + genre.getSingerName() + ", ");
			System.out.println("장르 : " + genre.getGenreName() + ", ");
			System.out.println("재생시간 : " + genre.getPlayTime() + ", ");
			System.out.println("앨범 총 판매수(집계되지않으면 0) : " + genre.getAlbumSell());
			System.out.println("앨범(노래) 발매일 : " + genre.getReleaseDate() + ", ");
			System.out.println("========================================");
			System.out.println();
			
		}else {
			System.out.println("해당 장르의 음악이 존재하지 않습니다");
		}
		
	}
	public void update() {
		System.out.println("\n노래제목 수정 서비스입니다.");
		
		System.out.println("노래제목을 입력해주세요");
		String musicName = sc.nextLine();
		System.out.println("가수를 입력해주세요");
		String singer = sc.nextLine();
		System.out.println("새 노래제목을 입력해주세요");
		String newMusicName = sc.nextLine();
	
	int result = mc.update(musicName, singer, newMusicName);
	
	 if(result >0) {
		 System.out.println("비밀번호변경에 성공 ㅊㅊ");
	 }else {
		 System.out.println("비밀번호변경에 실패");
	 }
	}
	
	public void delete() {
		System.out.println("\n빠이");
		System.out.println("노래제목을 입력해주세요");
		String musicName = sc.nextLine();
		System.out.println("가수를 입력해주세요");
		String singer = sc.nextLine();
		
		int result = mc.delete(musicName, singer);
		if(result > 0) {
			System.out.println("성공했습니다.");
		}else {
			System.out.println("실패했습니다.");
		}
	}
	
	
	
}