package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Usuario extends Model {

	public String email;
	public String password;
	public String nombre;
	public int edad;
}
