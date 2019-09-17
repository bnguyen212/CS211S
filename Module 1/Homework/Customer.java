import java.util.ArrayList;

public class Customer {
  private String firstName, lastName;
  private ArrayList<AppleDevice> devices;

  public Customer(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.devices = new ArrayList<AppleDevice>();
  }

  public void setFirstName(String newFName) {
    if (newFName != null && newFName.length() > 0) {
      this.firstName = newFName;
    }
  }

  public void setLastName(String newLName) {
    if (newLName != null && newLName.length() > 0) {
      this.firstName = newLName;
    }
  }

  public String getFullName() {
    return this.firstName + " " + this.lastName;
  }

  public void buyDevice(AppleDevice device) {
    this.devices.add(device);
  }

  @Override
  public String toString() {
    return "Customer " + getFullName() + " owns " + devices.size() + " Apple devices!";
  }
}