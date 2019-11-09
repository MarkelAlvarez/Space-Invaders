package pr2.game.GameObjects;
import java.util.Random;

import pr2.game.Game;
import pr2.game.Level;

public interface IExecuteRandomActions {

	static boolean canGenerateRandomOvni(Game game){
	
		return game.getRandom().nextDouble() < game.getLevel().getOvniFrequency();
	}
	
	static boolean canGenerateRandomBomb(Game game){
	
		return game.getRandom().nextDouble() < game.getLevel().getShootFrequency();
	}
}