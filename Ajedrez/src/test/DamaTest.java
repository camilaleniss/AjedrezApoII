package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import modelo.Dama;

class DamaTest {

	private Dama p;
	
	DamaTest(){
		p = new Dama('N');
	}
	

	/**
	 * Esta clase solo se encarga de evaluar la lógica del movimiento, el hecho de si hay
	 * una ficha en el camino, o si la ficha del final es correcta lo evalua la clase tablero
	 */
	
	
	//Desde d5 a a8
	@Test
	void testJugada1() {
		assertTrue(p.validarlogica(3, 3, 0, 0));
	}
	
	//Desde d5 a d8
	@Test
	void testJugada2() {
		assertTrue(p.validarlogica(3, 3, 0, 3));
	}
	
	//Desde d5 a g8
		@Test
		void testJugada3() {
			assertTrue(p.validarlogica(3, 3, 0, 6));
		}
		
	//Desde d5 a c7
	@Test
	void testJugada4() {
		assertFalse(p.validarlogica(3, 3, 1, 2));
	}
	
	//Desde d5 a a5
	@Test
	void testJugada5() {
		assertTrue(p.validarlogica(3, 3, 3, 0));
	}
	
	//Desde d5 a h5
		@Test
		void testJugada6() {
			assertTrue(p.validarlogica(3, 3, 3, 7));
		}
		
		//Desde d5 a f4
		@Test
		void testJugada7() {
			assertFalse(p.validarlogica(3, 3, 4, 5));
		}
	
		//Desde d5 a a2
		@Test
		void testJugada8() {
			assertTrue(p.validarlogica(3, 3, 6, 0));
		}
		
		//Desde d5 a f2
		@Test
		void testJugada9() {
			assertTrue(p.validarlogica(3, 3, 6, 6));
		}
		
		//Desde d5 a d1
		@Test
		void testJugada10() {

			assertTrue(p.validarlogica(3, 3, 7, 3));
		}

}
