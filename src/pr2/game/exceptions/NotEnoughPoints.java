package pr2.game.exceptions;

public class NotEnoughPoints extends Exception {

	private static final long serialVersionUID = 3576653426992805524L;

	public NotEnoughPoints() {
	}

	public NotEnoughPoints(String message) {
		super(message);
	}

	public NotEnoughPoints(Throwable cause) {
		super(cause);
	}

	public NotEnoughPoints(String message, Throwable cause) {
		super(message, cause);
	}

	public NotEnoughPoints(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}