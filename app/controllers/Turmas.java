package controllers;

import java.util.List;


import annotations.Admin;
import interceptors.Secure;
import models.Disciplina;
import models.Turma;
import play.data.validation.Valid;
import play.mvc.Controller;
import play.mvc.With;

@Admin
@With(Secure.class)
public class Turmas extends Controller{
	

	public static void cadastro_turma() {
		List<Disciplina> disciplinas = Disciplina.findAll();
		render(disciplinas);
	}
	
	
	public static void salvarTurma(@Valid Turma turma) {
		if(validation.hasErrors()) {
			validation.keep();
			params.flash();
			cadastro_turma();
		}
		if(turma.save() != null) {
			flash.success("Turma adicionada com sucesso");
			listarTurma();
		}else {
			flash.error("Houve um erro, tente novamente");
			listarTurma();
		}
	}
	

    public static void listarTurma(){
    	List<Turma> turmas = Turma.findAll();
    	render(turmas);
     } 
	
	public static void editarTurma(long id) {
		Turma turma = Turma.findById(id);
		renderTemplate("Turmas/cadastro_turma.html",turma);
	}
	
	public static List<Turma> getListaTurma(){
    	List<Turma> turmas = Turma.findAll();
    	return turmas;
    }
	
	public static void removerTurma(long id) {
    	Turma turma = Turma.findById(id);
    	if(turma.delete() != null) {
    		flash.success("Turma removida com sucesso!");
    		listarTurma();
    	}else {
    		flash.error("Turma não foi removida!");
    		listarTurma();
    	}
    }
	
	public static void detalhesTurma(long id){
		Turma turmas = Turma.findById(id);
		render(turmas);
	}
	
	
}
