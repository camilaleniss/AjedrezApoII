package modelo;

public class Peon extends Pieza implements Accion{
	
	private boolean ya;

	public Peon(char color) {
		super(color);
		setid('P');
		ya=false;
	}

	@Override
	public boolean validarlogica(int f1, int c1, int f2, int c2) {
		
		boolean respuesta = false;
		
		int diferenciafil = Math.abs(f1-f2);
		int diagonal = Math.abs(c1-c2);
		
		
		if (f2>f1) {
			return false;
		}
		
		if (ya) {
			if (((diagonal==1) && (diferenciafil==1)) || ((diagonal==0) && (diferenciafil==1)) ) {
				respuesta=true;
			}
		}else {
			if (((diferenciafil==2) || (diferenciafil==1)) && (diagonal==0 || diagonal==1)) {
				respuesta=true;
			}
		}
		
		
		return respuesta;
	}
	
	public void setya(boolean ya) {
		this.ya=ya;
	}
}
