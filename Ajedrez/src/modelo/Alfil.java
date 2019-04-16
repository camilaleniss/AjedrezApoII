package modelo;

public class Alfil extends Pieza{

	public Alfil(char color) {
		super(color);
		setid('A');
		
	}

	@Override
	public boolean validarlogica(int f1, int c1, int f2, int c2) {
		
		if (Math.abs(f1-f2) == Math.abs(c1-c2)) {
			return true;
		}
		return false;
	} 
	
	

}
