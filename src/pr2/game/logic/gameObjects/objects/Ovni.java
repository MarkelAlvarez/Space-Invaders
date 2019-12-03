package pr2.game.logic.gameObjects.objects;

import pr2.game.logic.Game;
import pr2.game.logic.gameObjects.EnemyShip;
import pr2.game.logic.gameObjects.IExecuteRandomActions;

public class Ovni extends EnemyShip implements IExecuteRandomActions{

	private Boolean active;
	public static String icono = "O";
	public static int puntos = 25;
	public static int life = 1;

	/*Inicializa los atributos de la clase*/
	public Ovni(Game game, int x, int y) {

		super(game, x, y, life, puntos);
		setActive(false);
	}

	public boolean receiveMissileAttack(int damage) {

		getDamage(damage);
		return true;
	}

	@Override
	public void computerAction() {
		
		if(!active)
		{
			if(IExecuteRandomActions.canGenerateRandomOvni(game))
			{
				x = 0;
				y = Game.DIM_Y - 1;
				live = life;
				active = true;
			}
		}
	}
	
	public void deactivate() {
		
		active = false;
	}
	
	@Override
	public String toString() {
	
		if (active)
		{
			return Ovni.icono + super.toString();
		}
		
		return "";
	}
	
	@Override
	public void move() {
		
		if(isAlive() && !isOut())
		{
			y--;
		}
	}
	
	@Override
	public void onDelete() {
		
		if(active) //para que no lo compruebe cuando está muerto
		{
			super.onDelete();
			game.enableShockWave();
			deactivate();
		}
	}
	
	@Override
	public String toStringifier() {
		
		return icono + ": " + x + " " + y + " " + live;
	}

	/*GETS y SETS*/

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