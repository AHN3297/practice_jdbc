package com.kh.statement.model.dao;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.common.Template;
import com.kh.statement.model.dto.MusicNameDTO;
import com.kh.statement.model.vo.Music;

public class MusicDao {
	public int plusMusic(SqlSession session, Music music) {
		session.insert("musicMapper.plusMusic", music);
		
		return session.insert("musicMapper.plusMusic", music);
		
	}
	/*
	public List<Music> findAll(Connection conn){
		
	}
	public List<Music> findByName(Connection conn, String name){
		
	}
	public Music findBySinger(Connection conn, String singerName) {
		
	}
	public Music findByGenre(Connection conn, String genreName) {
		
	}
	public int update(MusicNameDTO pd) {
		
	}
	public int delete(Music music) {
		
	}
	*/
}