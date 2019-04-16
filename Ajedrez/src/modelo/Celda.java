package modelo;

public class Celda {
	
	private String fila;
	private String columna;
	private String cod;
	private boolean disponible;
	
	private Pieza pieza;
	
	
	public Celda(String fila, String columna) {
		this.fila= fila;
		this.columna = columna;
		cod = columna+fila;
		pieza = null;
		disponible= false;
		
	}
	
	public String darfila() {
		return fila;
	}
	
	public String darcolumna() {
		return columna;
	}
	
	public String darcod(){
		return cod;
	}
	
	public Pieza darpieza(){
		return pieza;
	}
	
	public boolean dardisponible() {
		return disponible;
	}
	
	public void setfila(String fila) {
		this.fila=fila;
	}
	
	public void setcolumna(String columna) {
		this.columna=columna;
	}
	
	public void setcod(){
		cod =  columna+ fila;
	}
	
	public void setpieza(Pieza p){
		pieza=p;
	}
	
	public void setdisponible(boolean d) {
		disponible=d;
	}
	


}
