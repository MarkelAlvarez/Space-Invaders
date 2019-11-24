package pr2.game.GameObjects.objects;

import pr2.game.Game;
import pr2.game.logic.Move;

public class ExplosiveShip extends RegularShip {

	public static String icono = "E";
	private int damage = 1;
	
<<<<<<< HEAD
	public ExplosiveShip(Game game, int x, int y, int live, int cycles, Move move) {
=======
	public ExplosiveShip(Game game, int x, int y, int live, int cycles) {
		
>>>>>>> 77be59c0d9beab7e16be38b40d67317cd4563962
		super(game, x, y, live);
		cyclesToMove = cycles;
		this.move = move;
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

<<<<<<< HEAD
=======
		//return ExplosiveShip.icono + super.toString();
>>>>>>> 77be59c0d9beab7e16be38b40d67317cd4563962
		return ExplosiveShip.icono + "[" + live + "]";
	}
}