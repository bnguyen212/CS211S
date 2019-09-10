public class Computer extends AppleDevice {
  private int storage; // 256, 512, 1T, 2T, 4T
  private int memory; // 8, 16, 32, 64, 128, 256
  private String processor, graphicCard;

  public Computer(String model, double price, int storage, int memory, String processor, String graphicCard) {
    super(model, price);
    this.storage = storage;
    this.memory = memory;
    this.processor = processor;
    this.graphicCard = graphicCard;
  }

}