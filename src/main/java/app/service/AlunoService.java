package app.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Aluno;
import app.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	public String save(Aluno aluno) {
		
		this.alunoRepository.save(aluno);
		
		return "o Aluno " + aluno.getNome() + " foi salvo com sucesso";
	}
	
	public Aluno findById(long id) {
		
		Aluno aluno = this.alunoRepository.findById(id).get();
		
		return aluno;
	}
	
	public String update(Aluno aluno, long id) {
		aluno.setId(id);
		this.alunoRepository.save(aluno);
		return  aluno.getNome() + " foi atualizado com sucesso!";
	}
	
	public List<Aluno> findAll(){
		
		List<Aluno> lista = this.alunoRepository.findAll();


		return lista;
	}
	
	public String delete(long id) {
		this.alunoRepository.deleteById(id);
		return "O aluno foi deletado";
	}

}