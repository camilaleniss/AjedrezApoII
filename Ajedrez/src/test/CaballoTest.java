package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import modelo.Caballo;

class CaballoTest {

	private Caballo p;
	
	CaballoTest(){
		p = new Caballo ('N');
	}
	

	/**
	 * Esta clase solo se encarga de evaluar la lógica del movimiento, el hecho de si hay
	 * una ficha en el camino, o si la ficha del final es correcta lo evalua la clase tablero
	 */
	
	
	//Desde c3 a a2
	@Test
	void testJugada1() {
		assertTrue(p.validarlogica(5, 2, 6, 0));
	}
	
	//Desde c3 a a4
	@Test
	void testJugada2() {
		assertTrue(p.validarlogica(5, 2, 4, 0));
	}
	
	//Desde c3 a b1
		@Test
		void testJugada3() {
			assertTrue(p.validarlogica(5, 2, 7, 1));
		}
		
	//Desde c3 a d1
	@Test
	void testJugada4() {
		assertTrue(p.validarlogica(5, 2, 7, 3));
	}
	
	//Desde c3 a e2
	@Test
	void testJugada5() {
		assertTrue(p.validarlogica(5, 2, 6, 4));
	}
	
	//Desde c3 a e4
		@Test
		void testJugada6() {
			assertTrue(p.validarlogica(5, 2, 4, 4));
		}
		
		//Desde c3 a d5
		@Test
		void testJugada7() {
			assertTrue(p.validarlogica(5, 2, 3, 3));
		}
	
		//Desde c3 a b5
		@Test
		void testJugada8() {
			assertTrue(p.validarlogica(5, 2, 3, 1));
		}
		
		//Desde c3 a c6 debe dar falso
		@Test
		void testJugada9() {
			assertFalse(p.validarlogica(5, 2, 2, 2));
		}
		
		//Desde c3 a c8 debe dar falso
		@Test
		void testJugada10() {
					assertFalse(p.validarlogica(5, 2, 0, 2));
		}
	

}
