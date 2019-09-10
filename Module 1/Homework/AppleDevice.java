import java.util.Calendar;

public abstract class AppleDevice {
  private String model;
  private double price;
  private int releaseYear;
  private String owner;

  public AppleDevice(String model, double price) {
    this.model = model;
    this.price = price;
    this.releaseYear = Calendar.getInstance().get(Calendar.YEAR);
  }

  public String getModel() {
    return model;
  }

  public void setModel(String newModel) {
    if (newModel != null && newModel.length() > 0) {
      model = newModel;
    }
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double newPrice) {
    if (newPrice > 0) {
      price = newPrice;
    }
  }

  public String getOwner() {
    return owner;
  }

  public void sell(String newOwner) {
    this.owner = newOwner;
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
      return newDevice.model == model && newDevice.releaseYear == releaseYear;
    }
    return false;
  }
}