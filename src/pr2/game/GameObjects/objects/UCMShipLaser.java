package pr2.game.GameObjects.objects;

import pr2.game.Game;
import pr2.game.GameObjects.GameObject;
import pr2.game.GameObjects.Weapon;
import pr2.game.logic.Move;

/*
* Juan Pablo Corella y Markel Alvarez (2ºB)
*/

public class UCMShipLaser extends Weapon {

	static String icono = "oo";

	/*Inicializa los atributos de la clase*/
	public UCMShipLaser(Game game, int x, int y, UCMShip ship) {

		super(game, x, y, 1, 1, Move.UP);
	}

	public boolean performAttack(GameObject other) {

		other.receiveMissileAttack(this.damage);

		return true;
	};

	public boolean receiveBombAttack(int damage) {

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

	public String getIcono() {

		return icono;
	}

	public void setIcono(String icono) {

		UCMShipLaser.icono = icono;
	}

}
