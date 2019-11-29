package pr2.game.control.commands;

import pr2.game.Game;
import pr2.game.control.Command;
import pr2.game.control.PrinterTypes;

public class ListPrintersCommand extends Command {
	
	public ListPrintersCommand(String name, String shortcut, String details, String help) {

		super(name, shortcut, details, help);
	}

	@Override
	public boolean execute(Game game) {
		
		System.out.println(PrinterTypes.printerHelp(game));

		return false;
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