package pr2.game.GameObjects.objects;

/*
* Juan Pablo Corella y Markel Alvarez (2ºB)
*/

import pr2.game.Game;
import pr2.game.GameObjects.GameObject;
import pr2.game.GameObjects.Weapon;
import pr2.game.logic.Move;

public class ShockWave extends Weapon {

	public ShockWave(Game game) {
		
		super(game, -1, -1, 1, 1, Move.NONE);
	}

	public boolean performAttack(GameObject other) {

		return other.receiveShockWaveAttack(this.damage);
	}
	
	@Override
	public void onDelete() {
		game.enableShockWave();
	}
}