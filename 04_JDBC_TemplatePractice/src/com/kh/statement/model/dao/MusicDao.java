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
	
	public List<Music> findAll(SqlSession session){
		//List<Music> music = session.selectList("musicmapepr.findAll");
		return session.selectList("musicMapper.findAll");
	
	}
	
	public List<Music> findByName(SqlSession session, String name){
		session.selectList("musicMapper.findByName",name);
		return session.selectList("musicMapper.findByName");
		
	}
	//만약에 받는게 list가 아니라 Music 이라면 selectOne으로 받았어야했다.
	public List<Music> findBySinger(SqlSession session, String singerName) {
		return session.selectList("musicMapper.findBySinger", singerName);
	}
	/*
	public Music findByGenre(Connection conn, String genreName) {
		
	}
	public int update(MusicNameDTO pd) {
		
	}
	public int delete(Music music) {
		
	}
	*/
}