package com.kh.statement.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.statement.model.vo.Music;

public class MusicDao {
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@115.90.212.20:10000:XE";
	private final String USERNAME = "AYS14";
	private final String PASSWORD = "AYS141234";

	public int plusMusic(Music music) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = """
					     INSERT
					       INTO
					            TB_MUSIC
					     VALUES
					     (
					            SEQ_MUSIC_NUM.NEXTVAL,
					            ?,
					            ?,
					            ?,
					            ?,
					            ?,
					            TO_DATE(?, 'YYYY-MM-DD')
					            )
					            
					 """;
		
				/*
				"INSERT "
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
						   */
		try {
			Class.forName(DRIVER);
			
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,music.getMusicName());
			pstmt.setString(2,music.getSingerName());
			pstmt.setString(3,music.getGenreName());
			pstmt.setString(4,music.getPlayTime());
			pstmt.setInt(5,music.getAlbumSell());
			pstmt.setString(6,music.getReleaseDate());
			System.out.println("하잉");
			
			
			
			result = pstmt.executeUpdate();
			if(result > 0) {
				conn.commit();
			}
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();	
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
		return result;
	}
	public List<Music> findAll(){
		List<Music> musics = new ArrayList();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(
											"""
										     SELECT
										            MUSIC_NUM,
										            MUSIC_NAME,
										            SINGER_NAME,
										            GENRE_NAME,
										            PLAY_TIME,
										            ALBUM_SELL,
										            RELEASE_DATE
										       FROM 
										            TB_MUSIC
										      ORDER
										         BY
										            MUSIC_NUM DESC
										     """
										 );
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Music music = new Music(); 
				music.setMusicNum(rset.getInt("MUSIC_NUM"));
				music.setMusicName(rset.getString("MUSIC_NAME"));
				music.setSingerName(rset.getString("SIGNER_NAME"));
				music.setGenreName(rset.getString("GENRE_NAME"));
				music.setPlayTime(rset.getString("PLAY_TIME"));
				music.setAlbumSell(rset.getInt("ALBUM_SELL"));
				music.setReleaseDate(rset.getNString("RELEASE_DATE"));
			}
					
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		return result;
	}

}