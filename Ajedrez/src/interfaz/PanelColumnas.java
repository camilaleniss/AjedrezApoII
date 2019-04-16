package interfaz;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class PanelColumnas extends JPanel{
	
	public static int NCOLUMNAS = 8;
	
	private JLabel columnas [];
	private Ventana ventana;
	
	public PanelColumnas(Ventana ventana) {
		this.ventana= ventana;
		setLayout(new GridLayout (1,9));
		setPreferredSize(new Dimension(30,30));
		setBackground(Color.WHITE);
		
		//TitledBorder	border	=	BorderFactory.createTitledBorder("Columnas");			
		//border.setTitleColor(	Color.BLUE	);		
		//setBorder(	border	); 
		
		columnas = new JLabel [NCOLUMNAS];
		
		//aqui deberia llegar el atributo del modelo 
		
		
		String alf[] = ventana.dartablero().darcolumnas();
		Font negrita;
		for (int c=0; c<columnas.length; c++) {
				columnas[c]= new JLabel(alf[c]);
				 columnas[c].setHorizontalAlignment(JLabel.CENTER);
				 negrita = new Font("Bookman Old Style", Font.ITALIC, 14);
					columnas[c].setFont(negrita);
				add(columnas[c]);
			
		}
		add(new JLabel(" "));
	}
	
	public void reordenarcolumnas() {
		ventana.dartablero().reordenarcolumnas();
		String alf[] = ventana.dartablero().darcolumnas();
		for (int c=0; c<columnas.length; c++) {
				columnas[c].setText(alf[c]);;
			
		}
	}
	
	public String escribirmovimiento (int columna) {
		return columnas[columna].getText();
	}

}
