package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public String update(Professor professor, long id) {
		professor.setId(id);
		this.professorRepository.save(professor);

		return  professor.getNome() + " foi atualizado com sucesso!";
	}
	
	public List<Professor> findAll(){
		
		List<Professor> lista = this.professorRepository.findAll();


		return lista;
	}
	
	public String delete(long id) {
		this.professorRepository.deleteById(id);
		return "O Professor foi deletado";
	}
	public List<Professor> buscarPorNomeOuEspecialidade(String nome, String especialidade) {
        return professorRepository.findByNomeStartingWithOrEspecialidadeStartingWith(nome, especialidade);
    }

    // Buscar professores que NÃO possuem "@gmail.com" no e-mail
    public List<Professor> buscarNaoGmail() {
        return professorRepository.findByEmailNotLike("%@gmail.com");
    }

    // Buscar professor por e-mail exato
    public Professor buscarPorEmail(String email) {
        return professorRepository.findByEmail(email);
    }


}
