package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Turma extends Model{
	
	@Required
	public String anoEscolar;
	@Required
	public String nomeTurma;
	@Required
	public Integer numeroSala;
	@Required
	public String turno;
	
	 
	@OneToMany(mappedBy="turma")
	public List<Aluno> alunos;
	 
	@OneToMany(mappedBy="turma")
	public List<Professor> professores;
	
}
