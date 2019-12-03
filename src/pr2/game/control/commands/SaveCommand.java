package pr2.game.control.commands;

import java.io.IOException;

import pr2.game.control.Command;
import pr2.game.exceptions.CommandExecuteException;
import pr2.game.exceptions.CommandParseException;
import pr2.game.logic.Game;

public class SaveCommand extends Command {
	
	String[] comando;
	String nFichero;
	
	public SaveCommand(String name, String shortcut, String details, String help) {
		
		super(name, shortcut, details, help);
		
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		
		if (comando.length == 2)
		{
			nFichero = comando[1] + ".dat";
			try {
				game.writeFile(nFichero);
				System.out.println("Game successfully saved in file " + nFichero + ". Use the load command to reload it.");
			} catch (IOException e) {
				System.out.println(e);
			}
			
		}
		else //no ha introducido el nombre del fichero
		{
			try {
				
			} catch (Exception e) {
				System.err.println("Cause of Exception: " + e);
			}
		}
		
		return false;
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