package org.uvsq.entities;


public class Chanson {
	private int idSong;
	private String titleSong;
	private double dureeSong;
	private int idArtist;
	private int idAlbum;
	private String idMB;
	
	public Chanson() {
	}


	public Chanson(int idSong, String titleSong, double dureeSong,
			int idArtist, int idAlbum ,String IdMB) {
		this.idSong = idSong;
		this.titleSong = titleSong;
		this.dureeSong = dureeSong;
		this.idArtist = idArtist;
		this.idAlbum = idAlbum;
		this.idMB=IdMB;
	}
	public Chanson( String titleSong, double dureeSong,
			int idArtist, int idAlbum ,String IdMB) {
		this.titleSong = titleSong;
		this.dureeSong = dureeSong;
		this.idArtist = idArtist;
		this.idAlbum = idAlbum;
		this.idMB=IdMB;
	}


	public int getIdSong() {
		return idSong;
	}


	public void setIdSong(int idSong) {
		this.idSong = idSong;
	}


	public String getTitleSong() {
		return titleSong;
	}


	public void setTitleSong(String titleSong) {
		this.titleSong = titleSong;
	}


	public double getDureeSong() {
		return dureeSong;
	}


	public void setDureeSong(double dureeSong) {
		this.dureeSong = dureeSong;
	}


	public int getIdArtist() {
		return idArtist;
	}


	public void setIdArtist(int idArtist) {
		this.idArtist = idArtist;
	}


	public int getIdAlbum() {
		return idAlbum;
	}


	public void setIdAlbum(int idAlbum) {
		this.idAlbum = idAlbum;
	}
	
	

	public String getIdMB() {
		return idMB;
	}
	public void setIdMB(String idMB) {
		this.idMB = idMB;
	}


	@Override
	public String toString() {
		return "Chanson [idSong=" + idSong + ", titleSong=" + titleSong
				+ ", dureeSong=" + dureeSong + ", idArtist=" + idArtist
				+ ", idAlbum=" + idAlbum + "]";
	}
	
	
	
	
}
