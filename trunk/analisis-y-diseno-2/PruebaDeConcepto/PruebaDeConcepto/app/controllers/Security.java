package controllers;

import play.mvc.Controller;

public class Security extends Controller {

	public static void login() {
		render();
	}
	
	public static void authenticate(String email, String password) {
		
		System.out.println(email);
		System.out.println(password);
		
		session.put("nombre", email);
		Application.index();
		
	}
}
