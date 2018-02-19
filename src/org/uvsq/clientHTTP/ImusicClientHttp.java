package org.uvsq.clientHTTP;

import java.io.IOException;

import org.xml.sax.SAXException;


public interface ImusicClientHttp{
	
	public void getSongByArtist(String artist,String file) throws UnsupportedOperationException, SAXException, IOException;

}
