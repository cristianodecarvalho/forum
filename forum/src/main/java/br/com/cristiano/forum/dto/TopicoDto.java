package br.com.cristiano.forum.dto;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import br.com.cristiano.forum.modelo.Topico;
import lombok.Getter;

@Getter
public class TopicoDto {

	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	
	public TopicoDto(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
	}
	
	public static Page<TopicoDto> toListDto(Page<Topico> topicos){
		return topicos.map(TopicoDto::new);
	}
	
}
