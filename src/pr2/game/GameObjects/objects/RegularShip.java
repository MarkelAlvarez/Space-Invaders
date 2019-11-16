package pr2.game.GameObjects.objects;

import pr2.game.Game;

/*
* Juan Pablo Corella y Markel Alvarez (2ºB) 
*/

import pr2.game.GameObjects.*;

public class RegularShip extends AlienShip {

	private String icono;
	
	/*Inicializa los atributos de la clase*/
	public RegularShip (Game game, int x, int y) {

		super(game, x, y, 3, 5);
		icono = "C[" + live + "]";
	}

	/*GETS y SETS*/
	
	@Override
	public String toString() {
		
		return icono = "C[" + live + "]";
	}
	
	public String getIcono() {
		
		return icono;
	}
	
	public void setIcono(String icono) {

		this.icono = icono;
	}
	
}