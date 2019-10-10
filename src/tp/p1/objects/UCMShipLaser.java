package tp.p1.objects;

public class UCMShipLaser {

	private int posX;
	private int posY;
	private int damage;
	private String icono;
	
	public UCMShipLaser(int x, int y) {
		
		posX = x;
		posY = y;
		damage = 1;
		icono = "oo";
	}
	
	/*GETS y SETS*/
	
	public int getPosX() {
		
		return posX;
	}
	
	public void setPosX(int posX) {
		
		this.posX = posX;
	}
	
	public int getPosY() {
		
		return posY;
	}
	
	public void setPosY(int posY) {
		
		this.posY = posY;
	}
	
	public int getDamage() {
		
		return damage;
	}
	
	public void setDamage(int damage) {
		
		this.damage = damage;
	}
	
	public String getIcono() {
		
		return icono;
	}
	
	public void setIcono(String icono) {
		
		this.icono = icono;
	}

}
