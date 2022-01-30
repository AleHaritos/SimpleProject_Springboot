package ale.haritos.projeto1_Springboot.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import ale.haritos.projeto1_Springboot.entities.Aluno;
import ale.haritos.projeto1_Springboot.entities.Curso;

@Embeddable
public class Matricula_pk implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;
	
	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;
	
	public Matricula_pk() {
		
	}

	public Matricula_pk(Curso curso, Aluno aluno) {
		super();
		this.curso = curso;
		this.aluno = aluno;
		
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}


	@Override
	public int hashCode() {
		return Objects.hash(aluno, curso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matricula_pk other = (Matricula_pk) obj;
		return Objects.equals(aluno, other.aluno) && Objects.equals(curso, other.curso);
	}
	
	
}
