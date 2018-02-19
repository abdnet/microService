package org.uvsq.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.uvsq.dao.AlbumDao;
import org.uvsq.database.DataBase;
import org.uvsq.database.Mysql;
import org.uvsq.entities.Album;
import org.uvsq.entities.Artiste;
import org.uvsq.entities.Chanson;

public class AlbumDaoImpl implements DataBase, AlbumDao {
	private int lastinsertID;

	public AlbumDaoImpl() {
	}

	@Override
	public ArrayList<Album> getAll() {
		ArrayList<Album> album = new ArrayList<Album>();
		Mysql mysql = new Mysql();
		Connection cnx = mysql.getconnexion();
		try {
			PreparedStatement albums = cnx.prepareStatement(DB_GET_ALL_ALBUM);
			ResultSet rs = albums.executeQuery();
			while (rs.next()) {
				Album a = new Album();
				a.setTitleAlbum(rs.getString("title"));
				a.setIdArtist(rs.getInt("artiste"));
				a.setDateAlbum(rs.getString("date"));
				a.setCountryAlbum(rs.getString("pays"));
				a.setformatAlbum(rs.getString("format"));
				a.setPiste(rs.getInt("piste"));
				a.setlangue(rs.getString("langue"));
				a.setLabel(rs.getString("label"));
				a.setIdMB(rs.getString("idMB"));
				a.setIdAlbum(rs.getInt("idAlbum"));
				album.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return album;
	}

	@Override
	public void addAlbum(Album alb) throws SQLException {// TODO Auto-generated
		Mysql mysql = new Mysql();
		Connection cnx = mysql.getconnexion();
		PreparedStatement album = cnx.prepareStatement(DB_ADD_ONE_ALBUM,
				Statement.RETURN_GENERATED_KEYS);

		album.setString(1, alb.getTitleAlbum());
		album.setInt(2, alb.getIdArtist());
		album.setString(3, alb.getformatAlbum());
		album.setInt(4, alb.getPiste());
		album.setString(5, alb.getDateAlbum());
		album.setString(6, alb.getLabel());
		album.setString(7, alb.getpaysAlbum());
		album.setString(8, alb.getlangue());
		album.setString(9, alb.getIdMB());
		album.executeUpdate();
		ResultSet rs = album.getGeneratedKeys();
		if (rs.next()) {
			this.lastinsertID = rs.getInt(1);
		}
		mysql.close();

	}

	@Override
	public Album getAlbumById(int idAlbum) {
		Album a = new Album();
		try {
			Mysql mysql = new Mysql();
			Connection cnx = mysql.getconnexion();
			PreparedStatement album = cnx.prepareStatement(DB_ALBUM_BY_ID);
			album.setInt(1, idAlbum);
			ResultSet rs = album.executeQuery();
			if (rs.next()) {
				a.setTitleAlbum(rs.getString("title"));
				a.setIdArtist(rs.getInt("artiste"));
				a.setDateAlbum(rs.getString("date"));
				a.setCountryAlbum(rs.getString("pays"));
				a.setformatAlbum(rs.getString("format"));
				a.setPiste(rs.getInt("piste"));
				a.setlangue(rs.getString("langue"));
				a.setLabel(rs.getString("label"));
				a.setIdMB(rs.getString("idMB"));
				a.setIdAlbum(rs.getInt("idAlbum"));
			}
			mysql.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return a;
	}

	@Override
	public ArrayList<Album> getAlbumByTitre(String title) {
		ArrayList<Album> albums = new ArrayList<Album>();
		try {
			Mysql mysql = new Mysql();
			Connection cnx = mysql.getconnexion();
			PreparedStatement album = cnx.prepareStatement(DB_ALBUM_BY_TITLE);
			album.setString(1, "%" + title + "%");
			ResultSet rs = album.executeQuery();
			while (rs.next()) {
				Album a = new Album();
				a.setTitleAlbum(rs.getString("title"));
				a.setIdArtist(rs.getInt("artiste"));
				a.setDateAlbum(rs.getString("date"));
				a.setCountryAlbum(rs.getString("pays"));
				a.setformatAlbum(rs.getString("format"));
				a.setPiste(rs.getInt("piste"));
				a.setlangue(rs.getString("langue"));
				a.setLabel(rs.getString("label"));
				a.setIdMB(rs.getString("idMB"));
				a.setIdAlbum(rs.getInt("idAlbum"));
				albums.add(a);
			}
			mysql.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return albums;
	}

	@Override
	public ArrayList<Album> getAlbumByArtiste(String a) {
		ArrayList<Album> albums = new ArrayList<Album>();
		try {
			Mysql mysql = new Mysql();
			Connection cnx = mysql.getconnexion();
			PreparedStatement album = cnx.prepareStatement(DB_ALBUM_BY_ARTISTE);
			album.setString(1, "%" + a + "%");
			ResultSet rs = album.executeQuery();
			while (rs.next()) {
				albums.add(this.getAlbumById(rs.getInt("idAlbum")));
			}
			mysql.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return albums;
	}

	@Override
	public ArrayList<Album> getAlbummByChanson(String ch) {

		ArrayList<Album> albums = new ArrayList<Album>();
		try {
			Mysql mysql = new Mysql();
			Connection cnx = mysql.getconnexion();
			PreparedStatement album = cnx.prepareStatement(DB_ALBUM_BY_CHANSON);
			album.setString(1, "%" + ch + "%");
			ResultSet rs = album.executeQuery();
			while (rs.next()) {
				albums.add(this.getAlbumById(rs.getInt("idAlbum")));
			}
			mysql.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return albums;
	}

	@Override
	public int getLastInsertId() {
		return this.lastinsertID;
	}

}
