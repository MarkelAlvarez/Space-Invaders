package pr2.game.control.commands;

import pr2.game.Game;
import pr2.game.control.Command;
import pr2.game.exceptions.CommandExecuteException;
import pr2.game.exceptions.CommandParseException;

public class LoadCommand extends Command {

	String[] comando;
	
	public LoadCommand(String name, String shortcut, String details, String help) {
		
		super(name, shortcut, details, help);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {

		if (comando.length == 2)
		{
			if(comando[1].equals("supermissile") || comando[1].equals("superlaser"))
			{
				if (!game.superlaser())
				{
					System.out.println("No supermissiles avaiable\n");
				}
			}
		}
		else //no ha introducido el nombre del fichero
		{
			try {
				
			} catch (Exception e) {
				System.err.println("Cause of Exception: " + e);
			}
		}
		
		return false;
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