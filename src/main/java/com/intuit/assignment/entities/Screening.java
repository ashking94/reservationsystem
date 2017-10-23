package com.intuit.assignment.entities;

import java.util.Date;

public class Screening {

	private static int count = 0;

	public Screening(int movieId, int auditoriumId, Date screenigStart) {
		this.id = count++;
		this.movieId = movieId;
		this.auditoriumId = auditoriumId;
		this.screenigStart = screenigStart;
	}

	private final int id;

	private int movieId;

	private int auditoriumId;

	private Date screenigStart;

	public int getId() {
		return id;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getAuditoriumId() {
		return auditoriumId;
	}

	public void setAuditoriumId(int auditoriumId) {
		this.auditoriumId = auditoriumId;
	}

	public Date getScreenigStart() {
		return screenigStart;
	}

	public void setScreenigStart(Date screenigStart) {
		this.screenigStart = screenigStart;
	}

	@Override
	public String toString() {
		return "Screening [id=" + id + ", movieId=" + movieId + ", auditoriumId=" + auditoriumId + ", screeningStart="
				+ screenigStart + "]";
	}

	public enum Column {

		ID("id");

		Column(String code) {
			this.code = code;
		}

		private String code;

		public String getCode() {
			return code;
		}

	}

}
