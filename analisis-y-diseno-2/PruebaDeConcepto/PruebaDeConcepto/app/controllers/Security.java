package controllers;

import java.util.List;

import models.Usuario;
import play.mvc.Controller;

public class Security extends Controller {

	public static void login() {
		render();
	}
	
	public static void authenticate(String email, String password) {
		
		System.out.println("hola");
		System.out.println(email);
		System.out.println(password);
		
		session.put("nombre", email);
		
		List<Usuario> usuarios = Usuario.find("email = ? and password=?",email,password).fetch();
		
		Usuarios esto deberia fallar
		
		if (usuarios.isEmpty()) {
			System.out.println("ERRROR");
			login();
		} else {
			Application.index();
		}
			
//		Usuario usuario = new Usuario();
//		usuario.email ="patito@algo.com";
//		usuario.edad = 15;
//		usuario.nombre = "Patito";
//		usuario.save();
		
	}
}
