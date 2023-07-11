package fr.m2i.curd.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import fr.m2i.crud.model.Author;

public class AuthorService {

	
	
	public boolean create(Author a) {
		
		try {
			Connection con = UtilConnection.seConnecter();
			PreparedStatement ps = con.prepareStatement("INSERT INTO Author (nom, prenom, nb_lecture, nb_titre, birthday) VALUE (?,?,?,?,?)");
			
			ps.setString(1, a.getNom() );
			ps.setString(2, a.getPrenom() );
			ps.setInt(3, a.getNb_lecture() );
			ps.setInt(4, a.getNb_titre() );
			ps.setDate(5, a.getBirthday() );

			int result = ps.executeUpdate();			
			
			con.close();
			ps.close();
			
			if (result == 1) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	public Author getById(int id) {
		Author author = null;
		
		try {
			Connection con = UtilConnection.seConnecter();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Author WHERE id = ?;");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				
				int nb_titre = rs.getInt("nb_titre");
				int nb_lecture = rs.getInt("nb_lecture");
				
				Date birthday = rs.getDate("birthday");
				
				author = new Author(id, nom, prenom, nb_titre, nb_lecture, birthday);
			}
			con.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return author;
	}
	
	
	public ArrayList<Author> getAll(){
		ArrayList<Author> listAuthor = new ArrayList<>();
		
		try {
			Connection con = UtilConnection.seConnecter();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Author");
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next()) {
				int id = rs.getInt("id");

				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				
				int nb_titre = rs.getInt("nb_titre");
				int nb_lecture = rs.getInt("nb_lecture");
				
				Date birthday = rs.getDate("birthday");
				
				Author author = new Author(id, nom, prenom, nb_titre, nb_lecture, birthday);
				
				listAuthor.add(author);
			}
			
			con.close();
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listAuthor;
	}
	
	
	public boolean delete(int id) {
		
		try {
			Connection con = UtilConnection.seConnecter();
			
			PreparedStatement ps = con.prepareStatement("DELETE FROM Author WHERE id = ?;");
			ps.setInt(1, id);
			
			int result = ps.executeUpdate();
			
			con.close();
			ps.close();
			
			if (result == 1) {
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean update(int id, Author a) {
		
		try {
			Connection con = UtilConnection.seConnecter();
			PreparedStatement ps = con.prepareStatement("UPDATE Author SET nom = ?, prenom = ?, birthday = ?, nb_titre = ?, nb_lecture = ? WHERE id = ?;");
			
			ps.setString(1, a.getNom() );
			ps.setString(2, a.getPrenom() );
			ps.setDate(3, a.getBirthday() );
			ps.setInt(4, a.getNb_titre() );
			ps.setInt(5, a.getNb_lecture() );
			ps.setInt(6, id );
			
			
			int result = ps.executeUpdate();
			
			con.close();
			ps.close();
			
			if (result == 1)
				return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}	
}
