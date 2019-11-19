package pr2.game.GameObjects;

/*
* Juan Pablo Corella y Markel Alvarez (2ºB)
*/

import pr2.game.Game;
import pr2.game.logic.Move;

public class AlienShip extends EnemyShip {

	protected static int REMAINING_ALIENS = 0;
	private static boolean IS_IN_FINAL_ROW;
	private static int SHIPS_ON_BORDER;
	protected int cyclesToMove;


	public AlienShip(Game game, int x, int y, int live, int points) {
		
		super(game, x, y, live, points);
		REMAINING_ALIENS += 1;
		SHIPS_ON_BORDER = 0;
		cyclesToMove = game.getLevel().getNumCyclesToMoveOneCell();
	}

	@Override
	public void move() {
		
		if (cyclesToMove== 0)
		{
			cyclesToMove = game.getLevel().getNumCyclesToMoveOneCell();
			super.move();
			if(x == 0)
			{
				IS_IN_FINAL_ROW = true;
			}
			if ((move == Move.LEFT && y == 0) || (move == Move.RIGHT && y == (Game.DIM_Y - 1)))
			{
				SHIPS_ON_BORDER = REMAINING_ALIENS;
			}
		}
		else if ((SHIPS_ON_BORDER > 0) && !IS_IN_FINAL_ROW)
		{
			x++;
			move.flip();
			SHIPS_ON_BORDER -= 1;
		}
		else
		{
			cyclesToMove--;
		}
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public static boolean haveLanded() {
		return IS_IN_FINAL_ROW;
	}

	public static boolean allDead() {
		return REMAINING_ALIENS == 0;
	}

	public static int getRemainingAliens() {
		return REMAINING_ALIENS;
	}
}
