package modelo;

public class Pieza implements Accion{
	
	public static char BLANCAS ='B';
	public static char NEGRAS ='N';
	
	private char id;
	private char color;
	
	public  Pieza (char color) {
		this.color=color;
	}
	
	public char darid() {
		return id;
	} 
	
	public char darcolor() {
		return color;
	}
	
	public void setid(char id) {
		this.id=id;
	}

	@Override
	public boolean validarlogica(int f1, int c1, int f2, int c2) throws NullPointerException{
		return true;
	}
	
	}

