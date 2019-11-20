package pr2.game.GameObjects.objects;

/*
* Juan Pablo Corella y Markel Alvarez (2ºB)
*/

import pr2.game.Game;
import pr2.game.GameObjects.*;

public class RegularShip extends AlienShip {

	public static String icono = "C";
	public static int live = 3;
	public static int puntos = 5;

	/*Inicializa los atributos de la clase*/
	public RegularShip (Game game, int x, int y) {

		super(game, x, y, live, puntos);
	}

	public boolean receiveMissileAttack(int damage) {

		getDamage(damage);
		return true;
	}

	public boolean receiveShockWaveAttack(int damage) {

		getDamage(damage);
		return true;
	}

	/*GETS y SETS*/

	@Override
	public String toString() {

		return RegularShip.icono + super.toString();
	}

	public String getIcono() {

		return icono;
	}

	public void setIcono(String icono) {

		RegularShip.icono = icono;
	}
}