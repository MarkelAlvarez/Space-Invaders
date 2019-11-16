package pr2.game.GameObjects.objects;

import pr2.game.Game;
import pr2.game.GameObjects.Weapon;
import pr2.game.logic.Move;

public class ShockWave extends Weapon {

	public ShockWave(Game game) {
		super(game, -1, -1, 1, 1, Move.NONE);
	}

}
