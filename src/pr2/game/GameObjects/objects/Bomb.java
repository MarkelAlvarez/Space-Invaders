package pr2.game.GameObjects.objects;

/*
* Juan Pablo Corella y Markel Alvarez (2ºB)
*/

import pr2.game.Game;
import pr2.game.GameObjects.*;
import pr2.game.logic.Move;

public class Bomb extends Weapon implements IExecuteRandomActions{

	private DestroyerShip ship;
	private int id;
	private String icono = ".";

	/*Inicializa los atributos de la clase*/
	public Bomb(Game game, int x, int y, DestroyerShip ship) {

		super(game, x, y, 1, 1, Move.DOWN);
		this.ship = ship;
	}

	public boolean performAttack(GameObject other) {

		other.receiveBombAttack(this.damage);

		return true;
	}

	public boolean receiveMissileAttack(int damage) {

		getDamage(damage);
		return true;
	}

	/*GETS y SETS*/

	@Override
	public String toString() {
		return icono;
	}

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

}
