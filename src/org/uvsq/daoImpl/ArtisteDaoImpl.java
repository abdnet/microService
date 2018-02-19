package org.uvsq.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.uvsq.dao.ArtisteDao;
import org.uvsq.database.DataBase;
import org.uvsq.database.Mysql;
import org.uvsq.entities.Album;
import org.uvsq.entities.Artiste;
import org.uvsq.entities.Chanson;


public class ArtisteDaoImpl implements ArtisteDao,DataBase{

	private Mysql mysql;
	private int lastinsertID;
	
	@Override
	public ArrayList<Artiste> getAll() {
			
		return null;
	}

	@Override
	public void addArtiste(Artiste a) throws SQLException {
		mysql=new Mysql();
		Connection cnx = mysql.getconnexion();
	    PreparedStatement artiste = cnx.prepareStatement(DB_ADD_ONE_ARTISTE,Statement.RETURN_GENERATED_KEYS);
	      
	      artiste.setString(1, a.getName());
	      artiste.setString(2,a.getdisambiguation());
	      artiste.setString(3, a.getGender());
	      artiste.setString(4, a.getArea());
	      artiste.executeUpdate();
          ResultSet rs=artiste.getGeneratedKeys();
          if(rs.next()){
              this.lastinsertID=rs.getInt(1);
          }
	      mysql.close();
	}
	

	@Override
	public Artiste getArtisteById(int idArtiste) {
		Artiste a = new Artiste();
		mysql=new Mysql();
		Connection cnx = mysql.getconnexion();
	    try {
			PreparedStatement artiste=cnx.prepareStatement(DB_GET_BY_ID_ARTISTE);
			artiste.setInt(1,idArtiste);
			ResultSet rs=artiste.executeQuery();
			        if(rs.next())
			        {
			           a.setArea(rs.getString("area"));
			           a.setdisambiguation(rs.getString("disambiguation"));
			           a.setGender(rs.getString("gender"));
			           a.setName(rs.getString("nom"));
			           a.setId(rs.getInt("id"));
			        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return a;
	}

	@Override
	public ArrayList<Artiste> getArtisteByChanson(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Artiste> getArtisteByName(String nom) {
		ArrayList<Artiste> artistes = new ArrayList<Artiste>();
		mysql=new Mysql();
		Connection cnx = mysql.getconnexion();
	    try {
			PreparedStatement artiste=cnx.prepareStatement(DB_GET_BY_NAME_ARTISTE);
			artiste.setString(1,nom);
			ResultSet rs=artiste.executeQuery();
			        while(rs.next())
			        {
			    	 
			           artistes.add(new Artiste(rs.getInt("id"),rs.getString("nom"),rs.getString("disambiguation"),rs.getString("gender"),rs.getString("area")));
			        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return artistes;
	}

	@Override
	public Artiste getArtisteByAlbum(Album ch) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int getLastInsertId(){
		return this.lastinsertID;
	}

	@Override
	public int getByIdMB(String idMB) {
			int id =0;
			try {
				Mysql mysql = new Mysql();
				Connection cnx = mysql.getconnexion();
				PreparedStatement artiste = cnx.prepareStatement(DB_GET_BY_IDMB_ARTISTE);
				artiste.setString(1, idMB);
				ResultSet rs = artiste.executeQuery();
				if (rs.next()) {
					id=rs.getInt("id");
				}
				mysql.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return id;
		}
	

}
