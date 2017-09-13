package eu.albertomorales.tddIntro.calculadora.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import eu.albertomorales.tddIntro.calculadora.ModuloCalculo;

@RunWith(DataProviderRunner.class)
public class ModuloCalculoImplTest {

	 @Before
	 public void setUp() {
	   // code that will be invoked when this test is instantiated
	 }
	 
	 @Test
	 public void sumar() {
		 ModuloCalculo sut = new ModuloCalculoImpl();
		 Integer resultado = sut.sumar(2,3);
		 assert resultado == 5;
	 }
	 
	 @DataProvider
	 public static Object[][] sumarMuchos_DP() {
		 return new Object[][] {
	         {4, 4, 8},
	         {6, 33, 40},
	         {7, -14, -7}
	     };
	 }
	 
	 @Test
	 @UseDataProvider("sumarMuchos_DP")
	 public void sumarMuchos(int primerSumando, int segundoSumando, int resultadoEsperado) {
		 ModuloCalculo sut = new ModuloCalculoImpl();
		 Integer resultado = sut.sumar(primerSumando,segundoSumando);
		 assert resultado.equals(resultadoEsperado);
	   
	 }

	 @Test(expected = IllegalArgumentException.class)
	 public void primerParametroNulo() {
		 ModuloCalculo sut = new ModuloCalculoImpl();
		 sut.sumar(null,4);
	 }

	 @Test(expected = IllegalArgumentException.class)
	 public void segundoParametroNulo() {
		 ModuloCalculo sut = new ModuloCalculoImpl();
		 sut.sumar(6, null);
	 }


	 
}
