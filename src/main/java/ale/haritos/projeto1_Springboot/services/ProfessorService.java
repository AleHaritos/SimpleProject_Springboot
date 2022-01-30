package ale.haritos.projeto1_Springboot.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import ale.haritos.projeto1_Springboot.entities.Curso;
import ale.haritos.projeto1_Springboot.entities.Professor;
import ale.haritos.projeto1_Springboot.repositories.CursoRepository;
import ale.haritos.projeto1_Springboot.repositories.ProfessorRepository;
import ale.haritos.projeto1_Springboot.services.exceptions.DatabaseException;
import ale.haritos.projeto1_Springboot.services.exceptions.NotFoundException;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository repository;

	@Autowired
	CursoRepository cursoRepository;

	public List<Professor> findAll() {
		return repository.findAll();
	}

	public Professor findById(Long id) {
		Optional<Professor> p = repository.findById(id);
		return p.orElseThrow(() -> new NotFoundException(id));
	}

	public Professor insert(Professor p, Long id_curso) {
		p = validacaoProfessor(p);
		Curso c = cursoRepository.findById(id_curso).get();
		p.setCurso(c);

		return repository.save(p);
	}

	public Professor realocarProfessor(Long id, Long id_c) {
		try {
			Professor p = repository.findById(id).get();
			Curso c = cursoRepository.findById(id_c).get();
			p.setCurso(c);
			return repository.save(p);
		} catch (EntityNotFoundException e) {
			throw new NotFoundException(id);
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	private Professor validacaoProfessor(Professor p) {
		if (p.getNome() == null || p.getEmail() == null || p.getSalarioBruto() == null) {
			throw new DatabaseException("Dados não completos");
		}

		return p;
	}
}
