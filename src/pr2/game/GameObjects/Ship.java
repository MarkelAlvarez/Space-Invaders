package pr2.game.GameObjects;

import pr2.game.Game;

public abstract class Ship extends GameObject {

	public Ship(Game game, int x, int y, int live) {
		super(game, x, y, live);
	}

	@Override
	public void computerAction() {
	}

	@Override
	public void onDelete() {
	}

	@Override
	public void move() {
	}

	@Override
	public String toString() {
		return null;
	}
}
