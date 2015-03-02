package models;

import javax.persistence.Entity;

import play.data.validation.Unique;
import play.db.jpa.Model;

@Entity
public class Usuario extends Model {

	public String nombre;
	@Unique
	public String email;
	public String celular;
	public String direccion;
	public String password;	
}
