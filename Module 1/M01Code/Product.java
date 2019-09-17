public class Product {
  private double price;
  private String name;
  private int quantity;

  private static int totalCount = 0;
  private static double totalValue = 0.0;

  public Product(String name, double price, int quantity) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
    Product.totalCount += quantity;
    Product.totalValue += quantity * price;
  }

  public double getPrice() {
    return price;
  }

  public void sell(int count) {
    quantity -= count;
    Product.totalCount -= count;
    Product.totalValue -= price * count;
  }

  public static int getTotalCount() {
    return Product.totalCount;
  }

  public static double getTotalValue() {
    return Product.totalValue;
  }

  // cart is an array of products
  public static double getTotal(Product[] cart) {
    double total = 0.0;
    for (Product a : cart) {
      total += a.getPrice();
    }
    return total;
  }
}