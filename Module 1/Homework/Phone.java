public class Phone extends AppleDevice {
  private double screenSize;
  private int storageCapacity; // 64, 128, 256, 512, 1024
  private String color; // Silver, Space Gray, Gold, Rose Gold, Black, Blue, White, Yellow, Red
  private String authentication; // Face ID, Touch ID

  public static final int DEFAULT_CAPACITY = 64;

  /*
   * Screen Sizes
   * XS Max 6.5 Face ID
   * XS X 5.8 Face ID
   * XR 6.1 Face ID
   * 8+ 7+ 6S+ 6+ 5.5 Touch ID
   * 8 7 6S 6 4.7 Touch ID
   * SE 4 Touch ID
   * Colors: silver, space gray, gold // blue white black yellow coral red // rose gold (6S SE 7)
   */

  public Phone(String model, double price, double screenSize, int storageCapacity, String color, String authentication) {
    super(model, price);
    this.screenSize = screenSize;
    this.storageCapacity = storageCapacity;
    this.color = color;
    this.authentication = authentication;
  }

  public Phone(String model, double price, double screenSize, String color, String authentication) {
    this(model, price, screenSize, DEFAULT_CAPACITY, color, authentication);
  }

  /*
   * No setter methods as screen size, color, storage capacity, and authentication are not modifiable.
   */

  public int getStorageCapacity() {
    return storageCapacity;
  }

  public String getColor() {
    return color;
  }

  public double getScreenSize() {
    return screenSize;
  }

  public String getAuthentication() {
    return authentication;
  }

  public void call(String contactName) {
    System.out.println("Calling " + contactName + "...");
  }

  @Override
  public String toString() {
    String s = super.toString();
    s += "\nScreen: " + screenSize + "\"";
    s += "\nColor: " + color;
    s += "\nCapacity: " + storageCapacity + "GB";
    s += "\nAuthentication: " + authentication;
    return s;
  }

  /*
   * Two handheld devices are the same if they have the same model, release year, screen size, storage capacity, color, and authentication method
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Phone) {
      Phone device = (Phone) obj;
      Boolean check = super.equals(obj);
      return check && device.screenSize == screenSize
                   && device.storageCapacity == storageCapacity
                   && device.color == color
                   && device.authentication == authentication;
    }
    return false;
  }

}