package org.uvsq.api.transformation;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.uvsq.database.DataBase;
import org.uvsq.entities.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlToBdTransformation implements DataBase{

	public XmlToBdTransformation() {
		// TODO Auto-generated constructor stub
	}

	public void chansonXmlToBD() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Chanson chanson =new Chanson();
        DocumentBuilder builder = factory.newDocumentBuilder();
        File fileXML = new File("/"+FILE_STORE_CHANSON);
        Document xml = builder.parse(fileXML);

      
        Element root = xml.getDocumentElement();
        NodeList bases = root.getElementsByTagName("song");
        String route = null;
        String action = null;
        for(int i=0;i<bases.getLength();i++){
       	 Node base = bases.item(i);//action
       	 NodeList elements = base.getChildNodes();
       	 for(int j=0;j< elements.getLength();j++){
       		 Node enfant = elements.item(j);
       		 if(enfant.getNodeName().equals("route")){
       			 route = enfant.getTextContent(); 
       		 }
       		 if(enfant.getNodeName().equals("class")){
       			 action = enfant.getTextContent();
       		 }
       	 }
       	 
       	 
        }

	}

	public void albumXmlToBD() {

	}

	public void artisteXmlToBD() {

	}

}
