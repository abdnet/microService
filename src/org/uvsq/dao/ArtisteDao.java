package org.uvsq.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import org.uvsq.entities.Album;
import org.uvsq.entities.Artiste;
import org.uvsq.entities.Chanson;

public interface ArtisteDao {
	
	
	public ArrayList<Artiste> getAll();
	public void addArtiste(Artiste a) throws SQLException;
	public Artiste getArtisteById(int idArtiste);
	public ArrayList<Artiste> getArtisteByChanson(String title);
	public ArrayList<Artiste> getArtisteByName(String nom);
	public Artiste getArtisteByAlbum(Album ch);
	public int getLastInsertId();
}
