package tp.p1.logic;

import tp.p1.objects.*;
import tp.p1.control.Controller;
import tp.p1.lists.*;

import java.util.Random;
import java.util.Scanner;

public class Game {

	private Ovni Ovni;
	private RegularShip RegularShip;
	private DestroyerShip DestroyerShip;
	private UCMShip UCMShip;
	private UCMShipLaser UCMShipLaser;
	private Bomb Bomb;
	
	private Boolean end;
	private Boolean sentido; //false es left y true es derecha
	private Boolean reset;
	private Boolean existOvni;
	private Level level;
	private Move move; 
	
	private RegularShipList rList;
	private DestroyerShipList dList;
	private BombList bList;
	
	private Random rand; 
	private int ciclos;
	private int puntuacion;
	
	public Game(Level level, Random rand) {

		this.level = level;
		this.rand = rand;
		end = false;
	}
	
	public void initGame() {

		RegularShip = new RegularShip(0, 0);	//inicializamos para tener un modelo para la lista y el toString
		DestroyerShip = new DestroyerShip(0, 0, 0);
		Ovni = new Ovni();
		Bomb = new Bomb(0, 0, 0);
		UCMShipLaser = new UCMShipLaser(0, 0);
		rList = new RegularShipList(level.getNumRegularAliens());
		dList = new DestroyerShipList(level.getNumDestroyerAliens(), level.getLineDestroyer(), level.getColDestroyerAliens());
		bList = new BombList(level.getNumDestroyerAliens());
		UCMShip = new UCMShip();
		ciclos = 0;
		puntuacion = 0;
		existOvni = false;
		sentido = false;
		reset = false;
	}
	

	
	/*USER COMMAND*/
	public void shoot() {

		if(UCMShip.getLaser())
		{
			System.out.println("Ya hay un laser en pantalla.");
		}
		else
		{
			UCMShipLaser = new UCMShipLaser(UCMShip.getPosX(), UCMShip.getPosY());
			UCMShip.setLaser(true);
		}
	}
	
	public void shockwave() {

		for (int i = 0; i < rList.getContador(); i++)
		{
			rList.getList()[i].setResist(rList.getList()[i].getResist());

			if (rList.getList()[i].getResist() == 0)
			{
				rList.deleteRegular(rList.getList()[i].getPosX(), rList.getList()[i].getPosY());
				--i;	//tenemos que volver a comprobar de nuevo esta posicion
			}
		}
		
		for (int i = 0; i < dList.getContador(); i++)
		{	//elimino directamente porque solo tiene 1 de vida
			dList.deleteDestroyer(dList.getList()[i].getPosX(), dList.getList()[i].getPosY());
		}
		
		UCMShip.setShockwave(false);
	}
	
	public void reset(){

		setReset(true);
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

		System.out.print("[R]egular ship: Points: " + RegularShip.getPuntos() + " - Harm: 0 - Shield: " + RegularShip.getResist() + "\n");
		System.out.print("[D]estroyer ship: Points: " + DestroyerShip.getPuntos() + " - Harm: " + Bomb.getDamage() + " - Shield: " + DestroyerShip.getResist() + "\n");
		System.out.print("[O]vni: Points: " + Ovni.getPuntos() + " - Harm: 0 - Shield: " + Ovni.getResist() + "\n");
		System.out.print(UCMShip.getIcono() + ": Harm: " + UCMShipLaser.getDamage() + " - Shield: " + UCMShip.getResist() + "\n");	
	}

	public void exit() {

		System.out.println("Game Over");

		setEnd(true);
	}
	
	/*COMPUTER ACTION*/
	public void computerAction() {

		int i = 0;

		if ((ciclos % level.getSpeed()) == 0)
		{
			//Para Regular y Destroyer
			if (!sentido)
			{
				move = Move.LEFT;

				while (i < rList.getContador())
				{
					if (rList.getList()[i].getPosY() == 0)
					{
						move = Move.DOWN;
						i = rList.getContador();
					}
				}

				i = 0;

				while (i < dList.getContador())
				{
					if (dList.getList()[i].getPosY() == 0)
					{
						move = Move.DOWN;
						i = dList.getContador();
					}
				}
			}
			else
			{
				move = Move.RIGHT;

				while (i < rList.getContador())
				{
					if (rList.getList()[i].getPosY() == 8)
					{
						move = Move.DOWN;
						i = rList.getContador();
					}
				}

				i = 0;

				while (i < dList.getContador()) 
				{
					if (dList.getList()[i].getPosY() == 8)
					{
						move = Move.DOWN;
						i = dList.getContador();
					}
				}
			}

			switch(move)
			{
				case LEFT:
					moveAliensLeft();
					break;
				case RIGHT:
					moveAliensRight();
					break;
				case DOWN:
					moveAliensDown();
					break;
				default:
					break;
			}
			//Movemos el Ovni
			if (existOvni) {

				moveOvni(Ovni);
			}
		}
		//Disparar
		//double freqDisparo = new Random().nextDouble(); //pendiente
		//if (level.getShootFrec() > )
	}
	
	/*UPDATE*/
	public void update() {
		

	}
	
	public String toStringObjectAt(int i, int j) {
		String icon;
		
		return icon;
	}
	
	public void userCommand(String comando) {
		
		int foo = 0;
		String [] number = comando.split(" ");

		if ((number[0].equalsIgnoreCase("move")) || (number[0].equals("M")))
		{
			foo = Integer.parseInt(number[2]);

			if (foo > 2)
			{
				foo = 2;
			}
			else if (foo < 1)
			{
				foo = 1;
			}

			if (number[1].equals("left"))
			{
				moveShipLeft(foo);
			}
			else if (number[1].equals("right"))
			{
				moveShipRight(foo);
			}
		}
		else if ((comando.equalsIgnoreCase("shoot")) || (comando.equals("S")))
		{
			shoot();
		}
		else if ((comando.equalsIgnoreCase("shockwave")) || (comando.equals("W")))
		{
			shockwave();
		}
		else if ((comando.equalsIgnoreCase("none")) || (comando.equals("N")))
		{
			//vacio porque no hace nada
		}
		else if ((comando.equalsIgnoreCase("list")) || (comando.equals("L")))
		{
			list();
		}
		else if ((comando.equalsIgnoreCase("reset")) || (comando.equals("R")))
		{
			reset();
		}
		else if ((comando.equalsIgnoreCase("help")) || (comando.equals("H")))
		{
			help();
		}
		else if ((comando.equalsIgnoreCase("exit")) || (comando.equals("E")))
		{
			exit();
		}
		else
		{
			System.out.println("Entrada no valida.");
		}
	}
	
	public void moveOvni(Ovni ovni) {

		ovni.setPosX(ovni.getPosX() - 1);
	}
	
	public void moveAliensLeft(){
		
		for (int i = 0; i < rList.getContador(); i++)
		{
			rList.getList()[i].setPosX(rList.getList()[i].getPosX() - 1);
		}

		for (int i = 0; i < dList.getContador(); i++)
		{
			dList.getList()[i].setPosX(dList.getList()[i].getPosX() - 1);
		}
	}
	
	public void moveAliensRight() {
		
		for (int i = 0; i < rList.getContador(); i++)
		{
			rList.getList()[i].setPosX(rList.getList()[i].getPosX() + 1);
		}

		for (int i = 0; i < dList.getContador(); i++)
		{
			dList.getList()[i].setPosX(dList.getList()[i].getPosX() + 1);
		}
	}
	
	public void moveAliensDown() {
		
		for (int i = 0; i < rList.getContador(); i++)
		{
			rList.getList()[i].setPosY(rList.getList()[i].getPosY() + 1);
		}

		for (int i = 0; i < dList.getContador(); i++)
		{
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

	/*GETS y SETS*/
	
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
	
	public Boolean getReset() {

		return reset;
	}
	
	public void setReset(Boolean reset) {

		this.reset = reset;
	}
	
	public Boolean getExistOvni() {

		return existOvni;
	}
	
	public void setExistOvni(Boolean existOvni) {

		this.existOvni = existOvni;
	}

}
