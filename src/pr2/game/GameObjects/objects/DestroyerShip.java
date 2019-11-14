package pr2.game.GameObjects.objects;

import pr2.game.Game;

/*
* Juan Pablo Corella y Markel Alvarez (2ºB) 
*/

import pr2.game.GameObjects.*;

public class DestroyerShip extends AlienShip {

	private int id;	//Ayuda a identificar cada nave y su proyectil lanzado
	private int puntos;
	private Boolean bomb;
	private String icono;
	
	/*Inicializa los atributos de la clase*/
	public DestroyerShip(Game game, int x, int y, int ident) {

		super(game, x, y, 1);
		id = ident;
		puntos = 10;
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
	
	public int getPuntos() {
		
		return puntos;
	}
	
	public void setPuntos(int puntos) {
		
		this.puntos = puntos;
	}
	
	public Boolean getBomb() {
		
		return bomb;
	}
	
	public void setBomb(Boolean bomb) {
		
		this.bomb = bomb;
	}
	
	public String getIcono() {
		
		return icono;
	}
	
	public void setIcono(String icono) {
		
		this.icono = icono;
	}
	
	public String toString() {
		
		return icono = "D[" + live + "]";
	}
}
