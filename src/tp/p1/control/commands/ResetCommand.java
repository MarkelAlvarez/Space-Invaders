package tp.p1.control.commands;

import tp.p1.control.Command;
import tp.p1.logic.Game;

public class ResetCommand extends Command {

	public ResetCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {

		if (matchCommandName(name))
		{
			
		}
		
		return null;
	}

}