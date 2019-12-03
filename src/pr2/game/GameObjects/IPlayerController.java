package pr2.game.GameObjects;

import pr2.game.exceptions.CommandExecuteException;

/*
* Juan Pablo Corella y Markel Alvarez (2ºB)
*/

public interface IPlayerController {
	
	// PLAYER ACTIONS
	public boolean move (int numCells);
	public boolean shootLaser();
	public boolean shockWave() throws CommandExecuteException;
	
	// CALLBACKS
	public void receivePoints(int points);
	public void enableShockWave();
	public void enableMissile();
}