package org.wuestner.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	@Size(min=1, max=30)
	private String title;
	
	@ManyToOne
	private Genre genre;
	
	@NotNull
	@Size(min=1, max=30)
	private String director;

	/**
	 * @param title
	 * @param genre
	 * @param director
	 */
	public Movie(String title, Genre genre, String director) {
		super();
		this.title = title;
		this.genre = genre;
		this.director = director;
	}
	
	public Movie() { }

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the genre
	 */
	public Genre getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * @param director the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
}
