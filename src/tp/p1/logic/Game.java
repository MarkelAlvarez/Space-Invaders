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
	private Boolean sentido; //false = left / true = derecha
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
	private int semilla;
	
	public Game(Level level, Random rand, int semilla) {

		this.level = level;
		this.rand = rand;
		this.semilla = semilla;
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
		
		if (UCMShip.getShockwave())
		{
			for (int i = 0; i < rList.getContador(); i++)
			{
				rList.getList()[i].setResist(rList.getList()[i].getResist() - 1);
	
				if (rList.getList()[i].getResist() == 0)
				{
					rList.deleteRegular(rList.getList()[i].getPosX(), rList.getList()[i].getPosY());
					--i; //tenemos que volver a comprobar de nuevo esta posicion
				}
			}
			
			for (i = 0; i < dList.getContador(); i++)
			{	
				dList.getList()[i].setResist(dList.getList()[i].getResist() - 1);
				
				if (dList.getList()[i].getResist() == 0)
				{
					dList.deleteDestroyer(dList.getList()[i].getPosX(), dList.getList()[i].getPosY());
					--i; //tenemos que volver a comprobar de nuevo esta posicion
				}
			}
			
			UCMShip.setShockwave(false);
		}
		
		else 
		{
			System.out.println("No hay shockwave disponible.");
		}
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
					i++;
				}

				i = 0;

				while (i < dList.getContador())
				{
					if (dList.getList()[i].getPosY() == 0)
					{
						move = Move.DOWN;
						i = dList.getContador();
					}
					i++;
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
					i++;
				}

				i = 0;

				while (i < dList.getContador()) 
				{
					if (dList.getList()[i].getPosY() == 8)
					{
						move = Move.DOWN;
						i = dList.getContador();
					}
					i++;
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
		}
		//Movemos el Ovni
		if (existOvni)
		{
			moveOvni(Ovni);
		}
		else
		{
			if(rand.nextDouble() < level.getFrecOvni())
			{
				existOvni = true;
				Ovni = new Ovni();
			}
		}
		//Disparar
		for (int j = 0; j < dList.getContador(); j++)
		{
			if((!dList.getList()[j].getBomb()) && (rand.nextDouble() < level.getShootFrec()))
			{
				bList.addBomb(dList.getList()[j].getPosX(), dList.getList()[j].getPosY(), dList.getList()[j].getId());
				dList.updateBomb(dList.getList()[j].getId(), true);
			}
		}
	}
	
	/*UPDATE*/
	public void update() {

		int i = 0, j;
		
		colisiones();
		
		while((!end) && (i < 9))
		{
			end = rList.isFound(7, i);
			i++;
		}

		i = 0;
		
		while((!end) && (i < 9))
		{
			end = dList.isFound(7, i);
			i++;
		}

		if (!end)
		{
			if  (Ovni.getPosY() < 0)
			{
				existOvni = false; 
			}

			if (UCMShip.getLaser()) 
			{
				moveLaser(UCMShipLaser);

				if (UCMShipLaser.getPosX() < 0) //Comprueba si se va a salir del tablero
				{	
					UCMShip.setLaser(false);
				}
				else 
				{
					colisiones();
				}
			}

			for (j = 0; j < bList.getContador(); j++) 
			{
				moveBomb(bList.getList()[j]);
				
				if (bList.getList()[j].getPosX() > 7) //Comprueba si se va a salir del tablero
				{
					dList.updateBomb(bList.getList()[j].getId(), false);
					bList.deleteBomb(bList.getList()[j].getPosX(), bList.getList()[j].getPosY());
				}
			}

			colisiones();
		}	
	}
	
	public void colisiones() {
		
		if (UCMShip.getLaser() && bList.deleteBomb(UCMShipLaser.getPosX(), UCMShipLaser.getPosY())) //laser con bomba 
		{
			UCMShip.setLaser(false);
		}
		
		if(bList.deleteBomb(UCMShip.getPosX(), UCMShip.getPosY())) //nave con bomba
		{
			UCMShip.setResist(UCMShip.getResist() - 1);

			if (UCMShip.getResist() == 0) 
			{
				end = true;
				UCMShip.setIcono(UCMShip.getDeath());
			}
		}
		
		if (!end)
		{
			if (UCMShip.getLaser() && dList.isFound(UCMShipLaser.getPosX(), UCMShipLaser.getPosY()))  //laser con destroyer
			{
				dList.decreaseLife(UCMShipLaser.getPosX(), UCMShipLaser.getPosY(), UCMShipLaser.getDamage());
				UCMShip.setLaser(false);

				for (int i = 0; i < dList.getContador(); i++)
				{
					if(dList.getList()[i].getResist() <= 0) //si está muerto, se suman puntos
					{
						puntuacion += DestroyerShip.getPuntos();
						dList.deleteDestroyer(UCMShipLaser.getPosX(), UCMShipLaser.getPosY());
					}
				}
			}
			
			else if(UCMShip.getLaser() && rList.isFound(UCMShipLaser.getPosX(), UCMShipLaser.getPosY())) //laser con regular
			{
				rList.decreaseLife(UCMShipLaser.getPosX(), UCMShipLaser.getPosY(), UCMShipLaser.getDamage());
				UCMShip.setLaser(false);

				for (int i = 0; i < rList.getContador(); i++) 
				{
					if(rList.getList()[i].getResist() <= 0) //si está muerto, se suman puntos
					{
						puntuacion += RegularShip.getPuntos();
						rList.deleteRegular(UCMShipLaser.getPosX(), UCMShipLaser.getPosY());
					}
				}
			}
			
			else if (UCMShip.getLaser() && existOvni) //laser con ovni
			{	
				if ((Ovni.getPosX() == UCMShipLaser.getPosX()) && (Ovni.getPosY() == UCMShipLaser.getPosY()))
				{
					Ovni.decreaseLife(UCMShipLaser.getDamage());
					UCMShip.setLaser(false);

					if(Ovni.getResist() <= 0) //si está muerto, sumo puntos
					{
						puntuacion += Ovni.getPuntos();
						existOvni = false;
					}
				}
			}
		}
	}
	
	public String toStringObjectAt(int i, int j) {

		if((UCMShip.getPosX() == i) && (UCMShip.getPosY() == j))
		{
			return UCMShip.getIcono();
		}
		else if(rList.isFound(i, j))
		{
			return rList.iconFrom(i, j);
		}
		else if(dList.isFound(i, j))
		{
			return dList.iconFrom(i, j);
		}
		else if(bList.isFound(i, j))
		{
			return Bomb.getIcono();
		}
		else if(existOvni && (Ovni.getPosX() == i) && (Ovni.getPosY() == j))
		{
			return Ovni.getIcono();
		}
		else if(UCMShip.getLaser() && (UCMShipLaser.getPosX() == i) && (UCMShipLaser.getPosY() == j))
		{
			return UCMShipLaser.getIcono();
		}		else
		{
			return "";
		}
	}
	
	public void userCommand(String comando) {
		
		int foo = 0;
		String [] number = comando.split(" ");

		if ((number[0].equalsIgnoreCase("move")) || (number[0].equals("M")))
		{
			if (number.length == 3) {
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
			else {
				System.out.println("No hay suficientes parametros.");
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
		System.out.println();
	}
	
	public void moveOvni(Ovni ovni) {

		ovni.setPosY(ovni.getPosY() - 1);
	}
	
	public void moveAliensLeft(){
		
		for (int i = 0; i < rList.getContador(); i++)
		{
			rList.getList()[i].setPosY(rList.getList()[i].getPosY() - 1);
		}

		for (int i = 0; i < dList.getContador(); i++)
		{
			dList.getList()[i].setPosY(dList.getList()[i].getPosY() - 1);
		}
	}
	
	public void moveAliensRight() {
		
		for (int i = 0; i < rList.getContador(); i++)
		{
			rList.getList()[i].setPosY(rList.getList()[i].getPosY() + 1);
		}

		for (i = 0; i < dList.getContador(); i++)
		{
			dList.getList()[i].setPosY(dList.getList()[i].getPosY() + 1);
		}
	}
	
	public void moveAliensDown() {
		
		for (int i = 0; i < rList.getContador(); i++)
		{
			rList.getList()[i].setPosX(rList.getList()[i].getPosX() + 1);
		}

		for (i = 0; i < dList.getContador(); i++)
		{
			dList.getList()[i].setPosX(dList.getList()[i].getPosX() + 1);
		}
		
		if(getSentido())
		{
			setSentido(false);
		}
		else
		{
			setSentido(true);
		}
	}
	
	public void moveShipLeft(int pasos) {
		
		UCMShip.setPosY(UCMShip.getPosY() - pasos);
	}

	public void moveShipRight (int pasos) {

		UCMShip.setPosY(UCMShip.getPosY() + pasos);
	}
	
	public void moveBomb(Bomb bomb) {

		bomb.setPosX(bomb.getPosX() + 1);		
	}
	
	public void moveLaser(UCMShipLaser laser) {

		laser.setPosX(laser.getPosX() - 1);
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
