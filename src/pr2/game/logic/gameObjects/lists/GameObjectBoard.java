package pr2.game.logic.gameObjects.lists;

/*
* Juan Pablo Corella y Markel Alvarez (2ÂºB)
*/

import pr2.game.logic.gameObjects.*;
import pr2.game.logic.gameObjects.objects.*;

public class GameObjectBoard {

	private GameObject[] objects;
	private int currentObjects;

	/*
	 * Inicialización del tablero
	*/
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

	/*
	 * Añade nuevos objetos a la lista
	*/
	public void add (GameObject object) {

		objects[currentObjects] = object;
		currentObjects++;
	}

	/*
	 * Obtiene el objeto que hay en unas coordenadas
	*/
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

	/*
	 * Aquí se actualiza el estado de juego. Primero se comprueban si hay colision,
	 * si es afirmativo se eliminara(n) de la lista. Despues se repite la operación
	 * pero moviendo los objetos y volviendo a comprobar las colisiones para luego
	 * eliminar todo aquello que no tenga vida de la lista
	*/
	public void update() {
		
		for (int i = 0; i < currentObjects; i++)
		{
			if(objects[i].isAlive() && objects[i] instanceof Weapon)
			{
				checkAttacks(objects[i]);
			}
		}

		removeDead();
		
		for (int i = 0; i < currentObjects; i++)
		{
			if(objects[i].isAlive() && objects[i] instanceof Weapon)
			{
				objects[i].move();
				checkAttacks(objects[i]);
			}
		}
		
		removeDead();
	}

	/*
	 * Aqui se comprueban las colisiones de los proyectiles con los elementos del juego
	*/
	private void checkAttacks(GameObject object) {
		
		if(!(object instanceof ShockWave))
		{
			int i = 0;
			
			while (i < currentObjects)
			{
				if(objects[i].isOnPosition(object.getX(), object.getY()) && objects[i].isAlive() && objects[i] != object)
				{
					if(object.performAttack(objects[i]))
					{
						object.getDamage(object.getLive());
						i = currentObjects;
					}
				}
				i++;
			}
		}
		else
		{
			for (int i = 0; i < currentObjects; i++)
			{
				object.performAttack(objects[i]);
			}
			object.getDamage(object.getLive());
		}
	}
	
	/*
	 * Este metodo se encarga de gestionar la explosion de la ExplosiveShip
	*/
	public void explosion(int x, int y, int damage) {
		
		for (int i = -1; i < 2; i++)
		{
			for (int j = -1; j < 2; j++)
			{
				if(!(i == 0 && j == 0))
				{
					GameObject aux = getObjectInPosition(x + i, y + j);
					if(aux != null)
					{
						aux.receiveExplosiveAttack(damage);
					}
				}
			}
		}
	}

	/*
	 * Se mueven los objetos del juego despues de haber hecho todas las comprobaciones
	 * correspondientes
	*/
	public void computerAction() {
		
		for (int i = 0; i < currentObjects; i++)
		{
			if(objects[i] instanceof AlienShip)
			{
				objects[i].move();
			}
			else if(objects[i] instanceof Ovni)
			{
				if(((Ovni) objects[i]).getActive())
				{
					objects[i].move();
				}
			}
		}
		
		for (int i = 0; i < currentObjects; i++)
		{
			objects[i].computerAction();
		}
	}

	/*
	 * Aquí se eliminan los elementos del juego sin vida
	*/
	private void removeDead() {
		
		boolean explosiveCheck = false;
		
		for (int i = 0; i < currentObjects; i++)
		{
			if (!(objects[i] instanceof ShockWave))
			{
				if(!objects[i].isAlive() || objects[i].isOut())	
				{
					if(objects[i] instanceof Ovni)
					{
						if(!objects[i].isAlive())
						{
							if(((Ovni) objects[i]).getActive())
							{
								objects[i].onDelete();
							}
						}
						else
						{
							((Ovni) objects[i]).deactivate();
						}
					}
					else
					{
						objects[i].onDelete();
						
						if(!(objects[i] instanceof UCMShip)) 
						{
							if(objects[i] instanceof ExplosiveShip)
							{
								explosiveCheck = true;
							}
							remove(objects[i]);
							i--;
						}
					}
				}
			}
			else if(!objects[i].isAlive())
			{
				objects[i].onDelete();
				remove(objects[i]);
			}
		}
		
		if (explosiveCheck)
		{
			removeDead();
		}
	}

	/*
	 * Este algoritmo complementa al anterior en la eliminación de los objectos en la lista
	*/
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

	/*
	 * Recibe la información de los objetos en modo texto
	*/
	public String toStringifier() {
		
		String str = "";
		
		for (int i = 0; i < currentObjects; i++)
		{
			if (!(objects[i] instanceof ShockWave))
			{
				str += objects[i].toStringifier() + "\n";
			}
		}
		
		return str;
	}
}