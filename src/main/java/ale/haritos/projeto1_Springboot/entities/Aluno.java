package ale.haritos.projeto1_Springboot.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "`alunos`")
public class Aluno extends Pessoa {

	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false, length = 20)
	private String ra;
	
	@OneToMany(mappedBy = "id.aluno")
	Set<Matricula> matriculas = new HashSet<>();
	
	public Aluno() {
		
	}

	public Aluno(Long id, String nome, String telefone, String email, String ra) {
		super(id, nome, telefone, email);
		this.ra = ra;
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}
	
	public Set<Matricula> getMatriculas() {
		return this.matriculas;
	}
}
