package com.kh.board.model.vo;

import java.sql.Date;
import java.util.Objects;

public class Board {
	private int boardNo;// BOARD_TITLE VARCHAR2
	private String boardTitle;// BOARD_NO NUMBER
	private String boarContent;// BOARD_CONTENT VARCHAR2
	private String boardWriter;// BOARD_WRITER NUMBER FOREIGNKEY(USERNO)
    private Date createDate;// CREATE_DATE DATE
	private String deleteStatus;// DELETE_STATUS CHAR(1)
	public Board(int boardNo, String boardTitle, String boarContent, String boardWriter, Date createDate,
			String deleteStatus) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boarContent = boarContent;
		this.boardWriter = boardWriter;
		this.createDate = createDate;
		this.deleteStatus = deleteStatus;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public String getBoardContent() {
		return boarContent;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public String getDeleteStatus() {
		return deleteStatus;
	}
	@Override
	public int hashCode() {
		return Objects.hash(boarContent, boardNo, boardTitle, boardWriter, createDate, deleteStatus);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		return Objects.equals(boarContent, other.boarContent) && boardNo == other.boardNo
				&& Objects.equals(boardTitle, other.boardTitle) && Objects.equals(boardWriter, other.boardWriter)
				&& Objects.equals(createDate, other.createDate) && Objects.equals(deleteStatus, other.deleteStatus);
	}
	
	// 기본생성자 / 모든 필드에 대한 매개변수생성자
	// getter
	// equals, hashCode

	
}
