package modelo;

public class Torre extends Pieza{

	public Torre(char color) {
		super(color);
		setid('T');
	}

	@Override
	public boolean validarlogica(int f1, int c1, int f2, int c2) {		
		if ((f1==f2) || (c1==c2)) {
			return true;
		}
		return false;
	}

}
