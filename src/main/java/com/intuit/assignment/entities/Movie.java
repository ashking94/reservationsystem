package com.intuit.assignment.entities;

/*
 * This class would have a corresponding table in DB.
 * Type - Master Table
 */

public class Movie {

	private static int count = 0;

	public Movie(String title, String director, String cast, String description, int durationMin) {
		this.id = count++;
		this.title = title;
		this.director = director;
		this.cast = cast;
		this.description = description;
		this.durationMin = durationMin;
	}

	private final int id;

	private String title;

	private String director;

	private String cast;

	private String description;

	private int durationMin;

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDurationMin() {
		return durationMin;
	}

	public void setDurationMin(int durationMin) {
		this.durationMin = durationMin;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", director=" + director + ", cast=" + cast + ", description="
				+ description + ", durationMin=" + durationMin + "]";
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
