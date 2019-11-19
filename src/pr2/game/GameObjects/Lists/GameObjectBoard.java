package pr2.game.GameObjects.Lists;

/*
* Juan Pablo Corella y Markel Alvarez (2ºB)
*/

import pr2.game.GameObjects.GameObject;
import pr2.game.GameObjects.objects.Ovni;

public class GameObjectBoard {

	private GameObject[] objects;
	private int currentObjects;

	public GameObjectBoard (int width, int height)
	{
		objects = new GameObject[width * height];

		for (int i = 0; i < width * height; i++)
		{
			objects[i] = null;
		}
		currentObjects = 0;
	}

	private int getCurrentObjects () {

		return currentObjects;
	}

	public void add (GameObject object) {

		objects[currentObjects] = object;
		currentObjects++;
	}

	private GameObject getObjectInPosition (int x, int y) {

		int i = 0;

		while (i < currentObjects)
		{
			if (objects[i].isOnPosition(x, y))
			{
				return objects[i];
			}
			i++;
		}

		return null;
	}

	private int getIndex(int x, int y) {

		int i = 0;

		while (i < currentObjects)
		{
			if (objects[i].isOnPosition(x, y))
			{
				return i;
			}
			i++;
		}

		return -1;
	}

	private void remove (GameObject object) {

		int i = 0;

		while (i < currentObjects)
		{
			if (objects[i] == object)
			{
				for (int j = i + 1; j < currentObjects; j++)
				{
					objects[i] = objects[j];
					i++;
				}
				objects[currentObjects - 1] = null;
				currentObjects--;
				i = currentObjects;
			}
			i++;
		}
	}

	public void update() {
		// TODO implement
	}

	private void checkAttacks(GameObject object) {
		// TODO implement
	}

	public void computerAction() {
		// TODO implement
	}

	private void removeDead() {

		if(((Ovni) objects[0]).getActive() && (!objects[0].isAlive()))
		{
			((Ovni) objects[0]).setActive(false);
		}

		for (int i = 1; i < currentObjects; i++)
		{
			if(!objects[i].isAlive())
			{
				remove(objects[i]);
				i--;
				currentObjects--;
			}
		}
	}

	public String toString(int i, int j) {

		for (int aux = 0; aux < currentObjects; aux++)
		{
			if (objects[aux].isOnPosition(i, j))
			{
				return objects[aux].toString();
			}
		}

		return "";
	}
}
