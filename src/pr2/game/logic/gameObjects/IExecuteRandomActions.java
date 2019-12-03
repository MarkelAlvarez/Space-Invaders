package pr2.game.logic.gameObjects;

import pr2.game.logic.Game;

public interface IExecuteRandomActions {

	static boolean canGenerateRandomOvni(Game game) {
	
		return ( (game.getRandom().nextDouble()) < (game.getLevel().getOvniFrequency()) );
	}
	
	static boolean canGenerateRandomBomb(Game game) {
	
		return ( (game.getRandom().nextDouble()) < (game.getLevel().getShootFrequency()) );
	}
	
	static boolean canGenerateExplosiveShip(Game game) {
		
		return ( (game.getRandom().nextDouble()) < 0.05 );
	}
}