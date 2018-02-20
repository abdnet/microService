package org.uvsq.database;

import java.sql.*;



public class Mysql implements DataBase{
	private Connection conn;
	public Mysql() {
			this.Connexion();
	}
	
	
	
	public void Connexion(){
		try {
			Class.forName(JDBC_DRIVER);
			this.conn = DriverManager.getConnection(DB_URL, DB_USER,DB_PWD);

		}catch ( ClassNotFoundException e){ e.printStackTrace();}
		catch ( SQLException e)
		{
			e.printStackTrace();}
		}
	
	public Connection getconnexion(){
		return this.conn;
	}
	public void close(){
		try {
			this.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
