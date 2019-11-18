package pr2.game.GameObjects;

import pr2.game.Game;
import pr2.game.logic.Move;

public class EnemyShip extends Ship {

	protected Move move;
	protected int points;

	public EnemyShip(Game game, int x, int y, int live, int points) {

		super(game, x, y, live);
		this.move = Move.LEFT;
		this.points = points;
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDelete() {
		game.receivePoints(points);
	}

	@Override
	public void move() {

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + live + "]";
	}

}
