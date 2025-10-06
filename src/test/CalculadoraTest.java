package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pkg.Calculadora;

class CalculadoraTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	@Test
	void testSuma() {
		assertEquals(5, Calculadora.sumar(2,3));
	}
	@Test
	void testRestar() {
	    assertEquals(1,Calculadora.restar(6,3));
	}
	@Test
	void testDivide() {
		 assertEquals(1,Calculadora.divide(6,3));
	}
	@Test
	void testMultiplicar() {
	    assertEquals(6,Calculadora.multiplicar(2,3));
	}
	

}
