package org.uvsq.services;

import org.uvsq.dao.*;


public class ChansonByArtisteService {
	
	private ArtisteDao artiste;
	private ChansonDao chanson;

	public ChansonByArtisteService() {
		
	}
	
	public String getSongsByArtiste(String nameAuthor){
		if(!nameAuthor.equals("")){
			if(artiste.getArtisteByName(nameAuthor)!=null){
				if(chanson.getChansonByArtiste(nameAuthor).size()>0){
					//chargment des données depuis la base de données
				}
				
				else{
					//chargment des données (chanson par auteur ) depuis les api puis les injecter dans la bd
				}
			}else{
				//chargement des données de l'artiste puis les données des ses chanson depuis les api 
			}
		}
		return nameAuthor;
		
	}


 	

	
//	
//	
//	public void addChanson(){
//		
//	}
//	
//	public void addArtiste(){
//		
//	}
//	public void addAlbum(){
//		
//	}
}
