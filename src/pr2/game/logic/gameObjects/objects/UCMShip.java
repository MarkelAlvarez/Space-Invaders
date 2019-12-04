package pr2.game.logic.gameObjects.objects;

import pr2.game.exceptions.CommandExecuteException;
import pr2.game.exceptions.MissileInFlightException;
import pr2.game.exceptions.NoShockwaveException;
import pr2.game.exceptions.NotEnoughPoints;
import pr2.game.exceptions.OffWorldException;
import pr2.game.logic.Game;
import pr2.game.logic.gameObjects.Ship;

public class UCMShip extends Ship{
	
	private int points;
	private boolean hasShockwave;
	private boolean canShootLaser;
	public static String icono = "^__^";
	public static String death = "!xx!";
	public static int life = 3;

	/*Inicializa los atributos de la clase*/
	public UCMShip(Game game, int x, int y) {

		super(game, x, y , life); //el 3 es la vida
		hasShockwave = false;
		canShootLaser = true;
		points = 0;
	}

	public boolean receiveBombAttack(int damage) {

		getDamage(damage);
		
		return true;
	}
	
	public boolean shootLaser() throws MissileInFlightException {
		
		if(canShootLaser)
		{
			game.addObject(new UCMShipLaser(game, x, y, UCMShipLaser.damage));
			game.enableMissile();
			
			return true;
		}
		System.out.println("Failed to shoot");
		throw new MissileInFlightException("Cause of Exception:\r\n" + 
				"	pr2.exceptions.MissileInFlightException: Cannot fire missile: missile already exists on board");
	}
	
	public boolean shockwave() throws NoShockwaveException {
		
		if(hasShockwave)
		{
			game.addObject(new ShockWave(game));
			hasShockwave = false;
			
			return true;
		}
		System.out.println("Failed to shoot");
		throw new NoShockwaveException("Cause of Exception:\r\n" + 
				"	pr2.exceptions.NoShockwaveException: Cannot release shockwave: no shockwave available");
	}
	
	public boolean buy() throws NotEnoughPoints {
		
		if(points > SuperLaser.cost)
		{
			game.addObject(new SuperLaser(game, x, y));
			game.receivePoints(-SuperLaser.cost);
			
			return true;
		}
		System.out.println("Failed to shoot");
		throw new NotEnoughPoints("Cause of Exception:\r\n" + 
				"	pr2.exceptions.NotEnoughPoints: Cannot fire superlaser: there are not enough points.");
	}
	
	public void receivePoints(int points) {
		
		this.points += points;
	}
	
	public boolean move(int cells) throws CommandExecuteException, OffWorldException {
		
		y += cells;
		
		if (y < 0)
		{
			y = 0;
			System.out.println("Failed to move");
			throw new OffWorldException("Cause of Exception:\r\n" + 
					"	pr2.exceptions.OffWorldException: Cannot perform move: ship too near border", new OffWorldException());
		}
		else if (y >= Game.DIM_Y)
		{
			y = Game.DIM_Y - 1;
			System.out.println("Failed to move");
			throw new OffWorldException("Cause of Exception:\r\n" + 
					"	pr2.exceptions.OffWorldException: Cannot perform move: ship too near border");
		}
			
		return true;
	}
	
	@Override
	public String toString() {
		
		if (isAlive())
		{
			return getIcono();
		}
		
		return getDeath();
	}

	public String stateToString() {
		
		return "Points: " + points + "\n";
	}
	
	@Override
	public void onDelete() {
	}
	
	public String toStringifier() {
		
		return "P: " + x + " " + y + " " + live + " " + points + " " + hasShockwave + " " + (points / SuperLaser.cost);
	}

	/*GETS & SETS*/
	
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

		UCMShip.death = death;
	}

	public String getIcono() {

		return icono;
	}

	public void setIcono(String icono) {

		UCMShip.icono = icono;
	}
	
	public int getPoints() {
		
		return points;
	}
}