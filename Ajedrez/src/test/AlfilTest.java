package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import modelo.Alfil;

class AlfilTest {
	
	private Alfil p;
	
	AlfilTest(){
		p = new Alfil ('B');
	}
	
	/**
	 * Esta clase solo se encarga de evaluar la lógica del movimiento, el hecho de si hay
	 * una ficha en el camino, o si la ficha del final es correcta lo evalua la clase tablero
	 */

	
	//diagonal hacia arriba a la derecha
	@Test
	void testJugada1() {
		assertTrue(p.validarlogica(6, 0, 3, 3));
	}
	
	//diagonal hacia arriba a la izquierda
	@Test
	void testJugada2() {
			assertTrue(p.validarlogica(6, 3, 4, 1));
	}
	
	//diagonal hacia abajo a la derecha
	@Test
	void testJugada3() {
				assertTrue(p.validarlogica(2, 3, 5, 6));
	}
	
	//diagonal hacia abajo a la izquierda
	@Test
	void testJugada4() {
		assertTrue(p.validarlogica(2, 3, 4, 1));
	}
	
	//no hay diagonal (misma fila)
		@Test
		void testJugada5() {
			assertFalse(p.validarlogica(2, 3, 2, 6));
		}
		
	//no hay diagonal (misma columna)
		@Test
		void testJugada6() {
			assertFalse(p.validarlogica(2, 3, 5, 3));
	}

}
