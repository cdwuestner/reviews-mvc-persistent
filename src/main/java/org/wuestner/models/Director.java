package org.wuestner.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Director {
	
	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	@Size(min=1, max=15)
	private String first_name;
	
	@NotNull
	@Size(min=1, max=15)
	private String last_name;
	
	@NotNull
	@Size(min=1, max=30)
	private String bio;

	/**
	 * @param id
	 * @param first_name
	 * @param last_name
	 * @param bio
	 */
	public Director(String first_name, String last_name, String bio) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.bio = bio;
	}
	
	public Director() { }

	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}

	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}

	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * @return the bio
	 */
	public String getBio() {
		return bio;
	}

	/**
	 * @param bio the bio to set
	 */
	public void setBio(String bio) {
		this.bio = bio;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

}
