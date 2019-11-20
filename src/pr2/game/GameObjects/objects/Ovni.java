package pr2.game.GameObjects.objects;

/*
* Juan Pablo Corella y Markel Alvarez (2ºB)
*/

import pr2.game.Game;
import pr2.game.GameObjects.*;

public class Ovni extends EnemyShip implements IExecuteRandomActions{

	private Boolean active;
	public static String icono = "O";
	public static int puntos = 25;
	public static int live = 1;

	/*Inicializa los atributos de la clase*/
	public Ovni(Game game, int x, int y) {

		super(game, x, y, live, puntos);
		setActive(false);
	}

	public boolean receiveMissileAttack(int damage) {

		getDamage(damage);
		return true;
	}

	@Override
	public void computerAction() {
		if(!active) {
			active = IExecuteRandomActions.canGenerateRandomOvni(game);
		}
	}
	

	/*GETS y SETS*/

	@Override
	public String toString() {
	
		if (active) {
			return Ovni.icono + super.toString();
		}
		
		return "";
	}
	
	@Override
	public void move() {
		if(isAlive() && !isOut()) {
			y--;
		}
	}
	
	@Override
	public void onDelete() {
		super.onDelete();
		active = false;
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
