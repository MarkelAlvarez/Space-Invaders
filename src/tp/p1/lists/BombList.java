package tp.p1.lists;

import tp.p1.objects.Bomb;

public class BombList {

	private Bomb[] list;
	private int contador;
	
	public BombList(int naves) {

		list = new Bomb[naves];
		contador = 0;
	}
	
	public void addBomb(int x, int y, int id) {

		list[contador] = new Bomb(x, y, id);
		contador++;
	}
	
	/*
	* Borra bomba si la encuentra y devuelve si se ha eliminado ya que solo tiene 1 de vida
	*/
	public Boolean deleteBomb(int x, int y) {

		int i = 0, j;
		Boolean found = false;					
		
		while (i < contador)
		{
			if((list[i].getPosX() == x) && (list[i].getPosY() == y))
			{
				for (j = i + 1; j < contador; j++)
				{
					list[i] = list[j];
					i++;
				}

				found = true;
				contador--;
			}

			i++;
		}

		return found;
	}
	
	public Boolean isFound(int x, int y) {	//para ObjectToString

		int i = 0;
		Boolean found = false;
		
		while((i < contador) && (!found))
		{
			if((list[i].getPosX() == x) && (list[i].getPosY() == y))
			{
				found = true;
			}

			i++;
		}
		
		return found;
	} 
	
	/*GETS y SETS*/
	
	public Bomb[] getList() {

		return list;
	}
	
	public void setlist(Bomb[] list) {

		this.list = list;
	}
	
	public int getContador() {

		return contador;
	}
	
	public void setContador(int contador) {

		this.contador = contador;
	}
	
}