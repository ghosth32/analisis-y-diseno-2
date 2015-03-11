package controllers;

import java.util.List;

import models.Usuario;
import play.mvc.Controller;

public class Security extends Controller {

	public static void login() {
		render();
	}
	
	public static void registro() {
		render();
	}
	
	public static void closeSession() {
		session.remove("nombre");
		Application.index();
	}
	
	public static void authenticate(String email, String password) {
		
		session.put("nombre", email);	
		
		List<Usuario> usuarios = Usuario.find("email = ? and password=?",email,password).fetch();
		
		if (usuarios.isEmpty()) {
			flash.put("error", "Credenciales invalidas");
			login();
		} else {
			Application.index();
		}
		
	}
	
public static void createAccount(String nombre, String correo, String celular, String direccion, String password, String passwordConfirm) {
		
		if (checkRequired(nombre, correo, celular, direccion, password, passwordConfirm)) {
			flash.put("error", "Todos los parametros son requeridos");
		} else {
			
			if (password.equals(passwordConfirm)) {
				Usuario usuario = new Usuario();
				usuario.nombre = nombre;
				usuario.email = correo;
				usuario.celular = celular;
				usuario.direccion = direccion;
				usuario.password = password;
				usuario.save();
				
				flash.put("success", "Usuario creado con éxito");
				Application.index();
			} else {
				flash.put ("error", "El password no coincide");
				registro(); //returning to the page
			}
		}
	}
	
	private static boolean checkRequired(String name, String email, String phone, String address, String password, String passwordConfirm) {
		return "".equals(name) || "".equals(email) || "".equals(phone) || "".equals(address) || "".equals(password) || "".equals(passwordConfirm);
	}
}