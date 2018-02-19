package org.uvsq.entities;

import java.io.Serializable;

public class Artiste implements Serializable{
	private int id;
	private String Name;
	private String disambiguation;
	private String gender;
	private String area;
	 
	
	
	public Artiste() {

	}

	public Artiste( int id,String name, String disambiguation, String gender, String area) {
		this.id=id;
		this.Name = name;
		this.disambiguation = disambiguation;
		this.gender = gender;
		this.area = area;
	}
	public Artiste( String name, String disambiguation, String gender, String area) {
		
		this.Name = name;
		this.disambiguation = disambiguation;
		this.gender = gender;
		this.area = area;
	}


	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		Name = name;
	}

	public void setdisambiguation(String disambiguation) {
		this.disambiguation = disambiguation;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return Name;
	}

	public String getdisambiguation() {
		return disambiguation;
	}

	public String getGender() {
		return gender;
	}

	public String getArea() {
		return area;
	}

	@Override
	public String toString() {
		return "Artiste [id=" + id + ", Name=" + Name + ", disambiguation=" + disambiguation
				+ ", gender=" + gender + ", area=" + area + "]";
	}
	
	
	

}
