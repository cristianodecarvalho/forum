package br.com.cristiano.forum.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cristiano.forum.dto.TopicoDto;
import br.com.cristiano.forum.modelo.Topico;
import br.com.cristiano.forum.repository.TopicoRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/topicos")
@RequiredArgsConstructor
public class TopicoController {

	private final TopicoRepository topicoRepository;

	@GetMapping
	public List<TopicoDto> listar(String nomeCurso) {
		if (nomeCurso == null) {
			List<Topico> topicos = topicoRepository.findAll();
			return TopicoDto.toListDto(topicos);
		}else {
			List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
			return TopicoDto.toListDto(topicos);
		}
	}

}
