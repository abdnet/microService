package org.uvsq.clientHTTP;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import jdk.internal.org.xml.sax.SAXException;

import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.*;


public class IMusicClientHttp   {

	public IMusicClientHttp() {
	}

	public void getXmlHttpClientMusicBrainz(String artist,String file,String url) throws UnsupportedOperationException, org.xml.sax.SAXException, IOException {

		DefaultHttpClient client = new DefaultHttpClient();
		//String getUrl = "http://musicbrainz.org/ws/2/recording/?query=artist:";
		//https://musicbrainz.org/ws/2/release/?query=artist%3Aeminem

		HttpUriRequest getRequest = new HttpGet(url+artist);
		HttpResponse response = client.execute(getRequest);
		int statusCode = response.getStatusLine().getStatusCode();
		Document doc = null;
		        if (statusCode == 200 ){
		            HttpEntity entity = response.getEntity();
		            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		            try {
		                DocumentBuilder builder = factory.newDocumentBuilder();
		                doc = builder.parse(entity.getContent());
		                TransformerFactory transformerFactory = TransformerFactory
				                .newInstance();
				        Transformer transformer = transformerFactory.newTransformer();
				        DOMSource source = new DOMSource(doc);
				        StreamResult result = new StreamResult(new File(file));
				        transformer.transform(source, result);
		            } catch (ParserConfigurationException e) {              
		                e.printStackTrace();
		            } catch (IllegalStateException e) {
		                e.printStackTrace();
		            } catch (TransformerConfigurationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (TransformerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}                           
		        }
		        
		      
}
}
