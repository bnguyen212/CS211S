import java.util.Calendar;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;

public abstract class AppleDevice implements Comparable<AppleDevice> {
  private String model;
  private BigDecimal price;
  private int releaseYear;
  private String owner;

  private final static RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;
  private final static int DECIMALS = 2;

  // M2 HOMEWORK STATIC
  private static int totalCreated = 0;
  private static int totalSold = 0;

  public final static Comparator<AppleDevice> MODEL_COMPARATOR = new AppleDeviceModelComparator();

  public final static Comparator<AppleDevice> PRICE_COMPARATOR = new AppleDevicePriceComparator();

  private static class AppleDeviceModelComparator implements Comparator<AppleDevice> {

    @Override
    public int compare(AppleDevice device1, AppleDevice device2) {
      return device1.model.compareToIgnoreCase(device2.model);
    }
  }

  private static class AppleDevicePriceComparator implements Comparator<AppleDevice> {

    @Override
    public int compare(AppleDevice device1, AppleDevice device2) {
      return device1.price.compareTo(device2.price);
    }
  }

  public AppleDevice(String model, double price, int year) {
    this.model = model;
    this.price = new BigDecimal(price).setScale(DECIMALS, ROUNDING_MODE);
    this.releaseYear = year;
    AppleDevice.totalCreated += 1;
  }

  public AppleDevice(String model, double price) {
    this(model, price, Calendar.getInstance().get(Calendar.YEAR));
  }

  public String getModel() {
    return model;
  }

  public void setModel(String newModel) {
    if (newModel != null && newModel.length() > 0) {
      model = newModel;
    }
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(double newPrice) {
    if (newPrice > 0) {
      price = new BigDecimal(newPrice).setScale(DECIMALS, ROUNDING_MODE);
    }
  }

  public String getOwner() {
    return owner;
  }

  public void sell(String newOwner) {
    if (owner == null) {
      this.owner = newOwner;
//      newOwner.buyDevice(this);
      AppleDevice.totalSold += 1;
    }
  }

  // M2 HOMEWORK STATIC
  public static void getStatistics() {
    System.out.println(AppleDevice.totalCreated + " devices created.");
    System.out.println(AppleDevice.totalSold + " devices sold.");
  }

  @Override
  public String toString() {
    String str = "Device Model: " + model;
    str += "\nPrice: $" + price;
    str += "\nRelease Year: " + releaseYear;
    if (owner != null) {
      str += "\nOwner: " + owner;
    }
    return str;
  }

  /*
   * Two devices are the same if they have the same model and release year
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof AppleDevice) {
      AppleDevice newDevice = (AppleDevice) obj;
      return newDevice.model.equals(model) && newDevice.releaseYear == releaseYear;
    }
    return false;
  }

  @Override
  public int compareTo(AppleDevice otherDevice) {
    if (releaseYear != otherDevice.releaseYear) {
      return releaseYear - otherDevice.releaseYear;
    } else if (!model.equals(otherDevice.model)) {
      return model.compareToIgnoreCase(otherDevice.model);
    } else if (price.compareTo(otherDevice.price) != 0) {
      return price.compareTo(otherDevice.price);
    } else {
      return 0;
    }
  }
}