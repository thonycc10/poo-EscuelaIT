package escuelIt;

public class Tablero {

	private char[][] casillas;
	private static final int DIMENSION = 3;
	private static final char VACIA = '_';
	
	public Tablero() {
		casillas = new char[DIMENSION][DIMENSION];
		for(int i=0; i<DIMENSION;i++) {
			for(int j=0; j<DIMENSION;j++) {
				casillas[i][j] = VACIA;
			}
		}
	}
	
	public void mostrar() {
		GestorIO gestorIO = new GestorIO();
		for(int i=0; i<DIMENSION; i++) {
			for(int j=0; j< DIMENSION; j++) {
				gestorIO.out(" " + casillas[i][j]);
			}
			gestorIO.out("\n");
		}
		gestorIO.out("\n");
	}

	public boolean hayTresEnRaya() {
		return this.hayTresEnRaya('x') || this.hayTresEnRaya('o');
	}
	
	private boolean hayTresEnRaya(char color) {
		int[] filas = new int[DIMENSION];
		int[] columnas = new int[DIMENSION];
		int diagonal = 0;
		int secundaria = 0;
		for(int i=0; i<DIMENSION; i++) {
			for(int j=0; j<DIMENSION;j++) {
				if(color == casillas[i][j]) {
					filas[i]++;
					columnas[j]++;
					if(i==j) {
						diagonal++;
					}
					if(i+j==2) {
						secundaria++;
					}
				}
			}
		}
		if( diagonal==DIMENSION || secundaria==DIMENSION) {
			return true;	
		}else {
			for(int i=0; i<3; i++) {
				if(filas[i] == 3 || columnas[i] == 3) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean estaCompleto(Jugador jugador) {
		assert jugador != null;
		int fichas = 0;
		for(int i=0; i<DIMENSION; i++) {
			for(int j=0; j<DIMENSION; j++) {
				if(jugador.color() == casillas[i][j]) { //1:33
					fichas++;
				}
			}
		}
		return fichas==DIMENSION;
	}

	public boolean ocupada(Coordenada coordenada, char color) {
		return casillas[coordenada.getFila()-1][coordenada.getColumna()-1]==color;
	}
	
	public boolean ocupada(Coordenada coordenada) {
		return !this.ocupada(coordenada,VACIA);
	}

	public void ponerFicha(Coordenada coordenada, char color) {
		assert coordenada != null;
		casillas[coordenada.getFila()-1][coordenada.getColumna()-1]=color;
	}

	public void retirarFicha(Coordenada coordenada) {
		assert coordenada != null;
		assert this.ocupada(coordenada);
		this.ponerFicha(coordenada, VACIA);
	}

}
