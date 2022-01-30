package ale.haritos.projeto1_Springboot.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import ale.haritos.projeto1_Springboot.entities.pk.Matricula_pk;
import ale.haritos.projeto1_Springboot.enuns.Status;

@Entity
@Table(name ="`matricula`")
public class Matricula implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private Matricula_pk id = new Matricula_pk();
	private Status status;
	
	public Matricula() {
		
	}

	public Matricula(Aluno a, Curso c, Status status) {
		super();
		id.setAluno(a);
		id.setCurso(c);
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public void setAluno(Aluno a) {
		id.setAluno(a);
	}
	
	public Aluno getAluno() {
		return id.getAluno();
	}
	
	public void setCurso(Curso c) {
		id.setCurso(c);
	}
	
	public Curso getCurso() {
		return id.getCurso();
	}
}
