package tresEnRaya;

public class Jugador {

	private char color;
	
	public Jugador(char color) {
		assert color == 'x' || color == 'o';
		this.color = color;
	}

	public void ponerFicha(Tablero tablero) {
		assert tablero != null;
		assert !tablero.estaCompleto(this);
		this.ponerFicha(tablero, null);
	}
	
	private void ponerFicha(Tablero tablero, Coordenada coordenadaRepetida) {
		new GestorIO().out("Pone el jugador con"+ color + "\n");
		tablero.ponerFicha(this.recogerCoordenadaPuestaValida(tablero, coordenadaRepetida), color);
	}
	
	private Coordenada recogerCoordenadaPuestaValida(Tablero tablero, Coordenada coordenadaRepetida) {
		Coordenada resultado = new Coordenada();
		String error = "";
		do {
			resultado.recoger();
			error = this.errorPuesta(tablero, resultado, coordenadaRepetida);
			if(!error.equals("")) {
				new GestorIO().out("Error!!"+error+"\n");
			}
		}while(!error.equals(""));
		return resultado;
	}
	
	private String errorPuesta(Tablero tablero, Coordenada coordenada, Coordenada coordenadaRepetida) {
		if(tablero.ocupada(coordenada)) {
			return "Coordenada ocupada en el tablero";
		}
		if(coordenadaRepetida != null && coordenadaRepetida.igual(coordenada)) {
			return "No se puede poner de donde se quito la ficha";
		}
		return "";
	}

	public void moverFicha(Tablero tablero) {
		assert tablero != null;
		assert tablero.estaCompleto(this);
		new GestorIO().out("Mueve el jugador con" + color + "\n");
		Coordenada retirada = this.recogerCoordenadaRetiradaValida(tablero);
		tablero.retirarFicha(retirada);
		this.ponerFicha(tablero, retirada);
	}

	private Coordenada recogerCoordenadaRetiradaValida(Tablero tablero) {
		Coordenada resultado = new Coordenada();
		String error = "";
		do {
			resultado.recoger();
			error = this.errorRetirada(tablero, resultado);
			if(!error.equals("")) {
				new GestorIO().out("Error!!!" + error + "\n");
			}
		}while(!error.equals(""));
		return resultado;
	}

	private String errorRetirada(Tablero tablero, Coordenada coordenada) {
		if(!tablero.ocupada(coordenada, color)) {
			return "Coordenada no ocupada en el tablero por una ficha"+ color;
		}
		return "";
	}

	public void cantaVictoria() {
		new GestorIO().out("eoeoeeoeoeoeoo! los " + color +" son los mejores");
	}

	public char color() {
		return color;
	}

}
