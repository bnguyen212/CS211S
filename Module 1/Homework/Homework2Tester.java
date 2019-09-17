import java.util.ArrayList;
import java.util.Collections;

public class Homework2Tester {

	public static void main(String[] args) {
		ArrayList<AppleDevice> deviceList = new ArrayList<>();
    AppleDevice iphone1 = new Phone("iPhone 11 PRO MAX", 999, Screen.PHONE_MAX, StorageCapacity.LARGE, Phone.Color.RED, Authentication.FACEID);
    AppleDevice iphone2 = new Phone("iPhone 11 PRO MAX", 888, Screen.PHONE_MAX, StorageCapacity.LARGE, Phone.Color.ROSE_GOLD, Authentication.FACEID);
    AppleDevice iphone3 = new Phone("iPhone X", 588.99, Screen.PHONE_PLUS, StorageCapacity.MEDIUM, Phone.Color.GOLD, Authentication.TOUCHID);
    AppleDevice iphone4 = new Phone("iPhone X", 488.99, Screen.PHONE_PLUS, StorageCapacity.MEDIUM, Phone.Color.GOLD, Authentication.TOUCHID);
    Customer cust1 = new Customer("Brian", "Nguyen");
    Customer cust2 = new Customer("Jessica", "Masters");
    System.out.println("\n**************************** TEST STATIC METHOD\n");
    System.out.println(cust1);
    System.out.println(cust2);
    iphone1.sell(cust1);
    iphone2.sell(cust2);
    System.out.println(cust1);
    System.out.println(cust2);
    AppleDevice.getStatistics();
    System.out.println("\n**************************** BEFORE SORT\n");
    deviceList.add(iphone3);
    deviceList.add(iphone2);
    deviceList.add(iphone4);
    deviceList.add(iphone1);
    System.out.println(deviceList);
    System.out.println("\n**************************** AFTER SORT\n");
    Collections.sort(deviceList);
    System.out.println(deviceList);
	}
}