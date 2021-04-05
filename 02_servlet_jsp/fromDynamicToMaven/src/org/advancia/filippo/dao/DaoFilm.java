package org.advancia.filippo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.advancia.filippo.model.Film;

public class DaoFilm {
	
	public static ArrayList<Film> getAllFilm(){
		ArrayList film = new ArrayList<Film>();
		try {
			Connection conn = dbConnection.getConnection();
			String query = "SELECT * FROM film;";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet srs = ps.executeQuery();
			while(srs.next()){
				Film temp = new Film();
				temp.setId(srs.getInt("id"));
				temp.setTitolo(srs.getString("titolo"));
				film.add(temp);
			}
			return film;
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

}
