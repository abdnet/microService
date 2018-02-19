package org.uvsq.services;

import org.uvsq.dao.AlbumDao;
import org.uvsq.dao.ArtisteDao;

public class AlbumByArtisteService {
	private ArtisteDao artiste;
	private AlbumDao album;

	public AlbumByArtisteService() {
		// TODO Auto-generated constructor stub
	}

	public String getAlbumsByArtiste(String nameAuthor){
 		if(!nameAuthor.equals("")){
			if(artiste.getArtisteByName(nameAuthor)!=null){
				if(album.getAlbumByArtiste(nameAuthor).size()>0){
					//chargment des données depuis la base de données
				}
				
				else{
					//chargment des données (album par auteur ) depuis les api puis les injecter dans la bd
				}
			}else{
				//chargement des données de l'artiste puis les données des ses chanson depuis les api 
			}
		}
		return nameAuthor;
 		
 	}
}
