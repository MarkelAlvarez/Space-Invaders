package pr2.game.GameObjects.objects;

import pr2.game.Game;
import pr2.game.GameObjects.*;
/*
* Juan Pablo Corella y Markel Alvarez (2ºB)
*/

public class UCMShip extends Ship{

	private boolean hasShockwave;
	private boolean canShootLaser;
	static String icono = "^__^";;
	static String death = "!xx!";
	private int points;

	/*Inicializa los atributos de la clase*/
	public UCMShip(Game game, int x, int y) {

		super(game, x, y , 3);		//el 3 es la vida
		hasShockwave = false;
		canShootLaser = true;
		points = 0;
	}

	public boolean receiveBombAttack(int damage) {

		getDamage(damage);
		return true;
	}

	@Override
	public String toString() {
		return getIcono();
	}

	public String stateToString() {
		return "Points: " + points + "\n";
	}

	public void setState(int points) {
		this.points += points;
	}

	public boolean getLaser() {

		return canShootLaser;
	}

	public void setLaser(boolean laser) {

		this.canShootLaser = laser;
	}

	public boolean getShockwave() {

		return hasShockwave;
	}

	public void setShockwave(boolean shockwave) {

		this.hasShockwave = shockwave;
	}

	public String getDeath() {

		return death;
	}

	public void setDeath(String death) {

		UCMShip.death = death;
	}

	public String getIcono() {

		return icono;
	}

	public void setIcono(String icono) {

		UCMShip.icono = icono;
	}


}
