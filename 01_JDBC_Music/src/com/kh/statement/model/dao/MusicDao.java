package com.kh.statement.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.kh.statement.model.vo.Music;

public class MusicDao {

	public int plusMusic(Music music) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		
		String sql = "INSERT "
					+  "INTO "
						   + "TB_MUSIC "
				   + "VALUES "
						   + "("
						   + "SEQ_MUSIC_NUM.NEXTVAL"
						 + ",'" + music.getMusicName() + "'"
						 + ",'" + music.getSingerName() + "'"
					     + ",'" + music.getGenreName() + "'"
					     + ",'" + music.getPlayTime() + "'"
					     + ", " + music.getAlbumSell()
					     + ", TO_DATE('" + music.getReleaseDate() + "', 'YYYY-MM-DD')"
						   +")";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.20:10000:XE"
					                           ,"AYS14"
					                           ,"AYS141234");
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			if(result > 0) {
				conn.commit();
			}
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt != null) {
					stmt.close();	
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null) {
					conn.close();
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		return 0;
	}

}
