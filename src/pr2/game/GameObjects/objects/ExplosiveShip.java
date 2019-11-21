package pr2.game.GameObjects.objects;

import pr2.game.Game;

public class ExplosiveShip extends RegularShip {

	public static String icon = "E";
	
	public ExplosiveShip(Game game, int x, int y, int live, int cycles) {
		super(game, x, y, live, cycles);
	}
	
	@Override
	public void onDelete() {
	}
	
	@Override
	public void computerAction() {
		
	}
}
