package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Curso;
import app.entity.Professor;
import app.repository.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;
	
	public String save(Professor professor) {
		
		this.professorRepository.save(professor);
		
		return "o Professor " + professor.getNome() + " foi salvo com sucesso";
	}
	
public Professor findById(long id) {
		
		Professor professor = this.professorRepository.findById(id).get();
		
		return professor;
	}
	
	public String update(Curso curso, long id) {
		

		return  curso.getNome() + " foi atualizado com sucesso!";
	}
	
	public List<Professor> findAll(){
		
		List<Professor> lista = this.professorRepository.findAll();


		return lista;
	}
	
	public String delete(long id) {
		return "O Professor foi deletado";
	}
}
