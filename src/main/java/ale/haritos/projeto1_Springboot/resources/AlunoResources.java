package ale.haritos.projeto1_Springboot.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ale.haritos.projeto1_Springboot.entities.Aluno;
import ale.haritos.projeto1_Springboot.services.AlunoService;

@RestController
@RequestMapping(value ="/alunos")
public class AlunoResources {

	@Autowired
	private AlunoService service;
	
	@GetMapping
	public ResponseEntity<List<Aluno>> findAll() {
		List<Aluno> alunos = service.findAll();
		return ResponseEntity.ok(alunos);
	}
	
	@GetMapping(value ="/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable Long id) {
		Aluno a = service.findById(id);
		return ResponseEntity.ok(a);
	}
	
	@PostMapping
	public ResponseEntity<Aluno> insertAluno(@RequestBody Aluno a) {
		a = service.insert(a);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(a.getId()).toUri();
		return ResponseEntity.created(uri).body(a);
	}
	
}
