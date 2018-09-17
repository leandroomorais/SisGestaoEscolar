package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.data.validation.Email;
import play.data.validation.Required;
import play.db.jpa.Blob;
import play.db.jpa.Model;

@Entity
public class Secretaria extends Model{
	@Required
	@Email
	public String email;
	
	@Required
	public String nome; 
	
	@Required
	public String matricula; 
	
	@Required
	public String senha; 
	
	@Required
	public String cpf;
	
	@Required 
	public String rg;
	
	public Blob foto;
	
	@Required
	public String estado;
	
	@Required
	public String cidade;
	
	@Required
	public String numCasa;
	
	@Required
	public String rua;
	
	@Required
	public String bairro;
	
	@Required
	public String cep;
	
	@Required
	@Temporal(TemporalType.DATE)
	public Date dataNascimento;

}
