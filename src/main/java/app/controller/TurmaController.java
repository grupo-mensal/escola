package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entily.Turma;
import app.service.TurmaService;

@RestController
@RequestMapping("/api/turma")
public class TurmaController {

	@Autowired
	private TurmaService turmaService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Turma turma) {
		try {
			String mensagem = this.turmaService.save(turma);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}
