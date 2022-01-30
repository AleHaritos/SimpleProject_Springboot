package ale.haritos.projeto1_Springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ale.haritos.projeto1_Springboot.entities.Aluno;
import ale.haritos.projeto1_Springboot.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;
	
	public List<Aluno> findAll() {
		return repository.findAll();
	}
	
	public Aluno findById(Long id) {
		return repository.findById(id).get();
	}
	
	public Aluno insert(Aluno a) {
		return repository.save(a);
	}
}
