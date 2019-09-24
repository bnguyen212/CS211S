import java.util.ArrayList;

public class Homework1Tester {

	public static void main(String[] args) {
		ArrayList<AppleDevice> deviceList = new ArrayList<>();
		AppleDevice iphone1 = new Phone("iPhone 8 Plus", 999, Screen.PHONE_X, StorageCapacity.LARGE, Phone.Color.RED, Authentication.FACEID);
		((Phone) iphone1).call("Brian Nguyen");
		deviceList.add(iphone1);
		// AppleDevice watch1 = new Watch("Apple Watch 4th Gen", 400, true, "aluminum", "sport", "black");
		// System.out.println(((Watch) watch1).requestDateTime());
		// deviceList.add(watch1);
		AppleDevice ipad = new Tablet("iPad Air", 300, Screen.TABLET_AIR, StorageCapacity.SMALL, Phone.Color.BLACK, Authentication.TOUCHID, true);
		((Tablet) ipad).locate();

	}
}