package eu.albertomorales.tddIntro.calculadora.impl;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import eu.albertomorales.tddIntro.calculadora.ModuloCalculo;

public class ModuloCalculoImplTest {

	 @BeforeClass
	 public void setUp() {
	   // code that will be invoked when this test is instantiated
	 }
	 
	 @Test(groups = { "fast" })
	 public void aFastTest() {
	   
	 }

	 @Test(groups = { "fast" })
	 public void sumar() {
		 ModuloCalculo sut = new ModuloCalculoImpl();
		 Integer resultado = sut.sumar(2,3);
		 assert resultado == 5;
	 }
	 
	 @DataProvider 
	 private static final Object[][] sumarMuchos_DP(){
	     return new Object[][] {
	         {new Integer(4), new Integer(4), new Integer(8)},
	         {new Integer(6), new Integer(33), new Integer(39)},
	         {new Integer(7), new Integer(-14), new Integer(-7)}};
	 }
	 
	 @Test(groups = { "fast" }, dataProvider = "sumarMuchos_DP")
	 public void sumarMuchos(Integer primerSumando, Integer segundoSumando, Integer resultadoEsperado) {
		 ModuloCalculo sut = new ModuloCalculoImpl();
		 Integer resultado = sut.sumar(primerSumando,segundoSumando);
		 assert resultado.equals(resultadoEsperado);
	   
	 }
	 
	 @DataProvider 
	 private static final Object[][] parametrosNulos_DP(){
	     return new Object[][] {
	         {null, new Integer(4)},
	         {new Integer(6), null}};
	 }
	 
	 @Test(groups = { "fast" }, dataProvider = "parametrosNulos_DP", expectedExceptions = IllegalArgumentException.class)
	 public void parametrosNulos(Integer primerSumando, Integer segundoSumando) {
		 ModuloCalculo sut = new ModuloCalculoImpl();
		 sut.sumar(primerSumando,segundoSumando);
	 }

	 @Test(groups = { "slow" })
	 public void aSlowTest() {
	    
	 }

	 
}
