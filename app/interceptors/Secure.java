package interceptors;

import annotations.Admin;
import controllers.Application;
import play.mvc.Before;
import play.mvc.Controller;

public class Secure extends Controller {
	
	@Before
	static void checharAutenticacao() {
		String secretaria = session.get("nome");
		String aluno = session.get("aluno");
		String professor = session.get("professor");
		String admin = session.get("admin");
		
		boolean seguranca = getControllerAnnotation(Admin.class) != null ||
	   			getActionAnnotation(Admin.class) != null;
		
		if(seguranca && (secretaria == null && aluno == null && professor == null && admin == null)) {
			flash.error("Por favor, entre com seu login e senha.");
			Application.index();
		}
	}

}
