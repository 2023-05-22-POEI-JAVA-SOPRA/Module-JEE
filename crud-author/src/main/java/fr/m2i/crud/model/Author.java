package fr.m2i.crud.model;

import java.sql.Date;

public class Author {
	
	int id;
	
	String nom;
	String prenom;
	
	int nb_titre;
	int nb_lecture;
	
	Date birthday;

	
	
	
	public Author(int id, String nom, String prenom, int nb_titre, int nb_lecture, Date birthday) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.nb_titre = nb_titre;
		this.nb_lecture = nb_lecture;
		this.birthday = birthday;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getNb_titre() {
		return nb_titre;
	}

	public void setNb_titre(int nb_titre) {
		this.nb_titre = nb_titre;
	}

	public int getNb_lecture() {
		return nb_lecture;
	}

	public void setNb_lecture(int nb_lecture) {
		this.nb_lecture = nb_lecture;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", nb_titre=" + nb_titre + ", nb_lecture="
				+ nb_lecture + ", birthday=" + birthday + "]";
	}
	
	
	
}
