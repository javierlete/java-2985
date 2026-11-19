package com.ipartek.formacion.bibliotecas.validacion;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class ValidacionHelper {
	private static final ValidatorFactory VF = Validation.buildDefaultValidatorFactory();

	public static <T> Map<String, String> validar(T objeto) {
		Validator v = VF.getValidator();

		Set<ConstraintViolation<T>> errores = v.validate(objeto);

		Map<String, String> resultado = new HashMap<>();

		for (ConstraintViolation<T> error : errores) {
			resultado.put(error.getPropertyPath().toString(), error.getMessage());
		}
		
		return resultado;
	}
}
