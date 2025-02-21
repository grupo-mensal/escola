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
		
		Aluno alu = this.alunoRepository.findByCPF(aluno.getCPF());
		if(alu != null) {
			throw new RuntimeException("Ja esxiste um aluno cadastrado com o "+alu.getCPF());
		}
		
		
		if(aluno.getTelefone() == null) {
			aluno.setCadastroCompleto(false);
		}else {
			aluno.setCadastroCompleto(true);
		}
		
		
		
		
		
		
		
		
		this.alunoRepository.save(aluno);
		
		return "o Aluno " + aluno.getNome() + aluno.getCPF() + " foi salvo com sucesso";
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
	public List<Aluno> buscarPorNome(String nome) {
        return alunoRepository.findByNomeStartingWith(nome);
    }

    // Buscar alunos por QUALQUER PARTE do número de telefone
    public List<Aluno> buscarPorTelefone(String telefone) {
        return alunoRepository.findByTelefoneContaining(telefone);
    }

    // Buscar alunos pelo nome da turma
    public List<Aluno> buscarPorNomeTurma(String nomeTurma) {
        return alunoRepository.findByTurma_Nome(nomeTurma);
    }
}