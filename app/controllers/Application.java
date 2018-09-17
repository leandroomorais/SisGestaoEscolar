package controllers;

import interceptors.Secure;
import play.mvc.Controller;
import play.mvc.With;


public class Application extends Controller{
	public static void index() {
		render();
	}
}

