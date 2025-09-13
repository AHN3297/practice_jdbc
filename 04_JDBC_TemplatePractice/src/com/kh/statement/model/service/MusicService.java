package com.kh.statement.model.service;
import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;
import java.util.function.Function;

import org.apache.ibatis.session.SqlSession;

import com.kh.common.Template;
import com.kh.statement.model.dao.MusicDao;
import com.kh.statement.model.dto.MusicNameDTO;
import com.kh.statement.model.vo.Music;


public class MusicService {
	private MusicDao musicDao = new MusicDao();
	
	public int plusMusic(Music music) {
		SqlSession session = Template.getSqlSession();
		int result = musicDao.plusMusic(session,music);
		if(result >0) {
			session.commit();
		}
		session.close();
		
		return result;
	}
	
	public List<Music> findAll(){
		SqlSession session = Template.getSqlSession();
		List<Music> music = musicDao.findAll(session);
		session.close();
		return music;
	}
	
	public List<Music> findByName(String name){
		SqlSession session = Template.getSqlSession();
		List<Music> music = musicDao.findByName(session , name);
		session.close(); 
		return music;
	}
	public List<Music> findBySinger(String singerName) {
		SqlSession session = Template.getSqlSession();
		List<Music> music = musicDao.findBySinger(session , singerName);
		session.close();
		return music;
		
	}
	public List<Music> findByGenre(String genreName){
		SqlSession session = Template.getSqlSession();
		List<Music> music = musicDao.findByGenre(session , genreName);
		session.close();
		return music;
	}
	
	public int update(MusicNameDTO md) {
		SqlSession session = Template.getSqlSession();
		int result = musicDao.update(session , md);
		if(result >0) {
			session.commit();
		}
		session.close();
		return result;
	}
	
	public int delete(Music music) {
		SqlSession session = Template.getSqlSession(); 
		int result = musicDao.delete(session , music);
		if(result >0) {
			session.commit();
		}
		session.close();
		return result;
	}
}

