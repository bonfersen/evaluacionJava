package com.evaluacion.bustamante.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtil {

	/***
	 * Valida: Si un String es nulo o cadena vacia. Si es Integer valida si es nulo o Cero. Si es un arreglo de objetos
	 * valida si es nulo o si el contenido de cada objeto del arreglo es nulo. Si un Bigdecimal es nulo o si es Cero o un
	 * valor menor
	 * 
	 * @param strVal
	 * @return True si el valor es nulo o vacio
	 */
	public static Boolean isEmpty(Object strVal) {
		if (strVal == null)
			return true;

		if (strVal instanceof String) {
			String temp = (String) strVal;
			return (temp.trim().equals("")) ? true : false;
		}
		else if (strVal instanceof Integer) {
			return ((Integer) strVal == 0) ? true : false;
		}
		else if (strVal instanceof Short) {
			return ((Short) strVal == 0) ? true : false;
		}
		else if (strVal instanceof Object[]) {
			byte bit = 0;
			for (Object temp : (Object[]) strVal) {
				if (temp != null) {
					bit = 1;
					break;
				}
			}
			return (bit == 1) ? false : true;
		}

		return false;
	}

	/***
	 * Indica si un objeto no esta vacio.
	 * 
	 * @see ValidateUtil#isEmpty(Object)
	 * @param strVal
	 *            Objeto a evaluar
	 * @return True si el objeto esta vacio
	 */
	public static Boolean isNotEmpty(Object strVal) {
		return !isEmpty(strVal);
	}

	/***
	 * Método para validar el correo electrónico.
	 * 
	 * @param expresion
	 *            contiene el correo ingresado en el campo.
	 * @return TRUE si la expresion tiene el formato establecido en el patrón.
	 * @throws Exception
	 *             FALSE si el correo no cumple con el patrón.
	 */
	public static Boolean isValidFormatEmail(String expresion) throws Exception {

		Boolean resultado = false;

		Pattern pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher mat = pat.matcher(expresion);

		if (mat.find()) {

			resultado = true;
		}

		return resultado;

	}
}
