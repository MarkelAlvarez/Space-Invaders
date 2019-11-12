package pr2.game.GameObjects.Lists;

import pr2.game.GameObjects.GameObject;

public class GameObjectBoard {

	private GameObject[] objects;
	private int currentObjects;
	
	public GameObjectBoard (int width, int height) {
		objects = new GameObject[width * height];
		for (int i = 0; i < width * height; i++) {
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
		while (i < currentObjects) {
			if ((objects[i].getX() == x) && (objects[i].getY() == y)) {
				return objects[i];
			}
			i++;
		}
		return null;
	}
	
	private int getIndex(int x, int y) {
		int i = 0;
		while (i < currentObjects) {
			if ((objects[i].getX() == x) && (objects[i].getY() == y)) {
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
			if ((objects[i].getX() == object.getX()) && (objects[i].getY() == object.getY()))
			{
				for (int j = i + 1; j < currentObjects; j++)
				{
					objects[i] = objects[j];
					i++;
				}
				objects[currentObjects - 1] = null;
				currentObjects--;
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
	// TODO implement
	}
	
	public String toString(int x, int y) {
	// TODO implement
	}
}
