package pr2.game.GameObjects;

import pr2.game.Game;
import pr2.game.logic.Move;

public class Weapon extends GameObject {

	protected int damage;
	private Move move;
	public Weapon(Game game, int x, int y, int live, int damage, Move move) {
		super(game, x, y, live);
		this.damage = damage;
		this.move = move;
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub

	}

	@Override
	public void move() {
		if (move == Move.UP) {
			x--;
		}
		else {
			x++;
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
