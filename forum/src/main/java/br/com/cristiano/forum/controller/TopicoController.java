package br.com.cristiano.forum.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.cristiano.forum.dto.TopicoDto;
import br.com.cristiano.forum.dto.TopicoInput;
import br.com.cristiano.forum.modelo.Topico;
import br.com.cristiano.forum.repository.CursoRepository;
import br.com.cristiano.forum.repository.TopicoRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/topicos")
@RequiredArgsConstructor
public class TopicoController {

	private final TopicoRepository topicoRepository;
	private final CursoRepository cursoRepository;

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
	
	@PostMapping
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody TopicoInput topicoInput, UriComponentsBuilder uriBuilder) {
		Topico topico = topicoInput.toEntity(cursoRepository);
		topicoRepository.save(topico);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDto(topico));
		
	}

}
