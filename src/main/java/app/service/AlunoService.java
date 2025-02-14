package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entily.Aluno;
import app.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	public String save(Aluno aluno) {
		this.alunoRepository.save(aluno);
		
		return "aluno " + aluno.getNome() + " foi salvo com sucesso";
	}
}
