package br.com.cristiano.forum.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.cristiano.forum.modelo.Curso;
import br.com.cristiano.forum.modelo.Topico;
import br.com.cristiano.forum.repository.CursoRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicoInput {
	
	@NotNull 
	@NotEmpty 
	@Length(min = 5)
	private String titulo;
	
	@NotNull 
	@NotEmpty 
	@Length(min = 10)
	private String mensagem;
	
	@NotNull 
	@NotEmpty 
	private String nomeCurso;
	
	public Topico toEntity(CursoRepository cursoRepository) {
		Curso curso = cursoRepository.findByNome(nomeCurso);
		return new Topico(titulo, mensagem, curso);
	}
	
}
