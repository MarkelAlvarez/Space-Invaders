package pr2.game.GameObjects.objects;

import pr2.game.Game;
import pr2.game.GameObjects.*;
/*
* Juan Pablo Corella y Markel Alvarez (2ºB) 
*/

public class UCMShip extends Ship{

	private boolean shockwave;
	private boolean laser;
	private String icono;
	private String death;
	
	/*Inicializa los atributos de la clase*/
	public UCMShip(Game game, int x, int y) {
		
		super(game, x, y , 3);		//el 3 es la vida
		shockwave = false;
		laser = false;
		icono = "^__^";
		death = "!xx!";
	}
	

	public boolean getLaser() {
		
		return laser;
	}
	
	public void setLaser(boolean laser) {
		
		this.laser = laser;
	}
	
	public boolean getShockwave() {
		
		return shockwave;
	}
	
	public void setShockwave(boolean shockwave) {
		
		this.shockwave = shockwave;
	}
	
	public String getDeath() {
		
		return death;
	}
	
	public void setDeath(String death) {
		
		this.death = death;
	}
	
	public String getIcono() {
		
		return icono;
	}
	
	public void setIcono(String icono) {
		
		this.icono = icono;
	}
	
	public String toString() {
		return getIcono();
	}
}
