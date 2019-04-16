package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import modelo.Caballo;
import modelo.Pieza;
import modelo.Tablero;

class TableroTest {

	private Tablero tablero;
	
	TableroTest(){
		tablero = new Tablero();
	}
	
	/**
	 * Se tiene un escenario estandar y aqui se crean fichas en las posiciones
	 * a5, b5, d5, f5, h5 para validar todas las posibles repsuestas del metodo
	 * validacion global 
	 */
	void setupEscenario1(){
	tablero.darceldas()[3][3].setpieza(new Pieza ('B'));
	tablero.darceldas()[3][0].setpieza(new Pieza ('B'));
	tablero.darceldas()[3][1].setpieza(new Pieza ('N'));
	tablero.darceldas()[3][5].setpieza(new Pieza ('B'));
	tablero.darceldas()[3][7].setpieza(new Pieza ('N'));
	}

	
	@Test
	void testReodenarFilas() {
		tablero.reordenarfilas();
		assertTrue(tablero.darfilas()[0].equals("1"));
	}
	
	@Test
	void testReodenarColumnas() {
		tablero.reordenarcolumnas();
		assertTrue(tablero.darcolumnas()[0].equals("h"));
	}
	
	@Test
	void testReodenarCeldas() {
		tablero.reordenarceldas();
		assertTrue(tablero.darceldas()[0][0].darpieza().darcolor()=='B');
	}
	
	@Test
	void testGirar90() {
		tablero.girar90();
		assertTrue(tablero.darceldas()[6][0].darpieza() instanceof Caballo);
	}
	
	@Test
	void testMoverPieza() {
		tablero.moverpieza("a2a4");
		assertTrue(tablero.darceldas()[4][0].darpieza()!=null);
	}
	
	
	/**
	 * En este metodo se evalua un movimiento de d5 a b5 que debe dar verdadero
	 */
	@Test
	void testValidacionGlobal1() {
		setupEscenario1();
		assertTrue(tablero.validacionglobal(3,3, 3,1));
	}
	
	/**
	 * En este metodo se evalua un movimiento de d5 a a5 que debe dar falso
	 */
	@Test
	void testValidacionGlobal2() {
		setupEscenario1();
		assertFalse(tablero.validacionglobal(3,3, 3,0));
	}
	
	/**
	 * En este metodo se evalua un movimiento de d5 a f5 que debe dar falso
	 * La ficha del final es del mismo color que la que realiza el movimiento
	 */
	@Test
	void testValidacionGlobal3() {
		setupEscenario1();
		assertFalse(tablero.validacionglobal(3,3, 3,5));
	}
	
	/**
	 * En este metodo se evalua un movimiento de d5 a h5 que debe dar falso
	 * Hay interferencia en el movimiento
	 */
	@Test
	void testValidacionGlobal4() {
		setupEscenario1();
		assertFalse(tablero.validacionglobal(3,3, 3,7));
	}
	
	@Test
	void testDarCoordenadas() {
		assertTrue(tablero.darcoordenadas("a", "columnas")==0);
	}
	
	

}
