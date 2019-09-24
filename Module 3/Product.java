import java.util.Comparator;

public class Product {

  private double price;

  private String name;

  private int quantity;

  private static int totalCount = 0;

  private static double totalValue = 0.0;

  public final static Comparator<Product> PRICE_COMPARATOR = new ProductPriceComparator();
  public final static Comparator<Product> NAME_COMPARATOR = new ProductNameComparator();

  private static class ProductPriceComparator implements Comparator<Product> {

    @Override
    public int compare(Product p1, Product p2) {
      return Double.compare(p1.price, p2.price);
    }
  }

  private static class ProductNameComparator implements Comparator<Product> {

    @Override
    public int compare(Product p1, Product p2) {
      return p1.name.compareToIgnoreCase(p2.name);
    }
  }

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