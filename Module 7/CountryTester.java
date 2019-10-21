import java.util.*;
import java.io.*;

class CountryTester {

  public static void main(String[] args) {
    ArrayList<Country> countryList = new ArrayList<Country>();
    Map<String, Country> countryMap = new HashMap<String, Country>();
    File file = new File("education.csv");
    try (Scanner fileScan = new Scanner(file)) {
      // skip first line
      fileScan.nextLine();
      while (fileScan.hasNext()) {
        String line = fileScan.nextLine();
        Scanner lineScan = new Scanner(line);
        lineScan.useDelimiter(",");

        String countryName = lineScan.next();
        Float primaryCompletionRate = Float.parseFloat(lineScan.next());
        Float middleCompletionRate = Float.parseFloat(lineScan.next());
        Float highCompletionRate = Float.parseFloat(lineScan.next());
        lineScan.close();

        Country newCountry = new Country(countryName, primaryCompletionRate, middleCompletionRate, highCompletionRate);
        countryList.add(newCountry);
        countryMap.put(countryName, newCountry);
      }
    } catch (FileNotFoundException ex) {
      System.out.println(ex.getMessage());
    }

    System.out.println("There are " + countryMap.keySet().size() + " countries represented in the dataset.\n");

    System.out.println("There are " + countryList.size() + " countries represented in the dataset.\n");

    System.out.println("Which 5 countries have the lowest rate of primary school completion?\n");
    Collections.sort(countryList, Country.PRIMARY_SCHOOL_COMPLETION_COMPARATOR);
    printFirstFive(countryList);

    System.out.println("Which 5 countries have the lowest rate of middle school completion?\n");
    Collections.sort(countryList, Country.MIDDLE_SCHOOL_COMPLETION_COMPARATOR);
    printFirstFive(countryList);

    System.out.println("Which 5 countries have the lowest rate of high school completion?\n");
    Collections.sort(countryList, Country.HIGH_SCHOOL_COMPLETION_COMPARATOR);
    printFirstFive(countryList);

    System.out.println("Which 5 countries have the highest drop in completion rate between primary school and middle school?\n");
    Collections.sort(countryList, Collections.reverseOrder(Country.PRIMARY_MIDDLE_CONSISTENCY_COMPARATOR));
    printFirstFive(countryList);

    System.out.println("Which 5 countries have the highest drop in completion rate between middle school and high school?\n");
    Collections.sort(countryList, Collections.reverseOrder(Country.MIDDLE_HIGH_CONSISTENCY_COMPARATOR));
    printFirstFive(countryList);
  }

  public static void printFirstFive(ArrayList<Country> list) {
    for (int i = 0; i < 5 && i < list.size(); i++) {
      System.out.println(list.get(i));
    }
  }
}