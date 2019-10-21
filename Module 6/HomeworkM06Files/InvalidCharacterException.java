
public class InvalidCharacterException extends Exception {

	private static final String MESSAGE = "Invalid ID";

	public InvalidCharacterException() {
		super(MESSAGE);
	}

	public InvalidCharacterException(String message) {
		super(MESSAGE + " " + message);
	}

}
