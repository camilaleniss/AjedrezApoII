package interfaz;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;

public class PanelFilas extends JPanel {
	
	public static int NFILAS = 8;
	private JLabel filas[];
	private Ventana ventana;
	
	public PanelFilas(Ventana ventana) {
		this.ventana=ventana;
		setLayout(new GridLayout (8,1));
		setPreferredSize(new Dimension(30,30));
		setBackground(Color.WHITE);
		
		//TitledBorder	border	=	BorderFactory.createTitledBorder("Filas");			
		//border.setTitleColor(	Color.BLUE	);		
		//setBorder(	border	); 
		
		
		
		filas = new JLabel [NFILAS];
		String alf[] = ventana.dartablero().darfilas();
		
		Font negrita;
		for (int f=0; f<filas.length; f++) {
				filas[f]= new JLabel(alf[f]);
				 filas[f].setHorizontalAlignment(JLabel.CENTER);
				 negrita = new Font("Bookman Old Style", Font.ITALIC, 14);
				filas[f].setFont(negrita);
				add(filas[f]);
		}
		
		
		
	}
	
	public void reordenarfilas() {
		ventana.dartablero().reordenarfilas();
			String alf[] = ventana.dartablero().darfilas();
		
		for (int f=0; f<filas.length; f++) {
				filas[f].setText(alf[f]);;
		}
	}
	
	public String escribirmovimiento (int fila) {
		
		return filas[fila].getText();
	}

}
