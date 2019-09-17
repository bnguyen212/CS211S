
public enum Authentication {

	FACEID("Face ID"), TOUCHID("Touch ID");

	private String authentication;

	private Authentication(String authentication) {
		this.authentication = authentication;
	}

	public String getAuthentication() {
		return authentication;
	}

	@Override
	public String toString() {
		return authentication;
	}

}
