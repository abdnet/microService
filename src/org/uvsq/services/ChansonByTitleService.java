package org.uvsq.services;

import org.uvsq.dao.AlbumDao;
import org.uvsq.dao.ArtisteDao;
import org.uvsq.dao.ChansonDao;

public class ChansonByTitleService {
	private ArtisteDao artiste;
	private ChansonDao chanson;
	private AlbumDao album;
	public ChansonByTitleService() {
		// TODO Auto-generated constructor stub
	}

	public String getInfoForSongTitle(String title){
		
		if(!title.equals("")){
			if(chanson.getChansonByTitre(title)!=null){
				if(album.getAlbummByChanson(title).size()>0){
					if(artiste.getArtisteByChanson(title).size()>0){
						
					}
				}
					
			}
		}
	return title;
	
}
}
