package interfaz;

import javax.swing.*;
import java.awt.*;
import modelo.Tablero;

public class Ventana extends JFrame{

	private PanelTablero paneltablero;
	private PanelFilas panelfilas;
	private PanelColumnas panelcolumnas;
	private PanelControl panelcontrol;
	
	private Tablero tablero;
	
	public Ventana() {
		setTitle("Ajedrez");
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(	new	BorderLayout());
		this.getContentPane().setBackground(Color.WHITE);
		
		tablero= new Tablero();
		
		paneltablero = new PanelTablero(this);
		panelfilas = new PanelFilas(this);
		panelcolumnas = new PanelColumnas(this);
		panelcontrol = new PanelControl(this);
		
		add(paneltablero, BorderLayout.CENTER);
		add(panelfilas, BorderLayout.WEST);
		add(panelcolumnas, BorderLayout.SOUTH);
		add(panelcontrol, BorderLayout.EAST);

	}
	
	public Tablero dartablero() {
		return tablero;
	}
	
	public void moverpieza (String cod) {
		paneltablero.moverpieza(cod);
	}
	
	public static void main(String[] args) {
		Ventana ven = new Ventana();
		ven.setVisible(true);
	}
	
	public void girar180() {
		panelfilas.reordenarfilas();
		panelcolumnas.reordenarcolumnas();
		paneltablero.girar180();
		
		
	}
	
	public void girar90() {
		paneltablero.girar90();
	}
	
	public void escribirmovimiento(String comando) {
		
		String fila= panelfilas.escribirmovimiento( Integer.parseInt(comando.substring(0, 1)));
		String columna=panelcolumnas.escribirmovimiento( Integer.parseInt(comando.substring(1)));
		
		panelcontrol.escribirmovimiento(columna+fila);
		
		
	}
	
	public void reiniciardisponibles() {
		paneltablero.reiniciardisponibles();
	}
	
	public void borrarmovimiento() {
		panelcontrol.borrarcodigo();
	}
	
	public String darjugador(){
		return panelcontrol.darjugador();
	}
	

}
