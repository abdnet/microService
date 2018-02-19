package org.uvsq.app;

import java.sql.SQLException;

import org.uvsq.api.transformation.UpdateXMLSource;
import org.uvsq.dao.ChansonDao;
import org.uvsq.daoImpl.AlbumDaoImpl;
import org.uvsq.daoImpl.ArtisteDaoImpl;
import org.uvsq.daoImpl.ChansonDaoImpl;
import org.uvsq.entities.Album;
import org.uvsq.entities.Artiste;
import org.uvsq.entities.Chanson;

public class app {

	public app() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws SQLException {
		/*ArtisteDaoImpl imp= new ArtisteDaoImpl();
		imp.addArtiste(new Artiste("Simo","titoo","gender","dsds"));
		System.out.println(imp.getArtisteById(imp.getLastInsertId()));
		System.out.println(imp.getArtisteByName("abdel").size());
		AlbumDaoImpl alb= new AlbumDaoImpl();
		alb.addAlbum(new Album("paris", "abdel", "dsmldl", "ldksl", "lkdsl", "dslk",imp.getLastInsertId(), "dslk",3,"sd"));
		System.out.println(alb.getAlbumByArtiste("simo").size());
		for (int i=0 ;i<alb.getAlbumByArtiste("simo").size();i++) {
			System.out.println(alb.getAlbumByArtiste("simo").get(i));
		}
		System.out.println(alb.getAlbumByTitre("test").size());
		System.out.println(alb.getAll().size());
		
		ChansonDao ch =new ChansonDaoImpl();
		ch.addChanson(new Chanson( "panaame", 234.00, imp.getLastInsertId(), alb.getLastInsertId(), "adjshd"));
		ch.addChanson(new Chanson( "azr", 234.00, imp.getLastInsertId(), alb.getLastInsertId(), "adjshd"));
		ch.addChanson(new Chanson( "kdjs", 234.00,imp.getLastInsertId(), alb.getLastInsertId(), "adjshd"));
		ch.addChanson(new Chanson( "kdsk", 234.00,imp.getLastInsertId(), alb.getLastInsertId(), "adjshd"));
		
		System.out.println(ch.getAllByAlbum("paris").size());
		
		*/
		UpdateXMLSource xml = new UpdateXMLSource();
		try {
			xml.removeAttribute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
