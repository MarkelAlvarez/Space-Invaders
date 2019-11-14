package pr2.game.GameObjects;

import pr2.game.Game;

public class Weapon extends GameObject {

	protected int damage;
	public Weapon(Game game, int x, int y, int live, int damage) {
		super(game, x, y, live);
		this.damage = damage;
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
