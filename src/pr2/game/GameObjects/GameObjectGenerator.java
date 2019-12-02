package pr2.game.GameObjects;

import java.io.*;
import pr2.game.Game;
import pr2.game.GameObjects.objects.*;
import pr2.game.control.FileContentsVerifier;
import pr2.game.exceptions.FileContentsException;

public class GameObjectGenerator {
	
	private static GameObject[] availableGameObjects = {
		new UCMShip(),
		new Ovni(),
		new RegularShip(),
		new DestroyerShip(),
		new ExplosiveShip(),
		new ShockWave(),
		new Bomb(),
		new UCMShipLaser(),
		new SuperLaser()
	};
	
	public static GameObject parse(String stringFromFile, Game game, FileContentsVerifier verifier) throws FileContentsException {
		
		GameObject gameObject = null;
		for (GameObject go: availableGameObjects)
		{
			gameObject = go.parse(stringFromFile, game, verifier);
			
			if (gameObject != null)
			{
				break;
			}
		}
		
		return gameObject;
	}
}