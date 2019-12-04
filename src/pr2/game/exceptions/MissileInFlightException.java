package pr2.game.exceptions;

public class MissileInFlightException extends Exception {

	private static final long serialVersionUID = 4959569708303081951L;

	public MissileInFlightException() {
	}

	public MissileInFlightException(String message) {
		super(message);
	}

	public MissileInFlightException(Throwable cause) {
		super(cause);
	}

	public MissileInFlightException(String message, Throwable cause) {
		super(message, cause);
	}

	public MissileInFlightException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}