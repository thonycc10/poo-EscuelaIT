package tresEnRaya;

public class Tablero {

//	private char[][] casillas;
	
	private Coordenada[][] fichas;
	
	private static final int DIMENSION = 3;
	private static final char VACIA = '_';
	
	public Tablero() {
		fichas = new Coordenada[2][3];
	}
	
	public void mostrar() {
		GestorIO gestorIO = new GestorIO();
		for(int i=0; i<DIMENSION; i++) {
			for(int j=0; j< DIMENSION; j++) {
				gestorIO.out(this.getColor(new Coordenada(i,j)));
			}
			gestorIO.out("\n");
		}
		gestorIO.out("\n");
	}
	
	

	private char getColor(Coordenada coordenada) {
		if(this.tiene(coordenada, 0)) {
			return 'o';
		}
		if(this.tiene(coordenada, 1)) {
			return 'x';
		}
		return VACIA;
	}
	
	private boolean tiene(Coordenada coordenada, int jugador) {
		for(int i=0; i<fichas[jugador].length; i++) {
			if(fichas[jugador][i] != null && fichas[jugador][i].igual(coordenada)) {
				return true;
			}
		}
		return false;
	}

	public boolean hayTresEnRaya() {
		return this.hayTresEnRaya(0) || this.hayTresEnRaya(1);
	}
	
	private boolean hayTresEnRaya(int jugador) {
		int direccion = fichas[jugador][0].direccion(fichas[jugador][1]);
		if(direccion == -1) {
			return false;
		}
		return direccion == fichas[jugador][1].direccion(fichas[jugador][2]);
	}

	public boolean estaCompleto(Jugador jugador) {
		assert jugador != null;
		int fila = this.getFila(jugador.color());
		int contador = 0;
		for(int i=0; i<fichas[fila].length;i++) {
			if(fichas[fila][i] != null) {
				contador++;
			}
		}
		return contador == DIMENSION;
	}

	public boolean ocupada(Coordenada coordenada, char color) {
		assert coordenada != null;
		int fila = this.getFila(color);
		for(int i=0; i<fichas[fila].length;i++) {
			if(fichas[fila][i] != null && fichas[fila][i].igual(coordenada)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean ocupada(Coordenada coordenada) {
		return !this.ocupada(coordenada,VACIA);
	}

	public void ponerFicha(Coordenada coordenada, char color) {
		assert coordenada != null;
		int fila = this.getFila(color);
		int i = 0;
		while (fichas[fila][i] != null) {
			i++;
		}
		fichas[fila][i] = coordenada;
	}
	
	private int getFila(char color) {
		if(color=='o') {
			return 0;
		}
			return 1;
	}

	public void retirarFicha(Coordenada coordenada) {
		assert coordenada != null;
		assert this.ocupada(coordenada);
		for (int i = 0; i < fichas.length; i++) {
			for (int j = 0; j < fichas[i].length; j++) {
				if(fichas[i][j] != null && fichas[i][j].igual(coordenada)) {
					fichas[i][j] = null;
				}
			}
		}
	}

}
