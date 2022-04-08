package br.com.cristiano.forum.dto;

import javax.validation.Valid;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginForm {
	
	private String email;
	private String senha;
	
	public UsernamePasswordAuthenticationToken converter(@Valid LoginForm form) {
		return new UsernamePasswordAuthenticationToken(email, senha);
	}
	
}
