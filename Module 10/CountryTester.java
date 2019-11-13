import java.util.*;
import java.io.*;

class CountryTester {

  public static void main(String[] args) {
    ArrayList<Country> countryList = new ArrayList<Country>();
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
        lineScan.close();

        Country newCountry = new Country(countryName, primaryCompletionRate, middleCompletionRate, highCompletionRate);
        countryList.add(newCountry);
      }
    } catch (FileNotFoundException ex) {
      System.out.println(ex.getMessage());
    }

    System.out.println("There are " + countryList.size() + " countries represented in the dataset.\n");

    System.out.println("Which 5 countries have the lowest rate of primary school completion?\n");
    // USING COMPARATOR
    // Collections.sort(countryList, Country.PRIMARY_SCHOOL_COMPLETION_COMPARATOR);
    // USING LAMBDA
    Collections.sort(countryList, (c1, c2) -> Float.compare(c1.getPrimarySchoolCompletion(), c2.getPrimarySchoolCompletion()));
    printFirstFive(countryList);

  }

  public static void printFirstFive(ArrayList<Country> list) {
    for (int i = 0; i < 5 && i < list.size(); i++) {
      System.out.println(list.get(i));
    }
  }
}