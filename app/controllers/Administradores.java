package controllers;

import interceptors.Secure;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Administradores extends Controller{

		public static void cadastrarSecretaria() {
			render();
		}
		
		public static void listarSecretaria() {
			render();
		}
		
		public static void portalAdmin() {
			render();
		}
}
