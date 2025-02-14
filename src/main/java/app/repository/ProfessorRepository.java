package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entily.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
	
}


