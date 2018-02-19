package org.uvsq.dao;

import java.util.ArrayList;

import org.uvsq.entities.Album;
import org.uvsq.entities.Artiste;
import org.uvsq.entities.Chanson;

public interface ChansonDao {
	
	public ArrayList<Chanson> getAll();
	public void addChanson(Chanson ch);
	public Chanson getChansonById(int idChanson);
	public ArrayList<Chanson> getChansonByTitre(String title);
	public ArrayList<Chanson> getChansonByArtiste(String a);
	public ArrayList<Chanson> getAllByAlbum(String ch);
	public int getLastInsertId();

}
