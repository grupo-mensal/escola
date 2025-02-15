package app.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Turma;
import app.repository.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository turmaRepository;
	
	public String save(Turma turma) {
		
		this.turmaRepository.save(turma);
		
		return "o Aluno " + turma.getNome() + " foi salvo com sucesso";
	}
	
	public Turma findById(long id) {
		
		Turma turma = this.turmaRepository.findById(id).get();
		
		return turma;
	}
	
	public String update(Turma turma, long id) {
		turma.setId(id);
		this.turmaRepository.save(turma);

		return  turma.getNome() + " foi atualizado com sucesso!";
	}
	
	public List<Turma> findAll(){
		
		List<Turma> lista = this.turmaRepository.findAll();


		return lista;
	}
	
	public String delete(long id) {
		this.turmaRepository.deleteById(id);
		return "A turma foi deletado";
	}

}
