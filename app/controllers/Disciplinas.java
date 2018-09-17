package controllers;

import java.util.List;

import annotations.Admin;
import interceptors.Secure;
import models.Disciplina;
import models.Professor;
import play.data.validation.Valid;
import play.mvc.Controller;
import play.mvc.With;

@Admin
@With(Secure.class)
public class Disciplinas extends Controller{
	
	public static void cadastro_disciplina() {
		List<Professor> professores = Professor.findAll();
		render(professores);
	}
	
	public static void salvarDisciplina(@Valid Disciplina disciplina) {
		if(validation.hasErrors()) {
			validation.keep();
			params.flash();
			cadastro_disciplina();
		}
		if(verificarProfessor(disciplina.professor.id)) {
			flash.error("Professor(a) já está vinculado a uma disciplina, tente outro(a)!");
			cadastro_disciplina();
		}else {
			if(disciplina.save() != null) {
				flash.success("Disciplina salva com sucesso!");
				listarDisciplina();
			}else {
				flash.error("Disciplina não foi salva, tente novamente!");
				listarDisciplina();
			}
		}
		
	}
	
	public static void editarDisciplina(long id) {
		Disciplina disciplina = Disciplina.findById(id);
		List<Professor> professores = Professor.findAll();
		renderTemplate("Disciplinas/cadastro_disciplina.html",disciplina, professores);
	}
    
	
	 public static void listarDisciplina() {
	    	List<Disciplina> disciplinas = Disciplina.findAll();
	    	render(disciplinas);
	 }
	 
	 public static List<Disciplina> getListaDisciplina(){
	    	List<Disciplina> disciplinas = Disciplina.findAll();
	    	return disciplinas;
	    }
	  
	 public static void removerDisciplina(long id) {
	    	Disciplina disciplina = Disciplina.findById(id);
	    	if(disciplina.delete() != null) {
	    		flash.success("Disciplina removida com sucesso!");
	    		listarDisciplina();
	    	}else {
	    		flash.error("Disciplina não foi removida!");
	    		listarDisciplina();
	    	}
	    }
	 public static boolean verificarProfessor(long id) {
		 Disciplina disciplina = Disciplina.find("professor_id", id).first();
		 if(disciplina != null) {
			 return true;
		 }
		 return false;
	 }
	 
	 public static void detalhesDisciplina(long id) {
		 Disciplina disciplinas = Disciplina.findById(id);
		 render(disciplinas);
	 }
}
