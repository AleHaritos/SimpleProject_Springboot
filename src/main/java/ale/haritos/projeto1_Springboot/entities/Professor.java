package ale.haritos.projeto1_Springboot.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "`professores`")
public class Professor extends Pessoa {

	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	private Double salarioBruto;
	
	@ManyToOne
	@JoinColumn(name ="curso_id")
	private Curso curso;
	
	public Professor() {
		
	}


	public Professor(Long id, String nome, String telefone, String email, Double salarioBruto) {
		super(id, nome, telefone, email);
		this.salarioBruto = salarioBruto;
	}


	public Double getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(Double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}
	
	
	
}
