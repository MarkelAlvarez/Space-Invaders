package pr2.game.GameObjects.objects;

import pr2.game.Game;
import pr2.game.GameObjects.Weapon;

/*
* Juan Pablo Corella y Markel Alvarez (2ºB) 
*/

public class Bomb extends Weapon{

	
	private int id;
	private String icono;
	
	/*Inicializa los atributos de la clase*/
	public Bomb(Game game, int x, int y, int ident) {

		super(game, x, y, 1, 1);
		id = ident;
		icono = "·";
	}	
	
	/*GETS y SETS*/
	

	public int getDamage() {

		return damage;
	}
	
	public void setDamage(int damage) {

		this.damage = damage;
	}
	
	public int getId() {

		return id;
	}
	
	public void setId(int id) {

		this.id = id;
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
