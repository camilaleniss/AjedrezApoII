package modelo;

public class Rey extends Pieza{

	public Rey(char color) {
		super(color);
		setid('R');
	}

	@Override
	public boolean validarlogica(int f1, int c1, int f2, int c2) {
		if ((Math.abs(f1-f2)<=1 && (Math.abs(c1-c2) <=1))){
			return true;
		}
		return false;
	}

}
