package org.uvsq.services;

import java.util.ArrayList;
import java.util.Map;

import org.uvsq.api.transformation.SearchByRequestMBFM;
import org.uvsq.entities.Album;
import org.uvsq.entities.Chanson;

public class getResultByRequest {

	private SearchByRequestMBFM request=new SearchByRequestMBFM();
	
	public ArrayList<Chanson> getSongByTitle(String titleSong){
		return request.getSongByTitle(titleSong);
	}
	public Map<String,ArrayList<Chanson>> getSongByArtist(String artist){
		return request.getSongByArtist(artist);
	}
	
	public Map<String,ArrayList<Album>> getAlbumByArtist(String aritst) {
		return request.getAlbumByArtist(aritst);
	}
}