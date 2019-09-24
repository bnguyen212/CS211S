
public enum Screen {

	PHONE_MAX (6.5), PHONE_XR(6.1), PHONE_X (5.8), PHONE_PLUS (5.5), PHONE_REGULAR (4.7), TABLET_MINI(7.9), TABLET_REGULAR(10.2), TABLET_AIR(10.5), TABLET_PRO(11), TABLET_PRO_PLUS(12.9);

	private double size;

	private Screen(double size) {
		this.size = size;
	}

	public double getSize() {
		return size;
	}

	@Override
	public String toString() {
		return size + "\"";
	}

}
