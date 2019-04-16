package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import modelo.Rey;

class ReyTest {

	private Rey p;
	
	ReyTest(){
		p = new Rey ('B');
	}
	
	
	/**
	 * Esta clase solo se encarga de evaluar la lógica del movimiento, el hecho de si hay
	 * una ficha en el camino, o si la ficha del final es correcta lo evalua la clase tablero
	 */
	
	
	//Desde d5 a c6
	@Test
	void testJugada1() {
		assertTrue(p.validarlogica(3, 3, 2, 2));
	}
	
	//Desde d5 a d6
	@Test
	void testJugada2() {
		assertTrue(p.validarlogica(3, 3, 2, 3));
	}
	
	//Desde d5 a e6
		@Test
		void testJugada3() {
			assertTrue(p.validarlogica(3, 3, 2, 4));
		}
		
	//Desde d5 a c7
	@Test
	void testJugada4() {
		assertFalse(p.validarlogica(3, 3, 1, 2));
	}
	
	//Desde d5 a c5
	@Test
	void testJugada5() {
		assertTrue(p.validarlogica(3, 3, 3, 2));
	}
	
	//Desde d5 a e5
		@Test
		void testJugada6() {
			assertTrue(p.validarlogica(3, 3, 3, 4));
		}
		
		//Desde d5 a f4
		@Test
		void testJugada7() {
			assertFalse(p.validarlogica(3, 3, 4, 5));
		}
	
		//Desde d5 a e4
		@Test
		void testJugada8() {
			assertTrue(p.validarlogica(3, 3, 4, 4));
		}
		
		//Desde d5 a d4
		@Test
		void testJugada9() {
			assertTrue(p.validarlogica(3, 3, 4, 3));
		}
		
		//Desde d5 a c4
		@Test
		void testJugada10() {
			assertTrue(p.validarlogica(3, 3, 4, 2));
		}

	
}
