package ale.haritos.projeto1_Springboot.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.hibernate.PropertyValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import ale.haritos.projeto1_Springboot.entities.Aluno;
import ale.haritos.projeto1_Springboot.entities.Curso;
import ale.haritos.projeto1_Springboot.entities.Matricula;
import ale.haritos.projeto1_Springboot.enuns.Status;
import ale.haritos.projeto1_Springboot.repositories.AlunoRepository;
import ale.haritos.projeto1_Springboot.repositories.CursoRepository;
import ale.haritos.projeto1_Springboot.repositories.MatriculaRepository;
import ale.haritos.projeto1_Springboot.services.exceptions.DatabaseException;
import ale.haritos.projeto1_Springboot.services.exceptions.NotFoundException;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;

	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private MatriculaRepository matriculaRepository;

	public List<Aluno> findAll() {
		return repository.findAll();
	}

	public Aluno findById(Long id) {
		Optional<Aluno> a = repository.findById(id);
		return a.orElseThrow(() -> new NotFoundException(id));
	}

	public Aluno insert(Aluno a) {
		return repository.save(validacaoAluno(a));
	}

	public Aluno matricularAluno(Long id, Long id_c) {
		try {
			Aluno a = validacaoAluno(repository.findById(id).get());
			Curso c = cursoRepository.findById(id_c).get();
			matriculaRepository.save(new Matricula(a, c, Status.CURSANDO));
			return repository.save(a);
		} catch (EntityNotFoundException e) {
			throw new NotFoundException(id);
		} catch(PropertyValueException e) {
			throw new DatabaseException("Dados não completos");
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new NotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	
	private Aluno validacaoAluno(Aluno a) {
		
		if (a.getNome() == null || a.getEmail() == null || a.getRa() == null) {
				throw new DatabaseException("Dados não completos");
		}
		
		return a;
		
	}

}
