package escuelIt;

public class Coordenada {

	private int fila;
	private int columna;
	private static final Intervalo LIMITES = new Intervalo(1,3);
	
	public Coordenada() {
	}
	
	public Coordenada(int fila, int columna) {
		this.fila = fila;
		this.columna = columna;
		assert this.valida();
	}
	
	public void recoger() {
		GestorIO gestorIO = new GestorIO();
		boolean error = false;
		do {
			gestorIO.out("Introduce fila [1,3]:");
			fila = gestorIO.inInt();
			gestorIO.out("Introduce columna [1,3]");
			columna = gestorIO.inInt();
			error = !this.valida();
			if(error) {
				new GestorIO().out("Error!! Valores fuera de rango\n");
			}
		}while(error);
	}

	public boolean valida() {
		return LIMITES.incluye(fila) && LIMITES.incluye(columna);
	}

	public int getColumna() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getFila() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public boolean igual(Coordenada coordenada) {
		assert coordenada != null;
		return fila == coordenada.fila && columna == coordenada.columna;
	}

}
