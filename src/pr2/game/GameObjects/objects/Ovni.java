package pr2.game.GameObjects.objects;

import pr2.game.Game;

/*
* Juan Pablo Corella y Markel Alvarez (2ºB) 
*/

import pr2.game.GameObjects.*;

public class Ovni extends EnemyShip{

	private Boolean active;
	private String icono;
	
	/*Inicializa los atributos de la clase*/
	public Ovni(Game game, int x, int y) {
		
		super(game, x, y, 1, 25);
		icono = "O[" + live + "]";
		setActive(false);
	} 

	/*GETS y SETS*/
	
	@Override
	public String toString() {
		
		return icono = "O[" + live + "]";
	}
	
	public String getIcono() {
		
		return icono;
	}

	public void setIcono(String icono) {

		this.icono = icono;
	}
	
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}
