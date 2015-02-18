package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
    	String nombre = session.get("nombre") == null 
    					? "vacio" 
    					: session.get("nombre");
        render(nombre);
    }

}