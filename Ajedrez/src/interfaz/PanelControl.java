package interfaz;

import javax.swing.*;

import modelo.PiezaException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelControl extends JPanel implements ActionListener{
	
	public static String JUGAR = "jugar";
	public static String GIRAR180 = "girar180";
	public static String GIRAR90 ="girar90";

	private int contadorgiros;
	private JLabel labjugador;
	private JLabel labicon;
	private JTextField txtJugada;
	private JButton butJugada;
	private JButton butRotar;
	private JButton butGirar90;
	private Ventana ventana;
	
	
	public PanelControl(Ventana ventana) {
		this.ventana = ventana;
		
		setLayout(new GridLayout (20,1));
		setPreferredSize(new Dimension(100,320));
		
		labjugador	=	new	JLabel("Jugador 1");
		labicon= new JLabel();
		txtJugada = new JTextField();
		butJugada = new JButton("Mover");
		butRotar = new JButton ("Girar");
		butGirar90 = new JButton ("Girar 90");
		
		butJugada.addActionListener(this);
		butJugada.setActionCommand(JUGAR);
		
		butRotar.addActionListener(this);
		butRotar.setActionCommand(GIRAR180);
		
		butGirar90.addActionListener(this);
		butGirar90.setActionCommand(GIRAR90);
		
		butJugada.setBackground(Color.lightGray);
		butRotar.setBackground(Color.lightGray);
		butGirar90.setBackground(Color.lightGray);
		
		Font negrita;
		negrita = new Font("Bookman Old Style", Font.BOLD, 16);
		labjugador.setFont(negrita);
		labjugador.setText("Jugador 1");
		
		negrita = new Font("Bookman Old Style", Font.BOLD, 12);
		butJugada.setFont(negrita);
		butRotar.setFont(negrita);
		butGirar90.setFont(negrita);
		
		
		String img=("images/Jugador1.png");
		labicon.setIcon(new ImageIcon(img));
		labicon.setPreferredSize(new Dimension(24,24));
		
		add(labicon);
		add(labjugador);
		add(txtJugada);
		add(new JLabel(""));
		add(butJugada);
		add(new JLabel(""));
		add(butRotar);
		add(new JLabel(""));
		add(butGirar90);
		add(new JLabel(""));
		
		setBackground(Color.WHITE);
		
		contadorgiros=1;
	}
	
	
	public void actionPerformed (ActionEvent evento) {
		
		
		String	comando	= evento.getActionCommand();
		
			if(	comando.equals(JUGAR)){
				try{
				ventana.moverpieza(darcodigo());
				cambiarjugador();
				ventana.girar180();
				}catch (PiezaException pe){
					JOptionPane.showMessageDialog(this, pe.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
				}catch (NullPointerException e){
					JOptionPane.showMessageDialog(this, "Formato no valido", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				borrarcodigo();
			}
			
			if(	comando.equals(GIRAR180)){
				ventana.girar180();
				
				if (contadorgiros%2==0){
					butJugada.setEnabled(false);
				}else{
					butJugada.setEnabled(true);
				}
			}
			if (comando.equals(GIRAR90)){
				ventana.girar90();
				contadorgiros++;
				butJugada.setEnabled(false);
			}
			
		}
	
	public String darcodigo() {
		return txtJugada.getText();
	}
	
	public void borrarcodigo() {
		txtJugada.setText("");
	}
	
	public String darjugador() {
		return labjugador.getText();
	}
	
	public void setJugador(String jugador) {
		labjugador.setText(jugador);
	}
	
	public void escribirmovimiento (String mov) {
		String movimiento = txtJugada.getText();
		if (movimiento.length()==4) {
			txtJugada.setText(mov);
		}else {
			movimiento += mov;
			txtJugada.setText(movimiento);
		}
		
	}
	
	public void cambiarjugador() {
		String img;
		if ((labjugador.getText()).equals("Jugador 1")) {
			img=("img/Jugador2.png");
			setJugador("Jugador 2");
			ventana.reiniciardisponibles();
			
			
		}else {
			img=("img/Jugador1.png");
			setJugador("Jugador 1");
		}
		
		labicon.setIcon(new ImageIcon(img));
	}
	

	
}

	
