package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.data.validation.Email;
import play.data.validation.Required;
import play.db.jpa.Blob;
import play.db.jpa.Model;

@Entity
public class Aluno extends Model{
	@Required
	@Email
	public String email;
	
	@Required
	public String nome;
	
	@Required
	public String matricula;
	
	@Required
	public String rua;
	
	@Required
	public String bairro;
	
	@Required
	public String numeroCasa;
	
	@Required
	public String cidade;
	
	@Required
	public String ufCidade;
	
	@Required
	public String cep;
	
	@Required
	public String cpf;
	
	@Required
	@Temporal(TemporalType.DATE)
	public Date dataNascimento;
	
	@Required
	public String senha;
	
	@Required
	public String naturalidade;
	
	@Required
	public String ufNaturalidade;
	
	@Required
	public String sexo;
	
	@Required
	public String certidaoCivilNum;
	
	@Required
	public String folhaCertidao;
	
	@Required
	public String livroCertidao;
	
	@Required
	public String cartorioCertidao;
	
	@Required
	public String rgNumero;
	
	@Required
	public String rgExpedidor;
	
	@Required
	@Temporal(TemporalType.DATE)
	public Date dataExpedicao;
	
	@Required
	public String nomeMae;
	
	@Required
	public String nomePai;
	
	public Blob foto;
	
	@Required
	@ManyToOne
	@JoinColumn(name="turma_id")
	public Turma turma;
	
	@Required
	@ManyToMany
	@JoinTable(name="alunos_disciplinas")
	public List<Disciplina> disciplinas;
	
	 
	@OneToMany(mappedBy="aluno")
	public List<Nota> notas;
	
	 
	 
}
