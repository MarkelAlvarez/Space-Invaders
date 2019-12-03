package pr2.game.logic.gameObjects.objects;

import pr2.game.logic.Game;
import pr2.game.logic.Move;

public class ExplosiveShip extends RegularShip {

	public static String icono = "E";
	private int damage = 1;

	public ExplosiveShip(Game game, int x, int y, int live, int cycles, Move move) {
		
		super(game, x, y, live);
		cyclesToMove = cycles;
		this.move = move;
	}

	@Override
	public void onDelete() {
		
		super.onDelete();
		game.explosion(x, y, damage);
	}

	@Override
	public void computerAction() {
	}

	@Override
	public String toString() {

		return ExplosiveShip.icono + "[" + live + "]";
	}
	
	@Override
	public String toStringifier() {
		
		return icono + ": " + x + " " + y + " " + live + " " + cyclesToMove + " " + Move.toString(move);
	}

}
