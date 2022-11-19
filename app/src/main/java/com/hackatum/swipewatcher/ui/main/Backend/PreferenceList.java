package com.hackatum.swipewatcher.ui.main.Backend;

public class PreferenceList {
	private int genre;
	private int fsk;
	private int movie_series_whatever;
	private String language;

	public PreferenceList(int genre, int fsk, int movie_series_whatever, String language) {
		this.genre = genre;
		this.fsk = fsk;
		this.movie_series_whatever = movie_series_whatever;
		this.language = language;
	}

	public int getGenre() {
		return genre;
	}

	public void setGenre(int genre) {
		this.genre = genre;
	}

	public int getFsk() {
		return fsk;
	}

	public void setFsk(int fsk) {
		this.fsk = fsk;
	}

	public int getMovie_series_whatever() {
		return movie_series_whatever;
	}

	public void setMovie_series_whatever(int movie_series_whatever) {
		this.movie_series_whatever = movie_series_whatever;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
