package pr2.game.control.commands;

/*
* Juan Pablo Corella y Markel Alvarez (2ºB)
*/

import pr2.game.control.Command;
import pr2.game.exceptions.CommandExecuteException;
import pr2.game.exceptions.CommandParseException;
import pr2.game.logic.Game;
import pr2.game.logic.gameObjects.objects.Ovni;

public class ResetCommand extends Command {

	Ovni ovni;
	
	public ResetCommand(String name, String shortcut, String details, String help) {
		
		super(name, shortcut, details, help);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {

		game.reset();
		
		/*
		 * No es necesario realizar el update ya que se resetea el tablero 
		 * y no hay que actualizar los objetos.
		 */
//		if(!game.isFinished())
//		{
//			game.update();
//			/*
//			 * Estas dos llamadas están aqui para evitar que despues del update el
//			 * ciclo se ponga a 1 y para que cuando se hace el computer action no
//			 * se active el ovni. 
//			 */
//			game.setCurrentCycle(0);
//			ovni.deactivate();
//		}
		
		return true;
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