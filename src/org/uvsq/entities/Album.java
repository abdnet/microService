package org.uvsq.entities;

import java.io.Serializable;


public class Album implements Serializable{
	
	private int idAlbum;
	private String titleAlbum;
	private String formatAlbum;
	private String paysAlbum;
	private String dateAlbum;
	private String countryAlbum;
	private String langue;	
	private int idArtist;
	private String label;
	private int piste;
	private String idMB;
	
	


	public Album( String titleAlbum, String formatAlbum,
			String paysAlbum, String dateAlbum, String countryAlbum,
			String langue, int idArtist, String label,int piste,String idMB) {
		super();
		this.titleAlbum = titleAlbum;
		this.formatAlbum = formatAlbum;
		this.paysAlbum = paysAlbum;
		this.dateAlbum = dateAlbum;
		this.countryAlbum = countryAlbum;
		this.langue = langue;
		this.idArtist = idArtist;
		this.label = label;
		this.piste=piste;
		this.idMB=idMB;
	}


	public Album() {
		
	}


	public int getPiste() {
		return piste;
	}


	public void setPiste(int piste) {
		this.piste = piste;
	}


	public String getIdMB() {
		return idMB;
	}


	public void setIdMB(String idMB) {
		this.idMB = idMB;
	}


	public int getIdAlbum() {
		return idAlbum;
	}


	public void setIdAlbum(int idAlbum) {
		this.idAlbum = idAlbum;
	}


	public String getTitleAlbum() {
		return titleAlbum;
	}


	public void setTitleAlbum(String titleAlbum) {
		this.titleAlbum = titleAlbum;
	}


	public String getformatAlbum() {
		return formatAlbum;
	}


	public void setformatAlbum(String formatAlbum) {
		this.formatAlbum = formatAlbum;
	}


	public String getpaysAlbum() {
		return paysAlbum;
	}


	public void setpaysAlbum(String paysAlbum) {
		this.paysAlbum = paysAlbum;
	}


	public String getDateAlbum() {
		return dateAlbum;
	}


	public void setDateAlbum(String dateAlbum) {
		this.dateAlbum = dateAlbum;
	}


	public String getCountryAlbum() {
		return countryAlbum;
	}


	public void setCountryAlbum(String countryAlbum) {
		this.countryAlbum = countryAlbum;
	}


	public String getlangue() {
		return langue;
	}


	public void setlangue(String langue) {
		this.langue = langue;
	}


	public int getIdArtist() {
		return idArtist;
	}


	public void setIdArtist(int idArtist) {
		this.idArtist = idArtist;
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	@Override
	public String toString() {
		return "Album [idAlbum=" + idAlbum + ", titleAlbum=" + titleAlbum
				+ ", formatAlbum=" + formatAlbum + ", paysAlbum="
				+ paysAlbum + ", dateAlbum=" + dateAlbum
				+ ", countryAlbum=" + countryAlbum + ", langue=" + langue
				+ ", idArtist=" + idArtist + "]";
	}
	
	
	
}
