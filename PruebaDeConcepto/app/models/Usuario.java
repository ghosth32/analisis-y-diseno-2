package models;

import javax.persistence.Entity;

import play.data.validation.Unique;
import play.db.jpa.Model;

@Entity
public class Usuario extends Model {

	private String nombre;
	@Unique
	private String email;
	private String celular;
	private String direccion;
	private String password;	
	
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
