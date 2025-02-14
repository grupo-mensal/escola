package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entily.Curso;
import app.repository.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository cursoRepository;
	
	public String save(Curso curso) {
		this.cursoRepository.save(curso);
		
		return "aluno " + curso.getNome() + " foi salvo com sucesso";
	}
}
