package org.uvsq.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import org.uvsq.entities.Album;
import org.uvsq.entities.Artiste;
import org.uvsq.entities.Chanson;

public interface AlbumDao {
	

		public ArrayList<Album> getAll();
		public void addAlbum(Album alb) throws SQLException;
		public Album getAlbumById(int idAlbum);
		public ArrayList<Album> getAlbumByTitre(String title);
		public ArrayList<Album> getAlbumByArtiste(String name);
		public ArrayList<Album> getAlbummByChanson(String ch);
		public int getLastInsertId();
		public int getByIdMB(String idMB);

		
		

}
