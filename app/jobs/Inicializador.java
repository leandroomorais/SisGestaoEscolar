package jobs;

import models.Aluno;
import models.Disciplina;
import models.Professor;
import models.Secretaria;
import models.Turma;
import play.jobs.Job;
import play.jobs.OnApplicationStart;


@OnApplicationStart
public class Inicializador extends Job {

	/*@Override
	public void doJob() throws Exception {
		
		if(Secretaria.count() == 0) {			
			Secretaria secretaria = new Secretaria();
			secretaria.nome = "Francisca";
			secretaria.matricula = "1234";
			secretaria.senha = "123";
			secretaria.save();
			
			Aluno aluno = new Aluno();
			aluno.matricula = "201801";
			aluno.nome = "Antônio";
			aluno.senha = "123";
			aluno.save();
			
			Aluno aluno2 = new Aluno();
			aluno2.nome = "Francisco Leandro";
			aluno2.senha = "123";
			aluno2.save();
			
			Professor prof = new Professor();
			prof.matricula = "098";
			prof.nome = "João Helis Bernardo";
			prof.senha = "123";
			prof.save();
			
			Professor prof2 = new Professor();
			prof2.nome = "Daniel Aguiar";
			prof2.senha = "123";
			prof2.save();
			
			Turma turma1 = new Turma();
			turma1.anoEscolar = "8º";
			turma1.nomeTurma = "A";
			turma1.numeroSala = 10;
			turma1.save();
			
			Turma turma2 = new Turma();
			turma2.anoEscolar = "7º";
			turma2.nomeTurma = "A";
			turma2.numeroSala = 9;
			turma2.save();
			
			Disciplina disciplina1 = new Disciplina();
			disciplina1.nomeDisciplina = "Português";
			
			

		}
	}*/
}
