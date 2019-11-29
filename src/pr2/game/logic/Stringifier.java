package pr2.game.logic;

import pr2.game.Game;

public class Stringifier extends GamePrinter {
	
	public Stringifier() {
	}

	public String toString(Game game) {
				
		System.out.print(game.stringifier());
		
		return "";
	}
}