package pr2.game.GameObjects.objects;

import pr2.game.Game;

public class ExplosiveShip extends RegularShip {

	public static String icono = "E";
	private int damage = 1;
	
	public ExplosiveShip(Game game, int x, int y, int live, int cycles) {
		
		super(game, x, y, live);
		cyclesToMove = cycles;
	}
	
	@Override
	public void onDelete() {
		
		game.explosion(x, y, damage);
	}
	
	@Override
	public void computerAction() {
	}
	
	@Override
	public String toString() {

		return ExplosiveShip.icono + super.toString();
	}
}