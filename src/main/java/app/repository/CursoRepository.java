package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entily.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
	
}


