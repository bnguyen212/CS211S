public class Computer extends AppleDevice {
  private StorageCapacity storage;
  private Memory memory; // 8, 16, 32, 64, 128, 256
  private String processor, graphicCard;

  private Computer(ComputerBuilder builder) {
    super(builder.model, builder.price);
    this.storage = builder.storage;
    this.memory = builder.memory;
    this.processor = builder.processor;
    this.graphicCard = builder.graphicCard;
  }

  public static class ComputerBuilder {
    private StorageCapacity storage;
    private Memory memory;
    private double price;
    private String model, processor, graphicCard;

    public ComputerBuilder(String model, double price) {
      this.model = model;
      this.price = price;
    }
    public ComputerBuilder() {

    }
    public ComputerBuilder model(String var) {
      this.model = var;
      return this;
    }
    public ComputerBuilder price(double var) {
      this.price = var;
      return this;
    }
    public ComputerBuilder memory(Memory var) {
      this.memory = var;
      return this;
    }
    public ComputerBuilder storage(StorageCapacity var) {
      this.storage = var;
      return this;
    }
    public ComputerBuilder graphicCard(String var) {
      this.graphicCard = var;
      return this;
    }
    public ComputerBuilder processor(String var) {
      this.processor = var;
      return this;
    }
    public Computer build() {
      if (memory == null || storage == null || processor == null || graphicCard == null) {
        throw new IllegalStateException();
      } else {
        return new Computer(this);
      }
    }

  }

  @Override
  public String toString() {
    String s = super.toString();
    s += "\nProcessor: " + processor;
    s += "\nGraphic Card: " + graphicCard;
    s += "\nStorage: " + storage;
    s += "\nMemory: " + memory;
    return s;
  }

}