package br.com.cristiano.forum.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.cristiano.forum.modelo.Topico;
import br.com.cristiano.forum.repository.TopicoRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicoInputUpdate {

	@NotNull 
	@NotEmpty 
	@Length(min = 5)
	private String titulo;
	
	@NotNull 
	@NotEmpty 
	@Length(min = 10)
	private String mensagem;

	public Topico atualizar(Long id, TopicoRepository topicoRepository) {
		Topico topico = topicoRepository.getById(id);
		topico.setTitulo(this.titulo);
		topico.setMensagem(this.mensagem);
		return topico;
	}

}
