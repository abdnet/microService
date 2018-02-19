package org.uvsq.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.uvsq.dao.ChansonDao;
import org.uvsq.database.DataBase;
import org.uvsq.database.Mysql;
import org.uvsq.entities.Album;
import org.uvsq.entities.Artiste;
import org.uvsq.entities.Chanson;

public class ChansonDaoImpl implements DataBase,ChansonDao{
	private int lastinsertID;

	public ChansonDaoImpl()  {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Chanson> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addChanson(Chanson ch) {
		// (`titleSong`, `duree`, `idArtiste`, `idAlbum`, `idMB`)
		Mysql mysql = new Mysql();
		Connection cnx = mysql.getconnexion();
		
		try {
			PreparedStatement chanson = cnx.prepareStatement(DB_ADD_ONE_CHANSON,
					Statement.RETURN_GENERATED_KEYS);
			
			chanson.setString(1, ch.getTitleSong());
			chanson.setDouble(2, ch.getDureeSong());
			chanson.setString(5, ch.getIdMB());
			chanson.setInt(3, ch.getIdArtist());
			chanson.setInt(4,ch.getIdAlbum());
			chanson.executeUpdate();
			ResultSet rs = chanson.getGeneratedKeys();
			if (rs.next()) {
				this.lastinsertID = rs.getInt(1);
			}
			mysql.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	@Override
	public Chanson getChansonById(int idChanson) {
		Chanson chanson = new Chanson();
		try {
			Mysql mysql = new Mysql();
			Connection cnx = mysql.getconnexion();
			PreparedStatement c = cnx.prepareStatement(DB_GET_BY_ID_CHANSON);
			c.setInt(1, idChanson);
			ResultSet rs = c.executeQuery();
			if (rs.next()) {
				chanson.setDureeSong(rs.getDouble("duree"));
				chanson.setIdAlbum(rs.getInt("idAlbum"));
				chanson.setIdArtist(rs.getInt("idArtiste"));
				chanson.setIdMB(rs.getString("idMB"));
				chanson.setTitleSong(rs.getString("titleSong"));
				chanson.setIdSong(rs.getInt("idSong"));
			}
			mysql.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return chanson;
	}

	@Override
	public ArrayList<Chanson> getChansonByTitre(String title) {
		
		ArrayList<Chanson> chansons = new ArrayList<Chanson>();
		try {
			Mysql mysql = new Mysql();
			Connection cnx = mysql.getconnexion();
			PreparedStatement c = cnx.prepareStatement(DB_GET_BY_TITILE_CHANSON);
			c.setString(1, "%"+title+"%");
			ResultSet rs = c.executeQuery();
			while (rs.next()) {
				Chanson chanson = new Chanson();
				chanson.setDureeSong(rs.getDouble("duree"));
				chanson.setIdAlbum(rs.getInt("idAlbum"));
				chanson.setIdArtist(rs.getInt("idArtiste"));
				chanson.setIdMB(rs.getString("idBM"));
				chanson.setTitleSong(rs.getString("titleSong"));
				chanson.setIdSong(rs.getInt("idSong"));
				chansons.add(chanson);
				
			}
			mysql.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return chansons;
	}

	@Override
	public ArrayList<Chanson> getChansonByArtiste(String artiste) {
		ArrayList<Chanson> chansons = new ArrayList<Chanson>();
		try {
			Mysql mysql = new Mysql();
			Connection cnx = mysql.getconnexion();
			PreparedStatement chanson = cnx.prepareStatement(DB_CHANSON_BY_ARTISTE);
			chanson.setString(1, "%" + artiste + "%");
			ResultSet rs = chanson.executeQuery();
			while (rs.next()) {
				chansons.add(this.getChansonById(rs.getInt("idSong")));
			}
			mysql.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return chansons;
	}

	@Override
	public ArrayList<Chanson> getAllByAlbum(String album) {
		
		ArrayList<Chanson> chansons = new ArrayList<Chanson>();
		try {
			Mysql mysql = new Mysql();
			Connection cnx = mysql.getconnexion();
			PreparedStatement chanson = cnx.prepareStatement(DB_CHANSON_BY_ALBUM);
			chanson.setString(1, "%" + album + "%");
			ResultSet rs = chanson.executeQuery();
			while (rs.next()) {
				chansons.add(this.getChansonById(rs.getInt("idSong")));
			}
			mysql.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return chansons;
	}

	@Override
	public int getLastInsertId() {
		// TODO Auto-generated method stub
		return this.lastinsertID;
	}

	@Override
	public int getByIdMB(String idMB) {
		int id =0;
		try {
			Mysql mysql = new Mysql();
			Connection cnx = mysql.getconnexion();
			PreparedStatement chanson = cnx.prepareStatement(DB_GET_BY_IDMB_CHANSON);
			chanson.setString(1, idMB);
			ResultSet rs = chanson.executeQuery();
			if (rs.next()) {
				id=rs.getInt("idSong");
			}
			mysql.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id;
	}
	

}
