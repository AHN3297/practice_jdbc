package com.kh.statement.model.vo;

import java.sql.Date;
import java.util.Objects;

public class Music {
	private int musicNum; //MUSIC_NUM NUMBER  PRIMARY KEY,
	private String musicName; //MUSIC_NAME VARCHAR2(50) NOT NULL,
	private String singerName; //SINGER_NAME VARCHAR2(50) NOT NULL,
	private String genreName; //GENRE_NAME VARCHAR2(20)NOT NULL,
	private String playTime; //PLAY_TIME VARCHAR2(20)NOT NULL,
	private int albumSell; //ALBUM_SELL NUMBER NOT NULL,
	private String releaseDate; //RELEASE_DATE DATE NOT NULL
	public Music() {
		super();
	}
	public Music(int musicNum, String musicName, String singerName, String genreName, String playTime, int albumSell,
			String releaseDate) {
		super();
		this.musicNum = musicNum;
		this.musicName = musicName;
		this.singerName = singerName;
		this.genreName = genreName;
		this.playTime = playTime;
		this.albumSell = albumSell;
		this.releaseDate = releaseDate;
	}
	public Music(String musicName, String singerName, String genreName, String playTime, int albumSell,
			String releaseDate) {
		super();
		this.musicName = musicName;
		this.singerName = singerName;
		this.genreName = genreName;
		this.playTime = playTime;
		this.albumSell = albumSell;
		this.releaseDate = releaseDate;
	}
	public int getMusicNum() {
		return musicNum;
	}
	public void setMusicNum(int musicNum) {
		this.musicNum = musicNum;
	}
	public String getMusicName() {
		return musicName;
	}
	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}
	public String getSingerName() {
		return singerName;
	}
	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}
	public String getGenreName() {
		return genreName;
	}
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	public String getPlayTime() {
		return playTime;
	}
	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}
	public int getAlbumSell() {
		return albumSell;
	}
	public void setAlbumSell(int string) {
		this.albumSell = string;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(albumSell, genreName, musicName, musicNum, playTime, releaseDate, singerName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Music other = (Music) obj;
		return Objects.equals(albumSell, other.albumSell) && Objects.equals(genreName, other.genreName)
				&& Objects.equals(musicName, other.musicName) && musicNum == other.musicNum
				&& Objects.equals(playTime, other.playTime) && Objects.equals(releaseDate, other.releaseDate)
				&& Objects.equals(singerName, other.singerName);
	}
	@Override
	public String toString() {
		return "Music [musicNum=" + musicNum + ", musicName=" + musicName + ", singerName=" + singerName + ", genreName="
				+ genreName + ", playTime=" + playTime + ", albumSell=" + albumSell + ", releaseDate=" + releaseDate
				+ "]";
	}
	

}