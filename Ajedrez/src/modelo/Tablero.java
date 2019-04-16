package modelo;


public class Tablero {

	public static int NFILAS = 8;
	public static int NPIEZAS = 16;
	
	private String [] filas = {"8" ,"7","6", "5", "4","3","2","1"};
	private String [] columnas = { "a", "b", "c", "d", "e", "f", "g", "h" };
	
	private Celda[][] celdas;
	
	public Tablero() {
		
		celdas = new Celda[NFILAS][NFILAS];
		crearceldas();
		inicializarpiezas();
		
	}
	
	public String[] darfilas() {
		return filas;
	}
	
	public String[] darcolumnas() {
		return columnas;
	}
	
	public Celda[][] darceldas(){
		return celdas;
	}
	
	public void setfilas (String[] filas) {
		this.filas =filas;
	}
	
	public void setcolumnas (String[] columnas) {
		this.columnas =columnas;
	}
	
	public void setceldas (Celda[][] celdas) {
		this.celdas=celdas;
	}
	
	public void reordenarfilas() {
		int cont=filas.length;
		String[] filass = new String [filas.length];
		
		for (int i=0; i<filas.length; i++) {
			filass[i] = filas[cont-1];
			cont--;
		}
		
		setfilas (filass);
	}
	
	public void crearceldas() {
		
		for (int f =0; f<celdas.length; f++) {
			for (int c=0; c<celdas[0].length; c++) {
				celdas[f][c]= new Celda (filas[f], columnas[c]);
				
			}
		}
		
	}
	
	public void reordenarcolumnas() {
		int cont= columnas.length;
		String[] columnass = new String [columnas.length];
		
		for (int i=0; i<columnas.length; i++) {
			columnass[i] = columnas[cont -1];
			cont--;
		}
		
		setcolumnas (columnass);
	}

	public void inicializarpiezas() {
		char id;
		char color;
		for (int f=0; f<celdas.length; f++) {
			for (int c=0; c<celdas[0].length; c++) {
				
				if (f==0 || f==1 || f==6 || f==7) {
					//si es torre
					if (c==0 || c==7) {
						id = 'T';
					}else if (c==1 || c==6) {
						id = 'C';
					}else if (c==2 || c==5) {
						id ='A';
					}else if (c==3) {
						id='D';
					}else {
						id='R';
					}
					
					if (f==1 || f==6){
						id='P';
					}

					if (f==0 || f==1) {
						color = 'N';
					}else {
						color ='B';
					}
					
					switch (id) {
					case 'T':
							celdas[f][c].setpieza(new Torre(color));
						break;
					case 'C':
							celdas[f][c].setpieza(new Caballo(color));
						break;
					case 'A':
							celdas[f][c].setpieza(new Alfil(color));
						break;
					case 'D':
							celdas[f][c].setpieza(new Dama(color));
						break;
					case 'R':
							celdas[f][c].setpieza(new Rey(color));
						break;
					case 'P':
							celdas[f][c].setpieza(new Peon(color));
						break;					
					}
				}
			}
		}
		
		
	}
	
	public void reordenarceldas(){
		
		int contf=celdas.length;
		int contc=celdas[0].length;
		
		Celda [][] pceldas = new Celda[NFILAS][NFILAS];
		
		for (int f=0; f<pceldas.length; f++) {
			contf--;
			contc=celdas[0].length;
			
			for (int c=0; c<pceldas[0].length; c++) {
				contc--;
				pceldas[f][c] = celdas[contf][contc];
				
			}
			
		}
		
		setceldas(pceldas);
		
	}
	
	public void girar90(){
		
		int contc=celdas[0].length;
		Celda [][] pceldas = new Celda[NFILAS][NFILAS];
			
			for (int f=0; f<pceldas.length; f++){
				contc--;
				for (int c=0; c<pceldas[0].length; c++){
					pceldas[c][contc] = celdas[f][c];
				}
			}
			setceldas(pceldas);
	}

	public void moverpieza (String cod){
		String coorinicio, coorfinal;
		
		coorinicio=extraerinicio(cod);
		coorfinal=extraerfinal(cod);
		
		encontrarinicio(coorinicio, coorfinal);
		
	}
	
	public void encontrarinicio(String coorinicio, String coorfinal) {
		Pieza p = null;
		boolean i = true;
		for (int f=0; f<celdas.length && i; f++){
			for (int c=0; c<celdas[0].length && i; c++){
				
				if (celdas[f][c].darcod().equals(coorinicio)) {			
					
					if(celdas[f][c].darpieza()!=null) {
						p=celdas[f][c].darpieza();
						celdas[f][c].setpieza(null);
						encontrarfinal(coorfinal, p);
						i=false;
					}
					
				}
			}
		}	
	}
	
	public void encontrarfinal(String coorfinal, Pieza p) {
		boolean i = true;
		for (int f=0; f<celdas.length && i; f++){
			for (int c=0; c<celdas[0].length && i; c++){
				
				if (celdas[f][c].darcod().equals(coorfinal)) {
						celdas[f][c].setpieza(p);
						i=false;
					}
					
				}
			}
	}

	public String extraerinicio(String cod){
		String coorinicio="";
		if (cod.length()==4){
			coorinicio=cod.substring(0, 2);
		}else{
			coorinicio=cod.substring(1, 3);
		}
		return coorinicio;
	}
	
	public String extraerfinal(String cod){
		String coorinicio="";
		if (cod.length()==4){
			coorinicio=cod.substring(2, 4);
		}else{
			coorinicio=cod.substring(3, 5);
		}
		return coorinicio;
	}

	//Métodos que validan la jugada
	
	//Este metodo valida si en el recorrido de la celda 1 a la celda 2 (por filas) hay alguna interferencia
	
	public boolean validacionglobal(int f1, int c1, int f2, int c2) throws NullPointerException {		
		if (validacionfinal(f1, c1, f2, c2)) {		
			if (celdas[f1][c1].darpieza().validarlogica(f1, c1, f2, c2)) {
				if (validacioninterferencia(f1, c1, f2, c2)){
					celdas[f1][c1].setdisponible(true);
					return true;
				}else {
					return false;
				}
			}else {	
				return false;
			}
		}else {
			return false;
		}
	}
	
	public boolean validacioninterferencia(int f1, int c1, int f2, int c2) throws NullPointerException{
		
		boolean fil, col, dia;
		if (celdas[f1][c1].darpieza() instanceof Caballo) {
			return true;
		}else {
			if (Math.abs(f1-f2) == Math.abs(c1-c2)) {
				dia=recorridodiagonal(f1, c1, f2, c2);
				fil=true;
				col=true;
			}else {
				fil=recorridofilas(f1, c1, f2, c2);
				col=recorridocolumnas(f1, c1, f2, c2);
				dia=true;
			}
		}
		return (fil && col && dia);	
	}
	
	public boolean recorridofilas(int f1, int c1, int f2, int c2) throws NullPointerException{
		
		boolean disponible = false;
		int f=f1;
		
		if (f1==f2)
			return true;
		
		while (f!=f2) {
			
			if (f1>f2) {
				if (celdas[f][c1].darpieza()!=null && celdas[f][c1]!=celdas[f1][c1]) {	
					return false;
				}else {
					disponible=true;
				}
				f--;
				}else if (f1<f2) {
					if (celdas[f][c1].darpieza()!=null &&  celdas[f][c1]!=celdas[f1][c1]) {
					
					return false;
				}else {
					disponible=true;
				}
				
				f++;
			}
			
		}
		
		return disponible;
	}
	
	public boolean recorridocolumnas(int f1, int c1, int f2, int c2) throws NullPointerException{
		boolean disponible = false;
		int c=c1;
		
		if (c1==c2)
			return true;
		
		
		while (c!=c2) {
			if (c1>c2) {
				
				if (celdas[f1][c].darpieza()!=null && celdas[f1][c]!=celdas[f1][c1]) {	
					return false;
				}else {
					disponible=true;
				}
				
				c--;
				
			}else if (c1<c2) {
				
					if (celdas[f1][c].darpieza()!=null && celdas[f1][c]!=celdas[f1][c1]) {
					
					return false;
				}else {
					disponible=true;
				}
				
				c++;
			}
		}
		
		return disponible;
	}
	
	public boolean recorridodiagonal (int f1, int c1, int f2, int c2) throws NullPointerException {
		boolean disponible = false;
		
		int c=c1;
		int f=f1;
		int factorf=1;
		int factorc=1;
		
		if (c1<c2) {
			if (f1<f2) {
			}else {
				factorf=-(factorf);
			}
		}else {
			if (f1<f2) {
				factorc=-(factorc);	
			}else {
				factorf=-(factorf);
				factorc=-(factorc);	
			}
				
		}
		
		
		do {
			
			f=f+factorf;
			c=c+factorc;
			if (celdas[f][c].darpieza()!=null) {
				if ((c==c2) && (f==f2)) {
					if(celdas[f1][c1].darpieza().darcolor()!=celdas[f2][c2].darpieza().darcolor()) {
						disponible=true;
					}
				}else {
					return false;
				}
				
			}else {
				disponible=true;
			}
			
		} while (c!=c2);
		
		return disponible;
		
	}
		
	public int darcoordenadas (String coordenada, String tipo) throws NullPointerException {
		if (tipo.equals("fila")) {
			for (int i=0; i<filas.length; i++) {
				if (filas[i].equals(coordenada)) 
						return i;
			}
		}else {
			for (int i=0; i<columnas.length; i++) {
				if (columnas[i].equals(coordenada)) 
						return i;
			}
		}
		
		NullPointerException npe = new NullPointerException();
		throw npe;
	}
	
	public boolean validacionfinal(int f1, int c1, int f2, int c2) throws NullPointerException {
		
		if (celdas[f1][c1].darpieza() instanceof Peon) {
			
			if ((f1==f2) || (c1==c2)) {
				
				if((celdas[f2][c2].darpieza()==null)) {
					return true;
				}else {
					return false;
				}			
			}else {
				if (celdas[f2][c2].darpieza()!=null) {
				if (celdas[f1][c1].darpieza().darcolor()!=celdas[f2][c2].darpieza().darcolor()) {
					return true;
				}else {
					return false;
				}
				}else {
					return false;
				}
			}
		}else {
			if (celdas[f2][c2].darpieza()!=null) {
				if (celdas[f1][c1].darpieza().darcolor()!=celdas[f2][c2].darpieza().darcolor()) {
					return true;
				}else {
					return false;
				}
			}else {
				return true;
			}
		}
		
	}
	
	
}
