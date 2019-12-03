package pr2.game.logic.gameObjects.objects;

import pr2.game.logic.Game;
import pr2.game.logic.Move;
import pr2.game.logic.gameObjects.GameObject;
import pr2.game.logic.gameObjects.Weapon;

public class ShockWave extends Weapon {
	
	public static int damage = 1;

	public ShockWave(Game game) {
		
		super(game, -1, -1, 1, damage, Move.NONE);
	}

	public boolean performAttack(GameObject other) {

		return other.receiveShockWaveAttack(damage);
	}
	
	@Override
	public void onDelete() {
		
		game.enableShockWave();
	}
}