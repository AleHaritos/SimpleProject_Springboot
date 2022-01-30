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

import ale.haritos.projeto1_Springboot.entities.Curso;
import ale.haritos.projeto1_Springboot.services.CursoService;

@RestController
@RequestMapping(value = "/cursos")
public class CursoResource {
	
	@Autowired
	private CursoService service;
	
	@GetMapping
	public ResponseEntity<List<Curso>> findAll() {
		List<Curso> cursos = service.findAll();
		return ResponseEntity.ok(cursos);
	}
	
	@GetMapping(value ="/{id}")
	public ResponseEntity<Curso> findById(@PathVariable Long id) {
		Curso c = service.findById(id);
		return ResponseEntity.ok(c);
	}
	
	@PostMapping
	public ResponseEntity<Curso> insertCurso(@RequestBody Curso c) {
		c = service.insert(c);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(c.getId()).toUri();
		return ResponseEntity.created(uri).body(c);
	}
	
}
