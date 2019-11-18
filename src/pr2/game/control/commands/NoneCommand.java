package pr2.game.control.commands;

import pr2.game.Game;
import pr2.game.control.Command;

public class NoneCommand extends Command {

	public NoneCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
<<<<<<< HEAD

=======
	
>>>>>>> 6a60db94b509a22af0e2faf69b0a675225d88a54
		if(game.isFinished() == false)
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
