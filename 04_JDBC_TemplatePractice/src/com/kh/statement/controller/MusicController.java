package com.kh.statement.controller;

import java.util.List;

import com.kh.statement.model.dao.MusicDao;
import com.kh.statement.model.dto.MusicNameDTO;
import com.kh.statement.model.service.MusicService;
import com.kh.statement.model.vo.Music;

public class MusicController {
	public int plusMusic(String musicName, String singer, String genre, String playTime, int albumSell, String releaseDate) {
		
		Music music = new Music(musicName, singer, genre, playTime, albumSell, releaseDate);
		
		int result = new MusicService().plusMusic(music);
		return result;
	}
	
	public List<Music> findAll() {
		List<Music> musics = new MusicService().findAll();	
	return musics;
	}
	
	public List<Music> findByName(String name) {
		// 노래 제목으로 검색하기
		List<Music> musics = new MusicService().findByName(name);
		return musics;		
	}
	
	public Music findBySinger(String singerName) {
		// 가수 이름으로 검색하기
		Music singer = new MusicService().findBySinger(singerName);
		return singer;
	}
	
	public Music findByGenre(String genreName) {
		Music genre = new MusicService().findByGenre(genreName);
		return genre;
	}
	public int update(String musicName, String singer, String newMusicName) {

		MusicNameDTO md = new MusicNameDTO(musicName, singer, newMusicName);
		int result = new MusicService().update(md);
		return result;
	}
	
	public int delete(String musicName, String singer) {

		Music music = new Music();
		music.setMusicName(musicName);
		music.setSingerName(singer);
		
		int result = new MusicService().delete(music);
		
		return result;
		
	}

}