package modelo;

public class Caballo extends Pieza{

	public Caballo( char color) {
		super(color);
		setid('C');
	}

	@Override
	public boolean validarlogica(int f1, int c1, int f2, int c2) {
		if ((f1-f2)*(f1-f2) +(c1-c2)*(c1-c2) == 5) {
			return true;
		}
		return false;
	}

}
