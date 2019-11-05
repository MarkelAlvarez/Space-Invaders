package tp.p1.control.commands;

import tp.p1.control.Command;
import tp.p1.logic.Game;

public class ResetCommand extends Command {

	public ResetCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}

	@Override
	public boolean execute(Game game) {

		game.reset();

		return true;
	}

	@Override
	public Command parse(String[] commandWords) {

		if (matchCommandName(commandWords[0]))
		{
			return this;
		}

		return null;
	}
}
