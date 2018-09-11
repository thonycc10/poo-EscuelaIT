package solitario;

import tresEnRaya.GestorIO;

class klondike {
	
	private Baraja baraja;
	private Palo[] palos;
	private Descarte descarte;
	private Columna[] columnas;
	
	private klondike() {
		baraja = new Baraja();
		descarte = new Descarte();
		palos = new Palo[4];
		for (int i = 0; i < palos.length; i++) {
			palos[i] = new Palo();
		}
		columnas = new Columna[7];
		for (int i = 0; i < columnas.length; i++) {
			columnas[i] = new Columna(i+1,baraja);
		}
	}
	
	private void jugar() {
		GestorIO gestorIO = new GestorIO();
		Menu menu = new Menu();
		int opcion;
		do {
			this.mostrar();
			opcion = menu.getOpcion();
			switch(menu.getOpcion()) {
			case 1:
				baraja.moverA(descarte);
				break;
			case 2:
				descarte.moverA(palos);
				break;
			case 3:
				descarte.moverA(columnas);
				break;
			case 4:
				gestorIO.out("De que palo? [1-4]: ");
				Palo palo = palos[gestorIO.inInt()-1];
				gestorIO.out("A que columna? [1-7]: ");
				Columna columna = columnas[gestorIO.inInt()-1];
				palo.moverA(columna);
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				break;
			}
		}while(opcion != 9); 		
	}
	
	private void mostrar() {
		baraja.mostrar();
		descarte.mostrar();
		for (int i = 0; i < palos.length; i++) {
			palos[i].mostrar();
		}
		for (int i = 0; i < columnas.length; i++) {
			columnas[i].mostrar();
		}
	}

	public static void main(String[] args) {
		new klondike().jugar();
	}

	
}
