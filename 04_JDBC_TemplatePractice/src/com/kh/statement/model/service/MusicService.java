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
	
}

