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
	
	public Usuario() {
    }
	public Usuario(String email, String password, String nombre, 
			String direccion, String celular) {
        this.email = email;
        this.password = password;
        this.direccion = direccion;
        this.celular = celular;
        this.nombre = nombre;
    }
	
	public static Usuario connect(String email, String password) {
	    return find("byEmailAndPassword", email, password).first();
	}
}
