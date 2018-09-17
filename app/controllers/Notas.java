package controllers;

import java.util.List;

import models.Disciplina;
import models.Nota;
import models.Turma;
import play.mvc.Controller;

public class Notas extends Controller{
	public static void salvarNota(Nota nota) {
		if(nota.save() != null) {
			flash.success("Nota Adicionada com sucesso!");
			adicionarNota(nota.aluno.turma.id);
		}
	}
	
	public static void adicionarNota(long id) {
		Turma turma = Turma.findById(id);
		long professor_id = Long.parseLong(session.get("professor_id"));
		Disciplina disciplina = Disciplina.findById(professor_id);
		List<Nota> notas = Nota.findAll();
		render(turma, disciplina, notas);
	}
	
	public static void listarNotas() {
		render();
	}
}
