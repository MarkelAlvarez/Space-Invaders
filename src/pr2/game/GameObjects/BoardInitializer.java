package pr2.game.GameObjects;

import pr2.game.*;
import pr2.game.GameObjects.Lists.GameObjectBoard;
import pr2.game.GameObjects.objects.*;

public class BoardInitializer {
	private Level level ;
	private GameObjectBoard board;
	private Game game;
	
	public GameObjectBoard initialize(Game game, Level level) {
		
		this.level = level;
		this.game = game;
		board = new GameObjectBoard(Game.DIM_X, Game.DIM_Y);
		initializeOvni () ;
		initializeRegularAliens () ;
		initializeDestroyerAliens () ;
		return board;
	}
	
	private void initializeOvni () {
		board.add(new Ovni(game, 0, Game.DIM_Y));
	}
	
	private void initializeRegularAliens () {
		
		int inic = Game.DIM_Y/2 - level.getNumRegularAliensPerRow()/2 + 1;	//mismo numero de naves en cada lado
		
		int fila = 1;
		while (fila <= level.getNumRowsOfRegularAliens()) {
			for (int i = 0; i < level.getNumRegularAliensPerRow(); i++) {
				AlienShip aux = new RegularShip(game, fila, inic + i);
				board.add(aux);
			}
			fila ++;
		}
	}
	
	private void initializeDestroyerAliens () {
		int inic = Game.DIM_Y/2 - level.getNumRegularAliensPerRow()/2 + 1;	//mismo numero de naves en cada lado
		
		for (int i = 0; i < level.getNumRegularAliensPerRow(); i++) {
			AlienShip aux = new DestroyerShip(game, level.getNumRowsOfRegularAliens() + 1, inic + i, i);
			board.add(aux);
		}
	}
}