package pr2.game.GameObjects.objects;

import pr2.game.Game;
import pr2.game.GameObjects.Weapon;

/*
* Juan Pablo Corella y Markel Alvarez (2ºB) 
*/

public class UCMShipLaser extends Weapon {


	private String icono;
	
	/*Inicializa los atributos de la clase*/
	public UCMShipLaser(Game game, int x, int y) {
		
		super(game, x, y, 1, 1);
		icono = "oo";
	}
	
	/*GETS y SETS*/
	
	
	public int getDamage() {
		
		return damage;
	}
	
	public void setDamage(int damage) {
		
		this.damage = damage;
	}
	
	public String getIcono() {
		
		return icono;
	}
	
	public void setIcono(String icono) {
		
		this.icono = icono;
	}
	
	public String toString() {
		return icono;
	}
}
