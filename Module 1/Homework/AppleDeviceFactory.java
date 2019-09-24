
public class AppleDeviceFactory {

  public static AppleDevice createBaseModel(String type) {
    switch(type) {
      case "phone":
        return new Phone("iPhone 11", 699, Screen.PHONE_XR, StorageCapacity.DEFAULT, Phone.Color.BLACK, Authentication.FACEID);
      case "tablet":
        return new Tablet("iPad", 779, Screen.TABLET_REGULAR, StorageCapacity.DEFAULT, Phone.Color.SPACE_GRAY, Authentication.TOUCHID, false);
      case "computer":
        return new Computer.ComputerBuilder("MacBook Air", 1099)
                            .memory(Memory.SMALL)
                            .storage(StorageCapacity.SSD_128)
                            .graphicCard("Intel UHD Graphics 617")
                            .processor("1.6GHz dual-core 8th-generation Intel Core i5")
                            .build();
      default:
        throw new IllegalArgumentException();
    }
  }
}