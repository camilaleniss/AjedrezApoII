package interfaz;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import modelo.Peon;
import modelo.PiezaException;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelTablero extends JPanel implements ActionListener{
	
	public static int NCASILLAS = 8;
	
	private JButton casillas [][];
	private Ventana ventana;
	private int njugada;
	
	
	public PanelTablero(Ventana ventana) {
		setLayout(	new	GridLayout(8,8)	);					
		setPreferredSize(	new	Dimension(320,320)	);
		setBackground(Color.WHITE);
		njugada=1;
		
		casillas = new JButton[NCASILLAS][NCASILLAS];
		
		this.ventana = ventana;
		creartablero();
		
		for (int f=0; f<casillas.length; f++) {
			for (int c=0; c<casillas[0].length; c++) {
				add(casillas[f][c]);
			}
		}	
	}
	
	public void creartablero() {
		
		JButton celdita;
		String direc;
		
		for (int f=0; f<ventana.dartablero().darceldas().length; f++) {	
			
			for (int c=0; c<ventana.dartablero().darceldas()[0].length; c++) {
				
				if (ventana.dartablero().darceldas()[f][c].darpieza()!=null) {					
					celdita = new JButton();
					if (ventana.dartablero().darceldas()[f][c].darpieza().darcolor() == 'N') {	
						
						direc="img/n"+ventana.dartablero().darceldas()[f][c].darpieza().darid()+".png";
						celdita.setIcon(new ImageIcon(direc));			
						
					}else {	
						
						direc="img/b"+ventana.dartablero().darceldas()[f][c].darpieza().darid()+".png";
						celdita.setIcon(new ImageIcon(direc));		
						
					}
					
				}else {
					celdita = new JButton();
					celdita.setIcon(null);
				}
				
				celdita.setName(ventana.dartablero().darceldas()[f][c].darcod());
				celdita.setOpaque(true);
				celdita.setFocusable(false);
				String comando = ""+f+""+c;
				celdita.setActionCommand(comando);
				celdita.setBorder(null);
				celdita.addActionListener(this);
				casillas[f][c]= celdita;
				
			}
		}
		pintarcasillas(njugada);
	}
	
	public void actualizar () {
		String img;
		for (int f=0; f<casillas.length; f++) {
			
			for (int c=0; c<casillas[0].length; c++) {
				if (ventana.dartablero().darceldas()[f][c].darpieza()!=null) {
					
					if (ventana.dartablero().darceldas()[f][c].darpieza().darcolor() == 'N') {
						img = ("img/n"+ventana.dartablero().darceldas()[f][c].darpieza().darid()+".png");
						casillas[f][c].setIcon(new ImageIcon(img));
						
										
					} else {
						img = ("img/b"+ventana.dartablero().darceldas()[f][c].darpieza().darid()+".png");
						casillas[f][c].setIcon(new ImageIcon(img));

					}
					
				}else {
					casillas[f][c].setText("");
					casillas[f][c].setIcon(null);
				}
				
				String comando = ""+f+""+c;
				if (ventana.dartablero().darceldas()[f][c].dardisponible()) {
					comando+="M";
				}

				casillas[f][c].setActionCommand(comando);
			}
			
		}
		
		
	}
	
	public void actualizarpintura(){
		njugada++;
		pintarcasillas(njugada);
	}

	public void girar180() {
		ventana.dartablero().reordenarceldas();
		actualizar();
		actualizarpintura();
	}
	
	public void girar90() {
		ventana.dartablero().girar90();
		actualizar();
		actualizarpintura();
	}
	
	public void moverpieza(String cod) throws NullPointerException{
		
		String [] codigosmatriz = desarmarcod(cod);
		if (validarmovimiento(codigosmatriz)) {
			ventana.dartablero().moverpieza(cod);
			actualizar();
			actualizarpintura();
		}else {
			JOptionPane.showMessageDialog(null, "No es un movimiento valido");
		}
		
		
	}
	
	public String[] desarmarcod(String cod) {
		String [] codigo = new String[4];
		
		codigo[0] = cod.substring(0,1);
		codigo[1] = cod.substring(1,2);
		codigo[2] = cod.substring(2,3);
		codigo[3] = cod.substring(3,4);
		
		return codigo;
		
	}
	
	
	public boolean validarmovimiento(String [] codigos) throws NullPointerException, PiezaException{
		
		int c1= ventana.dartablero().darcoordenadas(codigos[0], "columna");
		int f1=  ventana.dartablero().darcoordenadas(codigos[1], "fila");
		int c2=  ventana.dartablero().darcoordenadas(codigos[2], "columna");
		int f2=  ventana.dartablero().darcoordenadas(codigos[3], "fila");
		
		char criterio='N';
		
		if (ventana.darjugador().equals("Jugador 1")){
			criterio='B';
		}
		
		if (ventana.dartablero().darceldas()[f1][c1].darpieza().darcolor()!=criterio){
			throw new PiezaException ("No es el turno de ese jugador");
		}
		
		boolean prueba = ventana.dartablero().validacionglobal(f1, c1, f2, c2);
		
		if (prueba) {
			ventana.dartablero().darceldas()[f2][c2].setdisponible(true);
		}
		
		if (prueba && ventana.dartablero().darceldas()[f1][c1].darpieza() instanceof Peon) {
			((Peon) ventana.dartablero().darceldas()[f1][c1].darpieza()).setya(true);
		}
		
		
		
		return (prueba);
				
	}
	
	public void pintarcasillas(int indi) {

		for (int f=0; f<casillas.length; f++) {
			for (int c=0; c<casillas[0].length; c++) {
				if (indi%2 == 0) {
					casillas[f][c].setBackground(new Color(105 ,74,56));
				}else {
					casillas[f][c].setBackground(new Color(244, 241, 222));
				}
				indi++;
			}
			indi--;
		}
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		
		
		if (evento.getActionCommand().length()==2) {
			
			try {
			ventana.borrarmovimiento();
			pintarcasillas(njugada);
			ventana.escribirmovimiento(evento.getActionCommand());
			pintardisponibles(Integer.parseInt(evento.getActionCommand().substring(0, 1)), Integer.parseInt(evento.getActionCommand().substring(1)));
			}catch (NullPointerException excep) {
				JOptionPane.showMessageDialog(this, "Formato no valido", "Warning", JOptionPane.WARNING_MESSAGE);
			}
		
		}else {
			ventana.escribirmovimiento(evento.getActionCommand().substring(0, 2));

		}
		
	}
	
	public void pintardisponibles(int f1, int c1) throws NullPointerException{
		
		for (int f=0; f<ventana.dartablero().darceldas().length; f++) {
			
			for (int c=0; c<ventana.dartablero().darceldas()[0].length; c++) {
				
				if (ventana.dartablero().validacionglobal(f1, c1, f, c)) {
					ventana.dartablero().darceldas()[f][c].setdisponible(true);
					String comando = ""+f+""+c;
					if (ventana.dartablero().darceldas()[f][c].dardisponible()) {
						comando+="M";
					}

					casillas[f][c].setActionCommand(comando);
					casillas[f][c].setBackground(new Color(35,206,107));
					casillas[f][c].setEnabled(true);
					//254, 74, 73 rojo
				}
			}
		}
	}
		
	public void reiniciardisponibles() {
		for (int f=0; f<ventana.dartablero().darceldas().length; f++) {
			for (int c=0; c<ventana.dartablero().darceldas()[0].length; c++) {
				ventana.dartablero().darceldas()[f][c].setdisponible(false);
			}
		}
	}
	
	public void setenables(String jugador){
		actualizar();
		char criterio='N';
		
		if (jugador.equals("Jugador 1")){
			criterio='B';
		}
		
		for (int f=0; f<casillas.length; f++){
			for (int c=0; c<casillas[0].length; c++){
				if (ventana.dartablero().darceldas()[f][c].darpieza()!=null){
					
					if (ventana.dartablero().darceldas()[f][c].darpieza().darcolor()!=criterio){
						casillas[f][c].setDisabledIcon(casillas[f][c].getIcon());
						casillas[f][c].setEnabled(false);					
						}else{
							casillas[f][c].setEnabled(true);
						}
				}else{
					casillas[f][c].setDisabledIcon(casillas[f][c].getIcon());
					casillas[f][c].setEnabled(false);
				}
			}
		}
	}
	
	
		
}
