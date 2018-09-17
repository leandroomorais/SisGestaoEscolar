package models;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Disciplina extends Model{
	@Required
	public String nomeDisciplina;
	
	@ManyToMany(mappedBy="disciplinas")
	public List<Aluno> alunos;
	
	@OneToOne
	@JoinColumn(name="professor_id")
	public Professor professor;
	
}
