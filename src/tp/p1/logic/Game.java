package tp.p1.logic;

import tp.p1.objects.*;
import tp.p1.control.Controller;
import tp.p1.lists.*;

import java.util.Random;
import java.util.Scanner;

public class Game {

	private Ovni Ovni;
	private UCMShip UCMShip;
	private UCMShipLaser UCMShipLaser;
	
	private Boolean end;
	private Boolean sentido;
	private Level level;
	
	private RegularShipList rList;
	private DestroyerShipList dList;
	private BombList bList;
	
	private int ciclos;
	private int puntuacion;
	private Random rand;
	
	public Game(Level level, Random rand) {
		this.level = level;
		this.rand = rand;
		end = false;
	}
	
	public void initGame() {
		rList = new RegularShipList(level.getNumRegularAliens());
		dList = new DestroyerShipList(level.getNumDestroyerAliens(), level.getLineDestroyer(), level.getColDestroyerAliens());
		bList = new BombList(level.getNumDestroyerAliens());
		UCMShip = new UCMShip();
		ciclos = 0;
		puntuacion = 0;
		sentido = false;
	}
	
	public String toString() {
		
		return "";
	}
	
	/*USER COMMAND*/
	public String leerComando() {
		
		return "";
	}
	
	public String move() {
		
		return "";
	}
	
	public String shoot() {
		
		return "";
	}
	
	public String shockwave() {
			
		return "";
	}
	
	public String reset() {
		
		return "";
	}
	
	public void help() {
		
		System.out.println("move <left|right><1|2>: Moves UCM-Ship to the indicated direction.\r\n" + 
				"shoot: UCM-Ship launches a missile.\r\n" + 
				"shockWave: UCM-Ship releases a shock wave.\r\n" + 
				"list: Prints the list of available ships.\r\n" + 
				"reset: Starts a new \r\n" + 
				"help: Prints this help message.\r\n" +
				"exit: Terminates the program.\r\n"+
				"[none]: Skips one cycle.");

	}
	
	public void list() {
		
		/*System.out.print("[R]egular ship: Points: " + this. " - Harm: " + this. " - Shield: " + this. "\n");
		System.out.print("[D]estroyer ship: Points: " + this. " - Harm: " + this. " - Shield: " + this. "\n");
		System.out.print("[O]vni: " + this. " - Harm: " + this. " - Shield: " + this. "\n");
		System.out.print("^__^: Harm: " + this. " - Shield: " + this. "\n");*/
	}
	
	public String none() {
		
		return "";
	}
	public String exit() {
		
		return null;		
	}
	
	/*COMPUTER ACTION*/
	public String computerAction() {
		
		return "";
	}
	
	/*UPDATE*/
	public String update() {
		
		return "";
	}
	
	public String toStringObjectAt(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void userCommand(String comando)
	{
		//String comando = comandoMenu();
		String [] number = comando.split(" ");

		if ((number[0].equalsIgnoreCase("move")) || (number[0].equals("M"))) {
			int foo = Integer.parseInt(number[2]);
			if (foo > 2) {
				foo = 2;
			}
			else if (foo < 1) {
				foo = 1;
			}
			if (number[1].equals("left")) {
				moveShipLeft(foo);
			}
			else if (number[1].equals("right")) {
				moveShipRight(foo);
			}
		}
		else if ((comando.equalsIgnoreCase("shoot")) || (comando.equals("S"))) {
			shoot();
		}
		else if ((comando.equalsIgnoreCase("shockwave")) || (comando.equals("W"))) {
			shockwave();
		}
		else if ((comando.equalsIgnoreCase("none")) || (comando.equals("N"))) {
			none();
		}
		else if ((comando.equalsIgnoreCase("list")) || (comando.equals("L"))) {
			list();
		}
		else if ((comando.equalsIgnoreCase("reset")) || (comando.equals("R"))) {
			reset();
		}
		else if ((comando.equalsIgnoreCase("help")) || (comando.equals("H"))) {
			help();
		}
		else if ((comando.equalsIgnoreCase("exit")) || (comando.equals("E"))) {
			exit();
		}
		else {
			System.out.println("Entrada no valida.");
		}
	}
	
	public void moveOvni(Ovni ovni) {
		ovni.setPosX(ovni.getPosX() - 1);
	}
	
	public void moveAliensLeft(){
		
		for (int i = 0; i < rList.getContador(); i++) {
			rList.getList()[i].setPosX(rList.getList()[i].getPosX() - 1);
		}
		for (int i = 0; i < dList.getContador(); i++) {
			dList.getList()[i].setPosX(dList.getList()[i].getPosX() - 1);
		}
	}
	
	public void moveAliensRight() {
		
		for (int i = 0; i < rList.getContador(); i++) {
			rList.getList()[i].setPosX(rList.getList()[i].getPosX() + 1);
		}
		for (int i = 0; i < dList.getContador(); i++) {
			dList.getList()[i].setPosX(dList.getList()[i].getPosX() + 1);
		}
	}
	
	public void moveAliensDown() {
		
		for (int i = 0; i < rList.getContador(); i++) {
			rList.getList()[i].setPosY(rList.getList()[i].getPosY() + 1);
		}
		for (int i = 0; i < dList.getContador(); i++) {
			dList.getList()[i].setPosY(dList.getList()[i].getPosY() + 1);
		}
	}
	
	public void moveShipLeft(int pasos) {
		
		UCMShip.setPosX(UCMShip.getPosX() - pasos);
	}

	public void moveShipRight (int pasos) {

		UCMShip.setPosX(UCMShip.getPosX() + pasos);
	}
	
	public void moveBomb(Bomb bomb) {
		bomb.setPosY(bomb.getPosY() + 1);		
	}
	
	public void moveLaser(UCMShipLaser laser) {
		laser.setPosY(laser.getPosY() - 1);
	}

	public UCMShip getUCMShip() {
		return UCMShip;
	}
	
	public Boolean getEnd() {
		return end;
	}
	
	public void setEnd(Boolean end) {
		this.end = end;
	}
	
	public Boolean getSentido() {
		return sentido;
	}
	
	public void setSentido(Boolean sentido) {
		this.sentido = sentido;
	}
	
	public RegularShipList getrList() {
		return rList;
	}

	public DestroyerShipList getdList() {
		return dList;
	}
	
	public BombList getbList() {
		return bList;
	}

	
	public int getCiclos() {
		return ciclos;
	}
	
	public void setCiclos(int ciclos) {
		this.ciclos = ciclos;
	}
	
	public int getPuntuacion() {
		return puntuacion;
	}
	
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
}
