package com.kh.board.view;

import java.util.List;
import java.util.Scanner;

import com.kh.board.controller.BoardController;
import com.kh.board.model.dto.BoardDTO;
import com.kh.board.model.vo.Board;

public class BoardView {
	/*
	 * 
	 * SELECT / INSERT / UPDATE / DELETE
	 * 
	 * BOARD를 예시로 들어보겠음
	 * 
	 * INSERT : insertBoard()
	 * UPDATE : updateBoard()
	 * DELETE : deleteBoard()
	 * SELECT(다수행) : selectBoardList()
	 * SELECT (단일행: selectBoard()
	 * ------------------------------------------
	 * 
	 * INSERT : save
	 * UPDATE : update
	 * DELETE : delete
	 * SELECT(다수행) : 
	 * SELECT(단일행) : 
	 * 
	 */
	private Scanner sc = new Scanner(System.in);
	private BoardController bc = new BoardController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("게시판기능입니다.");
			// 전체 게시글 목록 조회
			selectBoardList();
			
			System.out.println("\n========================================");
			System.out.println("1. 게시글 상세조회");
			System.out.println("2. 게시글 작성하기");
			System.out.println("3. 게시글 삭제하기");
			System.out.println("9. 회원 메뉴로 돌아가기");
			System.out.print("메뉴를 선택해주세요");
			int menuNo = sc.nextInt();
			sc.nextLine();
			switch(menuNo) {
			case 1 : selectBoard();break;
			case 2 : insertBoard();break;
			case 3 : deleteBoard();break;
			case 9 : System.out.println("잘가요"); return;
			}
		}
	}
	private void insertBoard() {
		System.out.println("게시글 작성 서비스 입니다.");
		selectBoardList();
		
		System.out.println("\n================================================");
		System.out.print("아이디를 입력해주세요 > ");
		String userId = sc.nextLine();
		System.out.print("비밀번호를 입력해주세요 > ");
		String userPwd = sc.nextLine();
		System.out.println("제목을 입력해주세요");
		String boardTitle = sc.nextLine();
		System.out.println("본문을 입력해주세요");
		String boardContent = sc.nextLine();
		
		int result = bc.insertBoard(new BoardDTO(boardTitle, boardContent,userId));
		System.out.println();
		System.out.println();
		
		if(result >0) {
			System.out.println("게시글 작성 성공!");
		}else {
			System.out.println("게시글 작성 실패");
		}
		
		
	}
	
	public void selectBoardList() {
		
		System.out.println();
		
		List<Board> boards = bc.selectBoardList();
		
		if(!boards.isEmpty()) {
			boards.stream().map(b -> "\n게시글번호 : " + b.getBoardNo()
			                        +"\t제목 : " + b.getBoardTitle()
			                        +"\t\t 작성자 : " + b.getBoardWriter()
			                        +"\t 작성일 : " + b.getCreateDate())
							.forEach(System.out::print);
		}else {
			System.out.println("게시글이 존재하지않습니다.");
			System.out.println("첫 게시글의 주인공이 되어보세요!");
		}
		
	}
	public void selectBoard() {
		System.out.println("게 시 글 상 세 조 회 서 비 스 입 니 다.");
		System.out.print("조회할 게시글 번호를 입력하세요 > ");
		int boardNo = sc.nextInt();
		sc.nextLine();
		
		Board board = bc.selectBoard(boardNo);
		if(board != null) {
			System.out.println("\n\n제목 : " + board.getBoardTitle());
			System.out.println("\n작성자 : " + board.getBoardWriter());
			System.out.println("\n작성일 : " + board.getCreateDate());
			System.out.println("\n본문 : ");
			System.out.println("===================================");
			System.out.println( board.getBoardContent());
			System.out.println("===================================");
		}else {
			System.out.println("존재하지않는 게시물입니다.");
		}
		
		while(true) {
			System.out.println("목록으로 돌아가시려면 '돌아가기'를 입력해주세요");
			String exit = sc.nextLine();
			if("돌아가기".equals(exit)) {
				return;
			}
		}
				
	}
	private void deleteBoard() {
		System.out.print("보드번호 내놔 > ");
		int boardNo = sc.nextInt();
		sc.nextLine();
		
		int result = bc.deleteBoard(boardNo);
		if(bc.deleteBoard(boardNo)>0) {
			System.out.println("잘가시오");
		}else {
			System.out.println("게시물이 없어요");
			
		}
			
	}

}
