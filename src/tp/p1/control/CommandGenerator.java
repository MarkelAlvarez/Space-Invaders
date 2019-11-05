package tp.p1.control;

import tp.p1.control.commands.ExitCommand;
import tp.p1.control.commands.HelpCommand;
import tp.p1.control.commands.ListCommand;
import tp.p1.control.commands.MoveCommand;
import tp.p1.control.commands.ResetCommand;
import tp.p1.control.commands.ShockwaveCommand;
import tp.p1.control.commands.ShootCommand;

public class CommandGenerator {

	private static Command[] availableCommands = {
		new ListCommand("list", "L", "List", "Prints the list of available ships."),
		new HelpCommand("help", "H", "Help", "Prints this help message."),
		new ResetCommand("reset", "R", "Reset", "Starts a new game."),
		new ExitCommand("exit", "E", "Exit", "Terminates the program."),
		new ShootCommand("shoot", "S", "Shoot", "UCM-Ship launches a missile."),
		//new UpdateCommand(null, null, null, null), //WHY
		new MoveCommand("move", "M", "Move", "Moves UCM-Ship to the indicated direction."),
		new ShockwaveCommand("shockwave", "W", "Shockwave", "UCM-Ship releases a shock wave.")
	};

	public static Command parseCommand(String[ ] commandWords) {
		/*for (Command Command: availableCommands)
		{
			Command.parse(commandWords);
		}*/
		int i = 0;
		while (i < getAvailableCommands().length)
		{
			if (getAvailableCommands()[i].name.equ)
			{
				
				i = getAvailableCommands().length;
			}
		}

		return null;
	}

	public static String commandHelp() {
		return null;
	}

	public static Command[] getAvailableCommands() {
		return availableCommands;
	}

	public static void setAvailableCommands(Command[] availableCommands) {
		CommandGenerator.availableCommands = availableCommands;
	}

}
