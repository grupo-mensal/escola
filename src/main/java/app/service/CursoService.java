package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Aluno;
import app.entity.Curso;
import app.repository.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository cursoRepository;
	
	public String save(Curso curso) {
		
		this.cursoRepository.save(curso);
		
		return "o curso " + curso.getNome() + " foi salvo com sucesso";
	}
	
	public Curso findById(long id) {
		
		Curso curso = this.cursoRepository.findById(id).get();
		
		return curso;
	}
	
	public String update(Curso curso, long id) {
		

		return  curso.getNome() + " foi atualizado com sucesso!";
	}
	
	public List<Curso> findAll(){
		
		List<Curso> lista = this.cursoRepository.findAll();


		return lista;
	}
	
	public String delete(long id) {
		return "O curso foi deletado";
	}

}
