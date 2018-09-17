package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.data.validation.Email;
import play.data.validation.Required;
import play.db.jpa.Blob;
import play.db.jpa.Model;

@Entity
public class Professor extends Model{
	
	@Required
	@Email
	public String email;
	
	@Required
	public String nome;
	@Required
	public String matricula;
	@Required
	public String formacao;
	@Required
	public String sexo;
	@Required
	public String rua;
	@Required
	public String numeroCasa;
	@Required
	public String bairro;
	@Required
	public String uf;
	@Required
	public String cidade;
	@Required
	public String cpf;
	@Required
	public String rg;
	@Required
	public String ExpedidorRg;
	@Required
	@Temporal(TemporalType.DATE)
	public Date dataExpedicao;
	@Required
	@Temporal(TemporalType.DATE)
	public Date dataNascimento;
	@Required
	public String senha;
	public Blob foto;
	
	@Required
	@ManyToOne
	@JoinColumn(name="turma_id")
	public Turma turma;
	
	@OneToOne(mappedBy="professor")
	public Disciplina disciplina;
	
}
