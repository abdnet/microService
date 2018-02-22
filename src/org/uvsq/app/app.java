package org.uvsq.app;

import java.io.IOException;
import java.sql.SQLException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;

import org.uvsq.api.transformation.SearchByRequestMBFM;
import org.uvsq.api.transformation.UpdateXMLSource;
import org.uvsq.api.transformation.XmlToBdTransformation;
import org.uvsq.clientHTTP.IMusicClientHttp;
import org.uvsq.dao.ChansonDao;
import org.uvsq.daoImpl.AlbumDaoImpl;
import org.uvsq.daoImpl.ArtisteDaoImpl;
import org.uvsq.daoImpl.ChansonDaoImpl;
import org.uvsq.database.DataBase;
import org.uvsq.entities.Album;
import org.uvsq.entities.Artiste;
import org.uvsq.entities.Chanson;
import org.xml.sax.SAXException;

import com.google.gson.Gson;

public class app {

	public app() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws SQLException {
		
		DataBase base = null;
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
		/*UpdateXMLSource xml = new UpdateXMLSource();
		try {
			xml.transformationXmlXslt("./xml/song/Song.xml","./xml/song/SongNewStylesheet.xsl");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Gson gson = new Gson(); 	
		SearchByRequestMBFM test = new SearchByRequestMBFM();
		//test.getSongByTitle("ett");
		System.out.println(test.getAlbumByArtist("MIKA").size());
		String json = gson.toJson(test.getAlbumByArtist("MIKA"));
		System.out.println(json);

		
	}
}
