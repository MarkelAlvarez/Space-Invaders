package pr2.game.control.commands;

import pr2.game.Game;
import pr2.game.control.Command;
import pr2.game.control.PrinterTypes;
import pr2.game.logic.GamePrinter;
import pr2.game.logic.Stringifier;

public class StringifyCommand extends Command {
	
	public StringifyCommand(String name, String shortcut, String details, String help) {

		super(name, shortcut, details, help);
	}

	@Override
	public boolean execute(Game game) {
		
		GamePrinter printer = PrinterTypes.STRINGIFIER.getObject();
		
		System.out.println(printer.toString(game));

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