package org.uvsq.api.transformation;

import java.io.File;
import java.io.IOException;
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
		int idArtist ;
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
				if (enfant.getNodeName().equals("idArtist")) {
					int ida=artisteDao.getByIdMB(enfant.getTextContent());
					if(ida!=0){
						idArtist = ida;
					}else{
					    http.getXmlHttpClientMusicBrainz(enfant.getTextContent(), FILE_STORE_BY_IDMB_ARTISTE, URL_GET_CHANSON_BY_ARTISTE);
					    xmlTransf.transformationXmlXslt(FILE_STORE_BY_IDMB_ARTISTE, FILE_XSLT_BY_IDMB_ARTISTE, FILE_RESULT_BY_IDMB_ARTISTE);
					}
					
				}

				if (enfant.getNodeName().equals("albums")) {

				}
			}

			chanson.setDureeSong((float) duree);
			chanson.setTitleSong(titleSong);
			chanson.setIdAlbum(3);
			chanson.setIdArtist(2);
			chanson.setIdMB(idMB);
			System.out.println(chanson);
			chansondao.addChanson(chanson);

			System.out.println("done bd");

		}
	}

	public void albumXmlToBD() {

	}

	public void artisteXmlToBD() {

	}

}
