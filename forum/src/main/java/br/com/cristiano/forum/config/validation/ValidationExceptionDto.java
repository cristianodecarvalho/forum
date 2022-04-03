package br.com.cristiano.forum.config.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ValidationExceptionDto {

	private String field;
	private String error;
	
}
