package pr2.game.GameObjects.objects;

import pr2.game.Game;
import pr2.game.GameObjects.*;
/*
* Juan Pablo Corella y Markel Alvarez (2ºB) 
*/

public class UCMShip extends Ship{

	private boolean hasShockwave;
	private boolean canShootLaser;
	private String icono;
	private String death;
	private int points;
	
	/*Inicializa los atributos de la clase*/
	public UCMShip(Game game, int x, int y) {
		
		super(game, x, y , 3);		//el 3 es la vida
		hasShockwave = false;
		canShootLaser = true;
		icono = "^__^";
		death = "!xx!";
		points = 0;
	}
	
	public String stateToString() {
		return "Points: " + points + "\n";
	}
	
	public void setState(int points) {
		this.points += points;
	}
	
	public boolean getLaser() {
		
		return canShootLaser;
	}
	
	public void setLaser(boolean laser) {
		
		this.canShootLaser = laser;
	}
	
	public boolean getShockwave() {
		
		return hasShockwave;
	}
	
	public void setShockwave(boolean shockwave) {
		
		this.hasShockwave = shockwave;
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
