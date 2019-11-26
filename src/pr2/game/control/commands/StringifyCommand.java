package pr2.game.control.commands;

import pr2.game.Game;
import pr2.game.control.Command;

public class StringifyCommand extends Command {

	public StringifyCommand(String name, String shortcut, String details, String help) {

		super(name, shortcut, details, help);
	}

	@Override
	public boolean execute(Game game) {

		game.stringifier();
		
		if(!game.isFinished())
		{
			game.update();
		}

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