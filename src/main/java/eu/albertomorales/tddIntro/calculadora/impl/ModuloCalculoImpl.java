package eu.albertomorales.tddIntro.calculadora.impl;

import eu.albertomorales.tddIntro.calculadora.ModuloCalculo;

public class ModuloCalculoImpl implements ModuloCalculo {

	@Override
	public int sumar(Integer a, Integer b) {
		if (a == null) {
			throw new IllegalArgumentException("Argumento sumando requerido");
		}
		if (b == null) {
			throw new IllegalArgumentException("Argumento sumando requerido");
		}
		return a + b;
	}

}
