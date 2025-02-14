package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entily.Turma;
import app.repository.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository turmaRepository;

	public String save(Turma turma) {
		this.turmaRepository.save(turma);
		
		return "aluno " + turma.getNome() + " foi salvo com sucesso";
	}
}
