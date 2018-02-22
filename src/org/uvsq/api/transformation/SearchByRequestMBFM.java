package org.uvsq.api.transformation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.uvsq.clientHTTP.IMusicClientHttp;
import org.uvsq.dao.AlbumDao;
import org.uvsq.dao.ArtisteDao;
import org.uvsq.dao.ChansonDao;
import org.uvsq.daoImpl.*;
import org.uvsq.database.DataBase;
import org.uvsq.entities.Album;
import org.uvsq.entities.Artiste;
import org.uvsq.entities.Chanson;
import org.xml.sax.SAXException;

public class SearchByRequestMBFM implements DataBase{
	ChansonDao chansondao = new ChansonDaoImpl();
	ArtisteDao artisteDao = new ArtisteDaoImpl();
	AlbumDao albumDao = new AlbumDaoImpl();
	IMusicClientHttp getxml=new IMusicClientHttp();
	UpdateXMLSource updateXml = new UpdateXMLSource();
	XmlToBdTransformation xmlTobd=new XmlToBdTransformation();


	
	public SearchByRequestMBFM() {
	}
	
		public ArrayList<Chanson> getSongByTitle(String titleSong){
			
			if(titleSong.length()>=3&&!titleSong.equals("")){
				ArrayList<Chanson> resultBD=this.chansondao.getChansonByTitre(titleSong);
				if(resultBD.size()>0){
					return resultBD;
				}else{
					try {
						getxml.getXmlHttpClientMusicBrainz(titleSong,FILE_STORE_CHANSON,URL_GET_CHANSON_BY_TITLE);
						//la meme chose pour lastfm
						updateXml.updateAttribute(FILE_STORE_CHANSON);
						//pas la peine pour la source lastfm
						xmlTobd.chansonXmlToBD();
						ArrayList<Chanson> result=this.chansondao.getChansonByTitre(titleSong);
						if(result.size()>0){
							return result;
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			return null;
			
		}
		
		public Map<String,ArrayList<Chanson>> getSongByArtist(String artist){
			Map<String,ArrayList<Chanson>> mesChansons=new HashMap<String, ArrayList<Chanson>>();
			if(artist.length()>2&&!artist.equals("")){
				ArrayList<Artiste> artistes = this.artisteDao.getArtisteByName(artist);
				if(artistes.size()>0){
					for(int i =0 ;i<artistes.size();i++){
						chansondao.getChansonByArtiste(artist);
						mesChansons.put(artistes.get(i).getName(), chansondao.getChansonByArtiste(artistes.get(i).getName()));
					}
					return mesChansons;
				}else{
					try {
						getxml.getXmlHttpClientMusicBrainz(artist, FILE_STORE_CHANSON, URL_GET_CHANSON_BY_ARTISTE);
						updateXml.updateAttribute(FILE_STORE_CHANSON);
						//pas la peine pour la source lastfm
						xmlTobd.chansonXmlToBD();
						ArrayList<Artiste> artiste = this.artisteDao.getArtisteByName(artist);
						if(artiste.size()>0){
							for(int i =0 ;i<artiste.size();i++){
								chansondao.getChansonByArtiste(artist);
								mesChansons.put(artiste.get(i).getName(), chansondao.getChansonByArtiste(artiste.get(i).getName()));
							}
							return mesChansons;
						}
					} catch ( Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return null;
			
		}
		
		
		public Map<String,ArrayList<Album>> getAlbumByArtist(String aritst){
			Map<String,ArrayList<Album>> mesAlbums=new HashMap<String, ArrayList<Album>>();
			if(aritst.length()>=3&&!aritst.equals("")){
				ArrayList<Album> albums = this.albumDao.getAlbumByArtiste(aritst);
				ArrayList<Artiste> artistes=this.artisteDao.getArtisteByName(aritst);
				if(albums.size()>0&& artistes.size()>0){
					for(int i=0;i<artistes.size();i++){
						mesAlbums.put(artistes.get(i).getName(),this.albumDao.getAlbumByArtiste(artistes.get(i).getName()));
					}
					return mesAlbums;
				}else{
					
					try {
						getxml.getXmlHttpClientMusicBrainz(aritst, FILE_STORE_ALBUM, URL_GET_ALBUM_BY_ARTISTE);
						updateXml.updateAttribute(FILE_STORE_ALBUM);
						//pas la peine pour la source lastfm
						xmlTobd.chansonXmlToBD();

						if(albums.size()>0&& artistes.size()>0){
							for(int i=0;i<artistes.size();i++){
								mesAlbums.put(artistes.get(i).getName(),this.albumDao.getAlbumByArtiste(artistes.get(i).getName()));
							}
							return mesAlbums;
						}
					} catch ( IOException  | ParserConfigurationException | SAXException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
				}
			}

			return null;
			
		}
		
}
