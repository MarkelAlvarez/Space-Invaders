package tp.p1.lists;

import tp.p1.objects.RegularShip;

public class RegularShipList {

	private RegularShip[] list;
	private int contador;
	
	public RegularShipList(int naves) {

		list = new RegularShip[naves];
		contador = 0;
		
		for (int i = 0; i < 4; i++)
		{
			addRegular(1, i + 3);
		}

		if (naves == 8)
		{
			for (int i = 0; i < 4; i++)
			{
				addRegular(2, i + 3);
			}
		}
	}
	
	public void addRegular(int x, int y) {

		list[contador] = new RegularShip(x, y);
		contador++;
	}
	
	public void deleteRegular(int x, int y) {
		
		int i = 0;
		while (i < contador)
		{
			if(list[i].getPosX() == x && list[i].getPosY() == y)
			{
				for (int j = i + 1; j < contador; j++)
				{
					list[i] = list[j];
					i++;
				}
			}
			i++;
		}
		contador--;
	}
	
	public Boolean isFound(int x, int y) {

		int i = 0;
		Boolean found = false;

		while((i < contador) && (!found)) 
		{
			if(list[i].getPosX() == x && list[i].getPosY() == y)
			{
				found = true;
			}
			
			i++;
		}
		
		return found;
	}
	
	/*GETS y SETS*/
	
	public RegularShip[] getList() {
		
		return list;
	}
	
	public void setList(RegularShip[] rList) {
		
		this.list = rList;
	}
	
	public int getContador() {
		
		return contador;
	}
	
	public void setContador(int contador) {
		
		this.contador = contador;
	}

}
