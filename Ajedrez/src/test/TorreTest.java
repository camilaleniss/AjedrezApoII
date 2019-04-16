package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import modelo.Torre;

class TorreTest {
	
	private Torre p;
	
	/**
	 * Esta clase solo se encarga de evaluar la lógica del movimiento, el hecho de si hay
	 * una ficha en el camino, o si la ficha del final es correcta lo evalua la clase tablero
	 */
	
	TorreTest(){
		p = new Torre ('N');
	}
	

	
	//Misma columna hacia arriba
	@Test
	void testJugada1() {
		assertTrue(p.validarlogica(6,0,1,0));
	}
	
	//Misma fila hacia la derecha
	@Test
	void testJugada2() {
		assertTrue(p.validarlogica(6,0,6,7));
	}
	
	//Misma columna hacia abajo
	@Test
	void testJugada3() {
		assertTrue(p.validarlogica(1,0,6,0));
	}
	
	//Misma fila hacia la izquierda
	@Test
	void testJugada4() {
			assertTrue(p.validarlogica(6,7,6,0));
	}
	
	//Diferente fila y columna
	@Test
	void testJugada5() {
		assertFalse(p.validarlogica(6,7,5,6));
	}
	
	


}
