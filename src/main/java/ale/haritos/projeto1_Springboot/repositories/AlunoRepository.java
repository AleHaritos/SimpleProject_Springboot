package ale.haritos.projeto1_Springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ale.haritos.projeto1_Springboot.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}
