package com.kh.statement.model.dto;

import java.util.Objects;

public class MusicNameDTO {
	private String musicName;
	private String singer;
	private String newMusicName;
	public MusicNameDTO() {
		super();
	}
	public MusicNameDTO(String musicName, String singer, String newMusicName) {
		super();
		this.musicName = musicName;
		this.singer = singer;
		this.newMusicName = newMusicName;
	}
	public String getMusicName() {
		return musicName;
	}
	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getNewMusicName() {
		return newMusicName;
	}
	public void setNewMusicName(String newMusicName) {
		this.newMusicName = newMusicName;
	}
	@Override
	public int hashCode() {
		return Objects.hash(musicName, newMusicName, singer);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MusicNameDTO other = (MusicNameDTO) obj;
		return Objects.equals(musicName, other.musicName) && Objects.equals(newMusicName, other.newMusicName)
				&& Objects.equals(singer, other.singer);
	}
	@Override
	public String toString() {
		return "MusicNameDTO [musicName=" + musicName + ", singer=" + singer + ", newMusicName=" + newMusicName + "]";
	}

}