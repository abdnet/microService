package org.uvsq.api.transformation;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.*;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;



public class UpdateXMLSource {

	public UpdateXMLSource() {
		// TODO Auto-generated constructor stub
	}
	
	public  void updateAttribute(String file) throws Exception {
	    String xmlns="";
	    DocumentBuilderFactory docFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(file);

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
       StreamResult result = new StreamResult(new File(file));
       transformer.transform(source, result);

       System.out.println("Done");
		
	}

	public void transformationXmlXslt(String file,String xslt,String result) throws TransformerConfigurationException{
		
		TransformerFactory tFactory = TransformerFactory.newInstance();
		Transformer transformer;
		try {
			updateAttribute(file);
			transformer = tFactory.newTransformer(new StreamSource(xslt));
			transformer.transform(new StreamSource(file), new StreamResult(result));

		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
