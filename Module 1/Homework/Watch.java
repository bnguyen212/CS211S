import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class Watch extends AppleDevice {
  private boolean cellularConnectivity;
  private String caseMaterial; // aluminum, stainless steel
  private int caseSize; // 38 40 42 44
  private String bandType; // sport, leather, stainless steel
  private String bandColor; // pink, brown, black, white, gold, blue

  public static final boolean DEFAULT_CONNECTIVTY = false; // GPS only

  public Watch(String model, double price, boolean cellularConnectivity, String caseMaterial, int caseSize, String bandType, String bandColor) {
    super(model, price);
    this.cellularConnectivity = cellularConnectivity;
    this.caseMaterial = caseMaterial;
    this.caseSize = caseSize;
    this.bandType = bandType;
    this.bandColor = bandColor;
  }

  public Watch(String model, double price, String caseMaterial, int caseSize, String bandType, String bandColor) {
    this(model, price, DEFAULT_CONNECTIVTY, caseMaterial, caseSize, bandType, bandColor);
  }

  public boolean getCellularConnectivity() {
    return cellularConnectivity;
  }

  public String getCaseMaterial() {
    return caseMaterial;
  }

  public int getCaseSize() {
    return caseSize;
  }

  public String getBandType() {
    return bandType;
  }

  public String getBandColor() {
    return bandColor;
  }

  /*
   * Only watch band can be replaced.
   */
  public void replaceBand(String bandType, String bandColor) {
    this.bandType = bandType;
    this.bandColor = bandColor;
  }

  public Timestamp requestDateTime() {
    Date date = new Date();
    Timestamp ts = new Timestamp(date.getTime());
    return ts;
  }

  @Override
  public String toString() {
    String s = super.toString();
    s += "\nConnectivity: " + (cellularConnectivity ? "GPS + Cellular" : "GPS");
    s += "\nCase Size: " + caseSize + "mm";
    s += "\nMaterial: " + caseMaterial;
    s += "\nBand: " + bandType + " / " + bandColor;
    return s;
  }

  /*
   * Two watches are the same if they have the same model, release year, connectivity, case size & material
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Watch) {
      Watch device = (Watch) obj;
      Boolean check = super.equals(obj);
      return check && device.cellularConnectivity == cellularConnectivity
                   && device.caseMaterial == caseMaterial
                   && device.caseSize == caseSize;
    }
    return false;
  }
}