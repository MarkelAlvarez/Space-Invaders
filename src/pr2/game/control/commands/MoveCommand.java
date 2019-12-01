package pr2.game.control.commands;

/*
* Juan Pablo Corella y Markel Alvarez (2ºB)
*/

import pr2.game.Game;
import pr2.game.control.Command;
import pr2.game.exceptions.CommandExecuteException;
import pr2.game.exceptions.CommandParseException;

public class MoveCommand extends Command {
	
	private String[] comando;
	
	public MoveCommand(String name, String shortcut, String details, String help) {
	
		super(name, shortcut, details, help);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		
		int foo = 0; //inicializado por el try
		boolean ret = false;
		
		if (comando.length == 3)
		{
			/*Convierte el numero leido en un 'int'*/
			try {
				foo = Integer.parseInt(comando[2]);
			} catch (NumberFormatException e) {
				System.err.println(e);
			}
			/*Filtra los numeros para que tengan el rango adecuado*/
			if (foo > 2)
			{
				foo = 2;
			}
			else if (foo < 1)
			{
				foo = 1;
			}
			/*Se mueve la nave segun lo que haya pedido el usuario*/
			if (comando[1].equals("left"))
			{
				ret = game.move(foo * (-1)); //le paso el numero en negativo para que se reste
			}
			else if (comando[1].equals("right"))
			{
				ret = game.move(foo);
			}
		}
		else
		{
			throw new CommandExecuteException("Wrong parameters were entered.");
		}
		
		if(!game.isFinished())
		{
			game.update();
		}
		
		return ret;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {

		if (matchCommandName(commandWords[0]))
		{
			comando = commandWords;
			return this;
		}

		return null;
	}
}