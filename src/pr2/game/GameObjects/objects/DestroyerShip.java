package pr2.game.GameObjects.objects;

import pr2.game.Game;

/*
* Juan Pablo Corella y Markel Alvarez (2ºB) 
*/

import pr2.game.GameObjects.*;

public class DestroyerShip extends AlienShip {

	private int id;	//Ayuda a identificar cada nave y su proyectil lanzado
	private Boolean bomb;
	private String icono;
	
	/*Inicializa los atributos de la clase*/
	public DestroyerShip(Game game, int x, int y, int ident) {

		super(game, x, y, 1, 10);
		id = ident;
		bomb = false;
		icono = "D[" + live + "]";
	}
	
	/*GETS y SETS*/
	
	public int getId() {
		
		return id;
	}
	
	public void setId(int ident) {
		
		this.id = ident;
	}
	
	public Boolean canShootBomb() {
		
		return bomb;
	}
	
	public void setBomb(Boolean bomb) {
		
		this.bomb = bomb;
	}
	
	@Override
	public String toString() {
		
		return icono = "D[" + live + "]";
	}
	
	public String getIcono() {
		
		return icono;
	}
	
	public void setIcono(String icono) {
		
		this.icono = icono;
	}
	
}
