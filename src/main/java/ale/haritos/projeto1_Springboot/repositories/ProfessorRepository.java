package ale.haritos.projeto1_Springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ale.haritos.projeto1_Springboot.entities.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{

}
