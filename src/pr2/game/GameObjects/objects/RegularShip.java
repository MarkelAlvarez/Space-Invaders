package pr2.game.GameObjects.objects;

import pr2.game.Game;

/*
* Juan Pablo Corella y Markel Alvarez (2ºB) 
*/

import pr2.game.GameObjects.*;

public class RegularShip extends AlienShip {

	private int puntos;
	private String icono;
	
	/*Inicializa los atributos de la clase*/
	public RegularShip (Game game, int x, int y) {

		super(game, x, y, 3);
		puntos = 5;
		icono = "C[" + live + "]";
	}

	/*GETS y SETS*/
	
	
	public int getPuntos() {

		return puntos;
	}
	
	public void setPuntos(int puntos) {

		this.puntos = puntos;
	}
	
	public String getIcono() {
		
		return icono;
	}
	
	public void setIcono(String icono) {

		this.icono = icono;
	}
	
	public String toString() {
		
		return icono = "C[" + live + "]";
	}
}