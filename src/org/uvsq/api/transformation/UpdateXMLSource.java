package org.uvsq.api.transformation;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;



public class UpdateXMLSource {

	public UpdateXMLSource() {
		// TODO Auto-generated constructor stub
	}
	
	public  void removeAttribute() throws Exception {
	    String xmlns="";
	    DocumentBuilderFactory docFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse("./meta.xml");

	    Element metadata = (Element)doc.getElementsByTagName("metadata").item(0);
	    NamedNodeMap attributes = metadata.getAttributes();
	    for (int a = 0; a < attributes.getLength(); a++) {
	        Node theAttribute = attributes.item(a);	    
	        if(theAttribute.getNodeName().equals("xmlns")){
	        	xmlns=theAttribute.getNodeValue();
	        	attributes.removeNamedItem(theAttribute.getNodeName());
	        	metadata.setAttribute("xmlns:mmd", xmlns);

	        }
	        
	      }
	   TransformerFactory transformerFactory = TransformerFactory
               .newInstance();
       Transformer transformer = transformerFactory.newTransformer();
       DOMSource source = new DOMSource(doc);
       StreamResult result = new StreamResult(new File("./meta.xml"));
       transformer.transform(source, result);

       System.out.println("Done");
		
	}

}
