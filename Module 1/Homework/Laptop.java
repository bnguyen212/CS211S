public class Laptop extends Computer {
  private int batteryLife;
  private String color;
  private double displaySize;

  public Laptop(String model, double price, int storage, int memory, String processor, String graphicCard, double displaySize, int batteryLife, String color) {
    super(model, price, storage, memory, processor, graphicCard);
    this.batteryLife = batteryLife;
    this.color = color;
    this.displaySize = displaySize;
  }
}