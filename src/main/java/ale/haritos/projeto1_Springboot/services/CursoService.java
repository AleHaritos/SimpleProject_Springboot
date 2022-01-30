package ale.haritos.projeto1_Springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ale.haritos.projeto1_Springboot.entities.Curso;
import ale.haritos.projeto1_Springboot.repositories.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository repository;

	public List<Curso> findAll() {
		return repository.findAll();
	}

	public Curso findById(Long id) {
		return repository.findById(id).get();
	}

	public Curso insert(Curso c) {
		return repository.save(c);
	}
}
