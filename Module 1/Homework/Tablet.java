public class Tablet extends Phone {
  private boolean cellularConnectivity;

  public static final boolean DEFAULT_CONNECTIVITY = false; // WiFi only

  public Tablet(String model, double price, Screen size, StorageCapacity capacity, Phone.Color color, Authentication authentication, boolean cellularConnectivity) {
    super(model, price, size, capacity, color, authentication);
    this.cellularConnectivity = cellularConnectivity;
  }

  public Tablet(String model, double price, Screen size, StorageCapacity capacity, Phone.Color color, Authentication authentication) {
    this(model, price, size, capacity, color, authentication, DEFAULT_CONNECTIVITY);
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