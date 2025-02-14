package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entily.Professor;
import app.repository.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;
	
	public String save(Professor professor) {
		this.professorRepository.save(professor);
		
		return "aluno " + professor.getNome() + " foi salvo com sucesso";
	}
}
