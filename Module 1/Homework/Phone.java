public class Phone extends AppleDevice {
  // M2 HOMEWORK ENUM
  private Screen screenSize;
  private StorageCapacity storageCapacity;
  private Color color;
  private Authentication authentication;
  private Caller caller;

  public static final int DEFAULT_CAPACITY = 64;

  // M2 HOMEWORK ENUM
  public enum Color { SILVER, SPACE_GRAY, GOLD, MIDNIGHT_GREEN, ROSE_GOLD, BLACK, BLUE, WHITE, YELLOW, RED}

  public Phone(String model, double price, Screen size, StorageCapacity capacity, Color color, Authentication auth, Caller caller) {
    super(model, price);
    this.screenSize = size;
    this.storageCapacity = capacity;
    this.color = color;
    this.authentication = auth;
    this.caller = caller;
  }

  public Phone(String model, double price, Screen size, StorageCapacity capacity, Color color, Authentication auth) {
    this(model, price, size, capacity, color, auth, new CellularCaller());
  }

  /*
   * No setter methods as screen size, color, storage capacity, and authentication are not modifiable.
   */

  public StorageCapacity getStorageCapacity() {
    return storageCapacity;
  }

  public Color getColor() {
    return color;
  }

  public Screen getScreenSize() {
    return screenSize;
  }

  public Authentication getAuthentication() {
    return authentication;
  }

  public void call(String contactName) {
    caller.call(contactName);
  }

  @Override
  public String toString() {
    String s = super.toString();
    s += "\nScreen: " + screenSize;
    s += "\nColor: " + color;
    s += "\nCapacity: " + storageCapacity;
    s += "\nAuthentication: " + authentication;
    return s;
  }

  /*
   * Two phones are the considered equal if they have the same model, release year, screen size, storage capacity, and authentication method
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Phone) {
      Phone device = (Phone) obj;
      Boolean check = super.equals(obj);
      return check && device.screenSize.equals(screenSize)
                   && device.storageCapacity.equals(storageCapacity)
                   && device.authentication.equals(authentication);
    }
    return false;
  }

}