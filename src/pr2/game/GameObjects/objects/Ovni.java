package pr2.game.GameObjects.objects;

import pr2.game.Game;

/*
* Juan Pablo Corella y Markel Alvarez (2ºB)
*/

import pr2.game.GameObjects.*;

public class Ovni extends EnemyShip implements IExecuteRandomActions{

	private Boolean active;
	public static String icono = "O";

	/*Inicializa los atributos de la clase*/
	public Ovni(Game game, int x, int y) {

		super(game, x, y, 1, 25);
		setActive(false);
	}

	public boolean receiveMissileAttack(int damage) {

		getDamage(damage);
		return true;
	}

	/*GETS y SETS*/

	@Override
	public String toString() {

		return Ovni.icono + super.toString();
	}

	public String getIcono() {

		return icono;
	}

	public void setIcono(String icono) {

		Ovni.icono = icono;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}
