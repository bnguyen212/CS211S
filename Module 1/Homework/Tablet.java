public class Tablet extends Phone {
  private boolean cellularConnectivity;

  public static final boolean DEFAULT_CONNECTIVITY = false; // WiFi only

  /*
   * Screen Sizes:
   * iPad Mini 7.9
   * iPad 9.7
   * iPad Air 10.5
   * iPad Pro 11
   * iPad Pro 12.9
   * Colors: silver, space gray, gold
   */

  public Tablet(String model, double price, double screenSize, int storageCapacity, String color, String authentication, boolean cellularConnectivity) {
    super(model, price, screenSize, storageCapacity, color, authentication);
    this.cellularConnectivity = cellularConnectivity;
  }

  public Tablet(String model, double price, double screenSize, int storageCapacity, String color, String authentication) {
    this(model, price, screenSize, storageCapacity, color, authentication, DEFAULT_CONNECTIVITY);
  }

  public boolean getCellularConnectivity() {
    return cellularConnectivity;
  }

  public void locate() {
    System.out.println("Your tablet was last seen online in Berkeley, CA.");
  }

  @Override
  public String toString() {
    String s = super.toString();
    s += "\nCellular Connectivity: " + cellularConnectivity;
    return s;
  }

  /*
   * Two tablets are the same if they have the same model, release year, screen size, storage capacity, color, security method, and cellular capability.
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Tablet) {
      Tablet device = (Tablet) obj;
      return super.equals(obj) && device.cellularConnectivity == cellularConnectivity;
    }
    return false;
  }
}