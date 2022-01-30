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

import ale.haritos.projeto1_Springboot.entities.Professor;
import ale.haritos.projeto1_Springboot.services.ProfessorService;

@RestController
@RequestMapping(value = "/professores")
public class ProfessorResources {

	@Autowired
	private ProfessorService service;

	@GetMapping
	public ResponseEntity<List<Professor>> findAll() {
		List<Professor> professores = service.findAll();
		return ResponseEntity.ok(professores);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Professor> findById(@PathVariable Long id) {
		Professor a = service.findById(id);
		return ResponseEntity.ok(a);
	}

	@PostMapping(value ="/{id_curso}")
	public ResponseEntity<Professor> insertProfessor(@RequestBody Professor p, @PathVariable Long id_curso) {
		p = service.insert(p, id_curso);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getId()).toUri();
		return ResponseEntity.created(uri).body(p);
	}


}
