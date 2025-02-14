package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entily.Aluno;
import app.service.AlunoService;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Aluno aluno) {
		try {
			String mensagem = this.alunoService.save(aluno);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
