package controllers;

import java.util.List;

import org.h2.engine.User;

import annotations.Admin;
import interceptors.Secure;
import models.Aluno;
import models.Professor;
import models.Turma;
import play.data.validation.Valid;
import play.mvc.Controller;
import play.mvc.With;
@Admin
@With(Secure.class)
public class Professores extends Controller{
	
	 public static void portal_professor(Professor professor){
	    render(professor);
	 }
	 
	 public static void diario() {
		 long id = Long.parseLong(session.get("professor_id"));
		 Professor professores = Professor.findById(id);
		 render(professores);
	 }
	 
	 public static void detalhesProfessor(long id) {
		 Professor professores = Professor.findById(id);
		 render(professores);
	 }
	
	public static void cadastro_professor(){
		List<Turma> turmas = Turma.findAll();
		render(turmas);
	}
	
	public static void editarProfessor(long id) {
		Professor professor = Professor.findById(id);
		List<Turma> turmas = Turma.findAll();
		renderTemplate("Professores/cadastro_professor.html",professor,turmas);
	}
	
	public static void salvarProfessor(@Valid Professor professor) {
		if(validation.hasErrors()) {
			validation.keep();
			params.flash();
			cadastro_professor();
		}
		if(params.get("excluirFoto") != null) {
			professor.foto.getFile().delete();
		}
    	if(professor.save() != null) {
    		flash.success("Professor salvo com sucesso!");
    		listarProfessor();
    	}else {
    		flash.error("Professor não foi salvo, tente novamente");
    		cadastro_professor();
    	}
    	
    }
	
	 
	
	public static Professor buscaProfessorBD(String matricula, String senha) {
		return Professor.find("matricula = ? and senha = ?", matricula, senha).first();
    }
	
	public static void pesquisarAluno(String busca) {
		List<Aluno> alunos = Aluno.find("nome like ? or matricula like ?", "%"+busca+"%", "%"+busca+"%").fetch();
		if(alunos.isEmpty()) {
		   flash.error("Aluno não encontrado!");
		   renderTemplate("Professores/portal_professor.html");
		}
		renderTemplate("Professores/pesquisarAluno.html", alunos);
	}
	
	public static void removerProfessor(long id) {
    	Professor professor = Professor.findById(id);
    	if(professor.delete() != null) {
    		flash.success("Professor removido com sucesso!");
    		listarProfessor();
    	}else {
    		flash.error("Professor não foi removido!");
    	}    	
    }
	

    public static void listarProfessor(){
    	List<Professor> professores = Professor.findAll();
    	render(professores);
     } 
    
    public  static  void  fotoProfessor(Long  id) {
	    Professor professor = Professor.findById(id);
	    notFoundIfNull(professor);
	    response.setContentTypeIfNotSet(professor.foto.type());
	    renderBinary(professor.foto.get());
	}
	
}
