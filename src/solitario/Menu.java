package solitario;

import tresEnRaya.GestorIO;

public class Menu {

	public int getOpcion() {
		GestorIO gestorIO = new GestorIO();
		gestorIO.out("1. Mover de baraja a descarte");
		gestorIO.out("2. Mover de descarte a palo");
		gestorIO.out("3. Mover de descarte a columna");
		gestorIO.out("4. Mover de palo a columna");
		gestorIO.out("5. Mover de columna a palo");
		gestorIO.out("6. Mover de columna a columna");
		gestorIO.out("7. Voltear carta en columna");
		gestorIO.out("1. Voltear descarte en baraja");
		gestorIO.out("Opcion? [1-9]: ");
		return gestorIO.inInt();
	}

}
