package com.kh.board.service;

import java.sql.Connection;
import java.util.List;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.dto.BoardDTO;
import com.kh.board.model.vo.Board;
import com.kh.common.JDBCTemplate;
import com.kh.statement.model.dao.MemberDao;
import com.kh.statement.model.vo.Member;

public class BoardService {
	
	private Connection conn = null;
	
	public BoardService() {
		conn = JDBCTemplate.getConnection();
	}
	
	public int insertBoard(BoardDTO bd) {
		int result = 0;
		// 내가 입력한 값을 가지고
		// BOARD테이블에 한 행 INSERT해줘
		
		// 1. 값의 유형성 검증
		
		if("".equals(bd.getBoardTitle().trim())) {
			return result;
		}
		// 제목 : 안녕, 내용 : 반갑습니다. 아이디 : admin
		// 2. 인증/인가 
		
		Member member = new MemberDao().findById(conn, bd.getBoardWriter());
		if(member != null) {
			int userNo = member.getUserNo();
			Board board = new Board(0,
					                bd.getBoardTitle(),
					                bd.getBoardContent(),
					                String.valueOf(userNo),
					                null,
					                null); 
			result = new BoardDao().insertBoard(conn,board);
		}
		if(result >0) {
			JDBCTemplate.commit(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	public List<Board> selectBoardList(){
		List<Board> boards = new BoardDao().selectBoardsList(conn);
		new BoardDao().outputHTML(conn);
		JDBCTemplate.close(conn);
		return boards;
	}
	
	public Board selectBoard(int boardNo) {
		// 아 이거 보드넘버 시퀀스 가지고 만든건데
		// 직접 한땀한땀 한거아닌데 시퀀스 가지고 한건데
		// 1부터 시작인데 0이하값 들어가면 윽된다잉
		// DB가면 돈드는데... 아까운데...
		Board board = null;
		if(boardNo >0) {
			board = new BoardDao().selectBoard(conn, boardNo);
		}
		JDBCTemplate.close(conn);
		
		return board;
	}
	public int deleteBoard(int boardNo) {
		int result = new BoardDao().deleteBoard(conn, boardNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}
		return result;
	}

}
