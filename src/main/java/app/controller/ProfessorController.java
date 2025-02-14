package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entily.Professor;
import app.service.ProfessorService;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Professor professor) {
		try {
			String mensagem = this.professorService.save(professor);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}
