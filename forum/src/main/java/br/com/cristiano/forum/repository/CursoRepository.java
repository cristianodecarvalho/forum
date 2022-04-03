package br.com.cristiano.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cristiano.forum.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{

	Curso findByNome(String nomeCurso);
	
}
