package org.uvsq.database;

public interface DataBase {
	  static final String DB_USER="root"; 
	  static final String DB_PWD="root"; 
	  static final String DB_NAME="music"; 
	  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	  static final String DB_URL = "jdbc:mysql://localhost/"+DB_NAME+"?useSSL=false";
	  
	  /*Requetes usuelles */
	  
	  //Chanson
	  static final String DB_GET_BY_ID_CHANSON = "select * from chanson where idSong=?";
	  static final String DB_GET_BY_TITILE_CHANSON = "select * from chanson where titleSong like ?";
	  static final String DB_DELETE_BY_ID_CHANSON="Delete from chanson where id=?";
	  static final String DB_GET_ALL_CHANSON="select * from chanson";
	  static final String DB_DELETE_ALL_CHANSON="Delete from chanson";
	  static final String DB_CHANSON_BY_ARTISTE ="select c.idSong from artiste as a,chanson as c where a.nom like ? and a.id=c.idArtiste";
	  static final String DB_CHANSON_BY_ALBUM ="select c.idSong from album as alb,chanson as c where alb.title like ? and alb.idAlbum=c.idAlbum";


	  
	  //Artiste
	  
	  static final String DB_GET_BY_ID_ARTISTE = "select * from artiste where id=?";
	  static final String DB_GET_BY_NAME_ARTISTE = "select * from artiste where nom=?";

	  static final String DB_DELETE_BY_ID_ARTISTE="Delete from artiste where id=?";
	  static final String DB_GET_ALL_ARTISTE="select * from artiste";
	  static final String DB_DELETE_ALL_ARTISTE="Delete from artiste";
	  
	  //Album
	  static final String DB_GET_BY_ID_ALBUM = "select * from album where id=?";
	  static final String DB_DELETE_BY_ID_ALBUM="Delete from album where id=?";
	  static final String DB_GET_ALL_ALBUM="select * from album";
	  static final String DB_DELETE_ALL_ALBUM="Delete from album";
	  
	  /*Requetes avec jointure */
	  
	  /*Les insertions */
	  static final String DB_ADD_ONE_ALBUM ="INSERT INTO `album` (`title`, `artiste`, `format`, `piste`, `date`, `label`, `pays`, `langue`, `idMB`) VALUES (?,?,?,?,?,?,?,?,?)";
	  static final String DB_ADD_ONE_ARTISTE ="INSERT INTO `artiste` (`nom`, `disambiguation`, `gender`,`area`) VALUES (?,?,?,?)";
	  static final String DB_ADD_ONE_CHANSON ="INSERT INTO `chanson` (`titleSong`, `duree`, `idArtiste`, `idAlbum`, `idMB`) VALUES (?,?,?,?,?)";
	  static final String DB_ALBUM_BY_ARTISTE ="select al.idAlbum from artiste as a,album as al where a.nom like ? and a.id=al.artiste";
	  static final String DB_ALBUM_BY_ID ="select * from album where idAlbum=?";
	  static final String DB_ALBUM_BY_CHANSON ="select al.idAlbum from album as al ,chanson as c where c.titleSong like ? and al.idAlbum=c.idAlbum";
	  static final String DB_ALBUM_BY_TITLE ="select * from album where title like ?";
	  
	  //api musicbrainz
	  
	  static final String MB_URL_GET_RECORDING_BY_ARTISTE="http://musicbrainz.org/ws/2/recording/?query=artist:";
	  static final String MB_URL_GET_RECORDING_BY_ALBUM="http://musicbrainz.org/ws/2/recording/?query=release:";
	  
}
