package com.kh.board.controller;

import java.util.List;

import com.kh.board.model.dto.BoardDTO;
import com.kh.board.model.vo.Board;
import com.kh.board.service.BoardService;

public class BoardController {
	
	public int insertBoard(BoardDTO bd) {
		new BoardService().insertBoard(bd);
		int result = new BoardService().insertBoard(bd);
		return result;
	}
	public List<Board> selectBoardList(){
		List<Board> boards = new BoardService().selectBoardList();
		return boards;
	}
	public Board selectBoard(int boardNo) {
		return new BoardService().selectBoard(boardNo);
	}
	public int deleteBoard(int boardNo) {
		return new BoardService().deleteBoard(boardNo);
	}
}
