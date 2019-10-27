import java.util.ArrayList;
import java.util.Random;

class RandomBox<T> {
  private ArrayList<T> entries;

  public RandomBox() {
    entries = new ArrayList<>();
  }

  public void addEntry(T entry) {
    entries.add(entry);
  }

  public T drawWinner() {
    if (entries.size() > 0) {
      Random generator = new Random();
      int index  = generator.nextInt(entries.size());
      T winner = entries.remove(index);
      return winner;
    } else {
      return null;
    }
  }

  public int size() {
    return entries.size();
  }

  public void displayEntries() {
    System.out.println("Entries:");
    for (T entry : entries) {
      System.out.println("\t- " + entry);
    }
  }

  @Override
  public String toString() {
    String result = "There are " + entries.size() + " entries:";
    for (T entry : entries) {
      result += "\t- " + entry.toString();
    }
    return result;
  }

}