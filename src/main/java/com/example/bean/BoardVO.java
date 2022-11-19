package com.example.bean;

import java.util.Date;

public class BoardVO {


	private int songID;
	private String AlbumPhoto;
	private String Title;
	private String Singer;
	private String AlbumTitle;
	private String ReleasedDate;
	private int Ranking;
	private String runningTime;
	private String songWriter;
	private String lyrics;

	public int getSongID() {
		return songID;
	}

	public void setSongID(int songID) {
		this.songID = songID;
	}

	public String getAlbumPhoto() {
		return AlbumPhoto;
	}

	public void setAlbumPhoto(String albumPhoto) {
		AlbumPhoto = albumPhoto;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getSinger() {
		return Singer;
	}

	public void setSinger(String singer) {
		Singer = singer;
	}

	public String getAlbumTitle() {
		return AlbumTitle;
	}

	public void setAlbumTitle(String albumTitle) {
		AlbumTitle = albumTitle;
	}

	public String getReleasedDate() {
		return ReleasedDate;
	}

	public void setReleasedDate(String releasedDate) {
		ReleasedDate = releasedDate;
	}

	public int getRanking() {
		return Ranking;
	}

	public void setRanking(int ranking) {
		Ranking = ranking;
	}

	public String getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}

	public String getSongWriter() {
		return songWriter;
	}

	public void setSongWriter(String songWriter) {
		this.songWriter = songWriter;
	}

	public String getLyrics() {
		return lyrics;
	}

	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}
}
