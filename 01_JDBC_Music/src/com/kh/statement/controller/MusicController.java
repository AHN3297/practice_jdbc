package com.kh.statement.controller;

import java.sql.Date;

import com.kh.statement.model.dao.MusicDao;
import com.kh.statement.model.vo.Music;

public class MusicController {
	public int plusMusic(String musicName, String singer, String genre, String playTime, int albumSell, Date releaseDate) {
		
		Music music = new Music(musicName, singer, genre, playTime, albumSell, releaseDate);
		
		int result = new MusicDao().plusMusic(music);
		return result;
	}

}
