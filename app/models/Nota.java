package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Nota extends Model{
	public int primeiroBimestre;
	public int segundoBimestre;
	public int terceiroBimestre;
	public int quartoBimestre;
	public int provaFinal;
	
	@ManyToOne
	@JoinColumn(name="alunos_id")
	public Aluno aluno;
	
	@ManyToOne
	@JoinColumn(name="disciplina_id")
	public Disciplina disciplina;

}
