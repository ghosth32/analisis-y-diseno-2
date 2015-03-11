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
		
		int a = 0;
		
		String Hola_MUNDO;
		
		List<Usuario> usuarios = Usuario.find("email = ? and password=?",email,password).fetch();
		
		if (usuarios.isEmpty()) {
			flash.put("error", "Credenciales invalidas");
			login();
		} else {
			Application.index();
		}
		
	}
	
	private static boolean checkRequired(String name, String email, String phone, String address, String password, String passwordConfirm) {
		return "".equals(name) || "".equals(email) || "".equals(phone) || "".equals(address) || "".equals(password) || "".equals(passwordConfirm);
	}
}