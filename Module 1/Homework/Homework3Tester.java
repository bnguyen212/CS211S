import java.util.ArrayList;
import java.util.Collections;

public class Homework3Tester {

	public static void main(String[] args) {
		ArrayList<AppleDevice> deviceList = new ArrayList<>();
    AppleDevice iphone1 = new Phone("iPhone 11 PRO MAX", 1099, Screen.PHONE_MAX, StorageCapacity.DEFAULT, Phone.Color.SPACE_GRAY, Authentication.FACEID);
    AppleDevice iphone2 = new Phone("iPhone 11 PRO", 999, Screen.PHONE_X, StorageCapacity.DEFAULT, Phone.Color.GOLD, Authentication.FACEID);
    AppleDevice iphone3 = new Phone("iPhone 11", 699, Screen.PHONE_XR, StorageCapacity.DEFAULT, Phone.Color.MIDNIGHT_GREEN, Authentication.FACEID);
    AppleDevice iphone4 = new Phone("iPhone 11 PRO MAX", 1449, Screen.PHONE_MAX, StorageCapacity.LARGE, Phone.Color.GOLD, Authentication.FACEID);
    AppleDevice iphone5 = new Phone("iPhone 11 PRO", 1149, Screen.PHONE_X, StorageCapacity.MEDIUM, Phone.Color.SILVER, Authentication.FACEID);
    AppleDevice iphone6 = new Phone("iPhone 11", 749, Screen.PHONE_XR, StorageCapacity.SMALL, Phone.Color.YELLOW, Authentication.FACEID);
    AppleDevice tablet1 = new Tablet("iPad Air", 779, Screen.TABLET_AIR, StorageCapacity.MEDIUM, Phone.Color.GOLD, Authentication.TOUCHID, false);
    // M3 USING FACTORY
    AppleDevice iphone7 = AppleDeviceFactory.createBaseModel("phone");
    AppleDevice tablet2 = AppleDeviceFactory.createBaseModel("tablet");
    AppleDevice comp1 = AppleDeviceFactory.createBaseModel("computer");
    // M3 USING STRATEGY
    ((Phone) iphone1).call("Brian Nguyen");
    ((Tablet) tablet1).call("Jessica Masters");
    // M3 USING BUILDER
    AppleDevice comp2 = new Computer.ComputerBuilder("MacBook Air", 1299)
                            .memory(Memory.SMALL)
                            .storage(StorageCapacity.SSD_256)
                            .graphicCard("Intel UHD Graphics 617")
                            .processor("1.6GHz dual‑core 8th‑generation Intel Core i5")
                            .build();
    AppleDevice comp3 = new Computer.ComputerBuilder("MacBook Pro", 5149)
                            .memory(Memory.DEFAULT)
                            .storage(StorageCapacity.SSD_1T)
                            .graphicCard("Radeon Pro Vega 16 with 4GB of HBM2 memory")
                            .processor("2.4GHz 8‑core 9th‑generation Intel Core i9")
                            .build();
    deviceList.add(tablet1);
    deviceList.add(iphone1);
    deviceList.add(comp1);
    deviceList.add(iphone2);
    deviceList.add(iphone3);
    deviceList.add(iphone4);
    deviceList.add(comp2);
    deviceList.add(iphone5);
    deviceList.add(iphone6);
    deviceList.add(comp3);
    deviceList.add(tablet2);
    deviceList.add(iphone7);
    System.out.println(deviceList);
    System.out.println("\n**************************** AFTER SORT\n");
    // M3 USING COMPARATOR
    Collections.sort(deviceList, AppleDevice.PRICE_COMPARATOR);
    System.out.println(deviceList);
  }

}