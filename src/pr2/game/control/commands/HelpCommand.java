package pr2.game.control.commands;

/*
* Juan Pablo Corella y Markel Alvarez (2ºB)
*/

import pr2.game.Game;
import pr2.game.control.Command;
import pr2.game.control.CommandGenerator;
import pr2.game.exceptions.CommandExecuteException;
import pr2.game.exceptions.CommandParseException;

public class HelpCommand extends Command {

	public HelpCommand(String name, String shortcut, String details, String help) {

		super(name, shortcut, details, help);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {

		System.out.println(CommandGenerator.commandHelp());

		return false;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {

		if (matchCommandName(commandWords[0]))
		{
			return this;
		}

		return null;
	}
}