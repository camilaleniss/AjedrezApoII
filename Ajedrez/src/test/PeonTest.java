package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Peon;

class PeonTest {

	private Peon p;

	PeonTest(){
		p = new Peon('B');
	}
	
	/**
	 * Esta clase solo se encarga de evaluar la lógica del movimiento, el hecho de si hay
	 * una ficha en el camino, o si la ficha del final es correcta lo evalua la clase tablero
	 */
	
	

	
	//De la casilla a2 a la a4
		@Test
		void testvalidarlogica1() {
			assertTrue (p.validarlogica(6, 0, 4, 0));
		}
		
	//De la casillas a2 a a3	
		@Test
		void testvalidarlogica2() {
			assertTrue (p.validarlogica(6, 0, 5, 0));
		}
		
		//De la casillas a2 a a5	
		@Test
		void testvalidarlogica3() {
			assertFalse (p.validarlogica(6, 0, 3, 0));
		}
		
		//De la casillas a2 a b3	
		@Test
		void testvalidarlogica4() {
			assertTrue (p.validarlogica(6, 0, 5, 1));
		}
		
		//De la casillas a2 a c3	
		@Test
		void testvalidarlogica5() {
			assertFalse (p.validarlogica(6, 0, 5, 2));
		}
		
		//De la casillas a3 a b2	
		@Test
		void testvalidarlogica6() {
			assertTrue (p.validarlogica(6, 1, 5, 0));
		}
	
}
