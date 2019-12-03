package pr2.game.exceptions;

public class CommandParseException extends Exception {

	private static final long serialVersionUID = 2076404981021992986L;

	public CommandParseException() {
		// TODO Auto-generated constructor stub
	}

	public CommandParseException(String message) {
		super("Comando erroneo.");
		// TODO Auto-generated constructor stub
	}

	public CommandParseException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public CommandParseException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CommandParseException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
