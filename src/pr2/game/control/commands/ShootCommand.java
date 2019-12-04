package pr2.game.control.commands;

import pr2.game.control.Command;
import pr2.game.exceptions.CommandExecuteException;
import pr2.game.exceptions.CommandParseException;
import pr2.game.exceptions.MissileInFlightException;
import pr2.game.exceptions.NotEnoughPoints;
import pr2.game.logic.Game;

public class ShootCommand extends Command {

	private String[] comando;
	
	public ShootCommand(String name, String shortcut, String details, String help) {
		
		super(name, shortcut, details, help);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {

		if (comando.length == 2)
		{
			if(comando[1].equals("supermissile") || comando[1].equals("superlaser"))
			{
				try {
					game.superlaser();
				} catch (NotEnoughPoints e) {
					 throw new CommandExecuteException(e.getMessage());
				}
			}
		}
		else
		{
			try {
				game.shootLaser();
			} catch (MissileInFlightException e) {
				throw new CommandExecuteException(e.getMessage());
			}
		}
		
		if(!game.isFinished())
		{
			game.update();
		}
		
		return true;
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