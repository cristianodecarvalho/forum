package br.com.cristiano.forum.dto;

import br.com.cristiano.forum.modelo.Curso;
import br.com.cristiano.forum.modelo.Topico;
import br.com.cristiano.forum.repository.CursoRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicoInput {
	
	private String titulo;
	private String mensagem;
	private String nomeCurso;
	
	public Topico toEntity(CursoRepository cursoRepository) {
		Curso curso = cursoRepository.findByNome(nomeCurso);
		return new Topico(titulo, mensagem, curso);
	}
	
}
