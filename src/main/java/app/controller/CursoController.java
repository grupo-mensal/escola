package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entily.Curso;
import app.service.CursoService;

@RestController
@RequestMapping("/api/curso")
public class CursoController {

	@Autowired
	private CursoService cursoService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Curso curso) {
		try {
			String mensagem = this.cursoService.save(curso);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}
