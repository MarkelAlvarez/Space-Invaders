package pr2.game.control;

import pr2.game.Game;
import pr2.game.logic.BoardPrinter;
import pr2.game.logic.GamePrinter;
import pr2.game.logic.Stringifier;

public enum PrinterTypes {
	
	//TODO: llamada a la constructora
	BOARDPRINTER("boardprinter", "prints the game formatted as a board of dimension: ", new BoardPrinter()),
	STRINGIFIER("stringifier", "prints the game as plain text", new Stringifier());
	
	private String printerName;
	private String helpText;
	private GamePrinter printerObject;
	
	private PrinterTypes(String name, String text, GamePrinter printer) {
		
		printerName = name;
		helpText = text;
		printerObject = printer;
	}
	
	public static String printerHelp(Game game) {
		
		String helpString = "";
		
		for (PrinterTypes printer : PrinterTypes.values())
		{
			helpString += String.format(" %s : %s %s %n", printer.printerName, printer.helpText, (printer == BOARDPRINTER ? Game.DIM_X + " x " + Game.DIM_Y : "") );
		}
		
		return helpString;
	}
	
	// Assumes a max of one object of each printer type is needed (otherwise return copy)
	public GamePrinter getObject() {
			
		return printerObject;
	}
}