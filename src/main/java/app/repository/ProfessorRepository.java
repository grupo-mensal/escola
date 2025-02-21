package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Professor;



public interface ProfessorRepository extends JpaRepository<Professor, Long> {
	public List<Professor> findByNomeStartingWithOrEspecialidadeStartingWith(String nome, String especialidade);
	public List<Professor> findByEmailNotLike(String email);
	 Professor findByEmail(String email);

}