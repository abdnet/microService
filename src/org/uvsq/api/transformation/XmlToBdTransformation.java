package org.uvsq.api.transformation;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;

import org.uvsq.clientHTTP.IMusicClientHttp;
import org.uvsq.dao.*;
import org.uvsq.daoImpl.*;
import org.uvsq.database.DataBase;
import org.uvsq.entities.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlToBdTransformation implements DataBase {
	ChansonDao chansondao = new ChansonDaoImpl();
	ArtisteDao artisteDao = new ArtisteDaoImpl();
	AlbumDao albumDao = new AlbumDaoImpl();
	IMusicClientHttp http=new IMusicClientHttp();
	UpdateXMLSource xmlTransf = new UpdateXMLSource();
	private int lastInsert=0;


	public XmlToBdTransformation() {
		// TODO Auto-generated constructor stub
	}

	public void chansonXmlToBD() throws ParserConfigurationException,
			SAXException, IOException, TransformerConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		File fileXML = new File("./" + FILE_RESULT_CHANSON);
		Document xml = builder.parse(fileXML);
		Chanson chanson = null;
		Element root = xml.getDocumentElement();
		NodeList bases = root.getElementsByTagName("song");
		String titleSong = null;
		double duree = 0;
		String annee = null;
		int idArtist = 0 ;
		ArrayList<String> albums = null;
		String idMB=null;

		for (int i = 0; i < bases.getLength(); i++) {
			Node base = bases.item(i);
			NodeList elements = base.getChildNodes();
			Element el = (Element)base;
			idMB= el.getAttribute("last_id");
			for (int j = 0; j < elements.getLength(); j++) {
				chanson = new Chanson();
				Node enfant = elements.item(j);
				if (enfant.getNodeName().equals("titleSong")) {
					titleSong = enfant.getTextContent();
				}
				if (enfant.getNodeName().equals("duree")) {

					if (!enfant.getTextContent().equals("")) {
						double d = (double) ((Integer.parseInt(enfant.getTextContent())/60));
						duree=d;
					}
				}

				if (enfant.getNodeName().equals("annee")) {
					annee = enfant.getTextContent();
				}
				if (enfant.getNodeName().equals("artist")) {
					int ida=artisteDao.getByIdMB(enfant.getTextContent());
					if(ida!=0){
						idArtist = ida;
					}else{
						System.out.println("reetour artiste dao id : "+ida);

					    http.getXmlHttpClientMusicBrainz(enfant.getTextContent(), FILE_STORE_BY_IDMB_ARTISTE, URL_GET_ARTISTE_BY_IDMB);
					   xmlTransf.transformationXmlXslt(FILE_STORE_BY_IDMB_ARTISTE, FILE_XSLT_BY_IDMB_ARTISTE, FILE_RESULT_BY_IDMB_ARTISTE);
					    this.artisteXmlToBD();
					    idArtist=this.lastInsert;
					}
					
				}
				
				chanson.setDureeSong((float) duree);
				chanson.setTitleSong(titleSong);
				chanson.setIdAlbum(3);
				chanson.setIdArtist(idArtist);
				chanson.setIdMB(idMB);
				if (enfant.getNodeName().equals("albums")) {
					
					
						int ida=albumDao.getByIdMB(enfant.getTextContent());
						if(ida!=0){
							idArtist = ida;
						}else{
								http.getXmlHttpClientMusicBrainz(enfant.getTextContent(), FILE_STORE_BY_IDMB_ALBUM, URL_GET_ALBUM_BY_IDMB);
								xmlTransf.transformationXmlXslt(FILE_STORE_BY_IDMB_ALBUM, FILE_XSLT_BY_IDMB_ALBUM, FILE_RESULT_BY_IDMB_ALBUM);
								this.albumXmlToBD(idArtist);
								chanson.setIdAlbum(lastInsert);
						
					}
				}
				
				chansondao.addChanson(chanson);

				
			}

			
		}
	}

	public void albumXmlToBD(int idArtiste) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Album album=new Album();
		try {
			builder = factory.newDocumentBuilder();
			File fileXML = new File("./" + FILE_RESULT_BY_IDMB_ALBUM);
			Document xml = builder.parse(fileXML);
			
			Element bases = xml.getDocumentElement();
			
			Element el = (Element)bases;
			album.setIdMB(el.getAttribute("id"));
			//artiste.setdisambiguation(el.getAttribute("disambiguation"));
			String name=null;
			NodeList elements = el.getChildNodes();
			
			for (int j = 0; j < elements.getLength(); j++) {
				Node enfant = elements.item(j);
				if (enfant.getNodeName().equals("titreAlbum")) {
					album.setTitleAlbum(enfant.getTextContent());
				}
				if (enfant.getNodeName().equals("statusAlbum")) {
					album.setformatAlbum(enfant.getTextContent());
				}
				if (enfant.getNodeName().equals("paysAlbum")) {
					album.setpaysAlbum(enfant.getTextContent());
				}
				
				if (enfant.getNodeName().equals("dateAlbum")) {
					album.setDateAlbum(enfant.getTextContent());
				}
				
				if (enfant.getNodeName().equals("langageAlbum")) {
					album.setlangue(enfant.getTextContent());
				}
				
			}
			
			album.setIdArtist(idArtiste);
			albumDao.addAlbum(album);
			this.lastInsert=albumDao.getLastInsertId();
			
		} catch (ParserConfigurationException | SAXException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

	public void artisteXmlToBD() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Artiste artiste=new Artiste();
		try {
			builder = factory.newDocumentBuilder();
			File fileXML = new File("./" + FILE_RESULT_BY_IDMB_ARTISTE);
			Document xml = builder.parse(fileXML);
			
			Element bases = xml.getDocumentElement();
			
			Element el = (Element)bases;
			artiste.setIdMB(el.getAttribute("id"));
			artiste.setdisambiguation(el.getAttribute("disambiguation"));
			String name=null;
			NodeList elements = el.getChildNodes();
			
			for (int j = 0; j < elements.getLength(); j++) {
				Node enfant = elements.item(j);
				if (enfant.getNodeName().equals("nomArtist")) {
					artiste.setName(enfant.getTextContent());
				}
				if (enfant.getNodeName().equals("pays")) {
					artiste.setArea(enfant.getTextContent());
				}
				if (enfant.getNodeName().equals("gender")) {
					artiste.setGender(enfant.getTextContent());
				}
				
			}
			
			System.out.println(artiste);
			artisteDao.addArtiste(artiste);
			this.lastInsert=artisteDao.getLastInsertId();
			
		} catch (ParserConfigurationException | SAXException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
