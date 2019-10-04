package tp.p1.lists;

import tp.p1.objects.Bomb;

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
	
	public void deleteBomb(int x, int y) {
		int i = 0;
		while (i < contador) {
			if(list[i].getPosX() == x && list[i].getPosY() == y) {
				for (int j = i + 1; j < contador; j++) {
					list[i] = list[j];
					i++;
				}
			}
			i++;
		}
		contador--;
	}
	// gets && sets
	
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