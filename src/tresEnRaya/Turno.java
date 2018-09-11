package tresEnRaya;

import java.util.Random;

public class Turno {
	
	private int valor;

	public Turno() {
		valor = new Random().nextInt(2);
	}
	
	public int toca() {
		return valor;
	}

	public void cambiar() {
		valor = this.noToca();
	}

	public int noToca() {
		return (valor+1)%2;
	}

}
