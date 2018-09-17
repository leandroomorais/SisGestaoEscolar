package controllers;

import java.util.List;

import annotations.Admin;
import interceptors.Secure;
import models.Aluno;
import models.Disciplina;
import models.Professor;
import models.Secretaria;
import play.data.validation.Valid;
import play.mvc.Controller;
import play.mvc.With;

@Admin
@With(Secure.class)
public class Secretarias extends Controller{
	
		public static void salvarSecretaria(@Valid Secretaria secretaria) {
			if(validation.hasErrors()) {
				validation.keep();
				params.flash();
				Administradores.cadastrarSecretaria();
			}
			if(params.get("excluirFoto") != null) {
				secretaria.foto.getFile().delete();
			}
			
			secretaria.save();
			flash.success("Secretário(a) salvo (a) com sucesso!");
			listarSecretaria();			
		}
		
		public static void listarSecretaria(){
	    	List<Secretaria> secretarias = Secretaria.findAll();
	    	render(secretarias);
	     } 
	
	 	public static List<Secretaria> getListaSecretaria(){
	    	List<Secretaria> secretaria = Secretaria.findAll();
	    	return secretaria;
	    }
	    
	    public static Secretaria buscaSecretariaBD(String matricula, String senha) {
	    	return Secretaria.find("matricula = ? and senha =?", matricula, senha).first();
	    }
	    
	    public static void removerSecretaria(long id) {
	    	Secretaria secretaria = Secretaria.findById(id);
	    	if(secretaria.delete() != null) {
	    		flash.success("Secretario(a) removido(a) com sucesso!");
	    		listarSecretaria();
	    	}else {
	    		flash.error("Houve um erro, tente novamente!");
	    		listarSecretaria();
	    	}
	    }
	    
		public static void editarSecretaria(long id) {
			Secretaria secretaria = Secretaria.findById(id);
			renderTemplate("Administradores/cadastrarSecretaria.html",secretaria);
		}
		

	    public static void portal_secretaria() {
	    	List<Secretaria> secretaria = Secretaria.findAll();
	    	long professores = Professor.count();
	    	long alunos = Aluno.count();
	    	render(secretaria,alunos, professores);
	    }
	    
	    
	    public static void fotoSecretaria(long id) {
	    	Secretaria secretaria = Secretaria.findById(id);
	    	notFoundIfNull(secretaria);
	    	response.setContentTypeIfNotSet(secretaria.foto.type());
	    	renderBinary(secretaria.foto.get());
	    }
	    
	    public static void meusDados() {
	    	Secretaria secretaria = Secretaria.find("nome = ?", session.get("nome")).first();
	    	render(secretaria);
	    }
	    
	    public static void busca(String busca) {
	    	Professor professor = Professor.find("nome like ? or matricula like ?", "%" + busca + "%", "%" + busca + "%").first();
	    	Aluno aluno = Aluno.find("nome like ? or matricula like ?", "%" + busca+ "%", "%"+busca+"%").first();
	    	if(professor != null) {
	    		flash.success("Professor(a) Encontrado!");
	    		renderTemplate("Secretarias/pesquisa_professor.html", professor);
	    	}else if(aluno != null) {
	    		flash.success("Aluno(a) Encontrado!");
	    		List<Disciplina> disciplinas = Disciplina.findAll();
	    		renderTemplate("Secretarias/pesquisa_aluno.html", aluno, disciplinas);
	    	}else if(aluno == null){
	    		flash.error("Busca sem Sucesso!");
	    		renderTemplate("Secretarias/portal_secretaria.html");
	    	}else if(professor == null) {
	    		flash.error("Busca sem Sucesso!");
	    		renderTemplate("Secretarias/portal_secretaria.html");
	    	}
	    }
}
