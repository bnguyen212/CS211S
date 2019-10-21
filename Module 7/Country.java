import java.util.Comparator;

class Country implements Comparable<Country> {

  private String name;
  private float primarySchoolCompletion, middleSchoolCompletion, highSchoolCompletion;
  private static float maxPercentage = 100, minPercentage = 0;

  public final static Comparator<Country> PRIMARY_SCHOOL_COMPLETION_COMPARATOR = new PrimarySchoolCompletionComparator();

  public final static Comparator<Country> MIDDLE_SCHOOL_COMPLETION_COMPARATOR = new MiddleSchoolCompletionComparator();

  public final static Comparator<Country> HIGH_SCHOOL_COMPLETION_COMPARATOR = new HighSchoolCompletionComparator();

  public final static Comparator<Country> PRIMARY_MIDDLE_CONSISTENCY_COMPARATOR = new PrimaryMiddleConsistencyComparator();

  public final static Comparator<Country> MIDDLE_HIGH_CONSISTENCY_COMPARATOR = new MiddleHighConsistencyComparator();

  private static class PrimarySchoolCompletionComparator implements Comparator<Country> {

    @Override
    public int compare(Country c1, Country c2) {
      return Float.compare(c1.primarySchoolCompletion, c2.primarySchoolCompletion);
    }
  }

  private static class MiddleSchoolCompletionComparator implements Comparator<Country> {

    @Override
    public int compare(Country c1, Country c2) {
      return Float.compare(c1.middleSchoolCompletion, c2.middleSchoolCompletion);
    }
  }

  private static class HighSchoolCompletionComparator implements Comparator<Country> {

    @Override
    public int compare(Country c1, Country c2) {
      return Float.compare(c1.highSchoolCompletion, c2.highSchoolCompletion);
    }
  }

  private static class PrimaryMiddleConsistencyComparator implements Comparator<Country> {

    @Override
    public int compare(Country c1, Country c2) {
      float c1Difference = c1.primarySchoolCompletion - c1.middleSchoolCompletion;
      float c2Difference = c2.primarySchoolCompletion - c2.middleSchoolCompletion;
      return Float.compare(c1Difference, c2Difference);
    }
  }

  private static class MiddleHighConsistencyComparator implements Comparator<Country> {

    @Override
    public int compare(Country c1, Country c2) {
      float c1Difference = c1.middleSchoolCompletion - c1.highSchoolCompletion;
      float c2Difference = c2.middleSchoolCompletion - c2.highSchoolCompletion;;
      return Float.compare(c1Difference, c2Difference);
    }
  }

  public Country(String name, float primarySchool, float middleSchool, float highSchool) {
    checkValidPercentage(primarySchool);
    checkValidPercentage(middleSchool);
    checkValidPercentage(highSchool);
    this.name = name;
    this.primarySchoolCompletion = primarySchool;
    this.middleSchoolCompletion = middleSchool;
    this.highSchoolCompletion = highSchool;
  }

  public String getName() {
    return name;
  }

  public void setName(String newName) {
    this.name = newName;
  }

  public float getPrimarySchoolCompletion() {
    return primarySchoolCompletion;
  }

  public void setPrimarySchoolCompletion(float newRate) {
    checkValidPercentage(newRate);
    this.primarySchoolCompletion = newRate;
  }

  public float getMiddleSchoolCompletion() {
    return middleSchoolCompletion;
  }

  public void setMiddleSchoolCompletion(float newRate) {
    checkValidPercentage(newRate);
    this.middleSchoolCompletion = newRate;
  }

  public float getHighSchoolCompletion() {
    return highSchoolCompletion;
  }

  public void setHighSchoolCompletion(float newRate) {
    checkValidPercentage(newRate);
    this.highSchoolCompletion = newRate;
  }

  @Override
  public String toString() {
    String result = "Country: " + this.name;
    result += "\nCompletion Rates: ";
    result += "\n\t- Primary School: " + this.primarySchoolCompletion + "%";
    result += "\n\t- Middle School: " + this.middleSchoolCompletion + "%";
    result += "\n\t- High School: " + this.highSchoolCompletion + "%\n";
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Country) {
      Country newCountry = (Country) obj;
      return this.name.equals(newCountry.name);
    }
    return false;
  }

  @Override
  public int compareTo(Country otherCountry) {
    int compareName = this.name.compareTo(otherCountry.name);
    int comparePrimary = Float.compare(this.primarySchoolCompletion, otherCountry.primarySchoolCompletion);
    int compareMiddle = Float.compare(this.middleSchoolCompletion, otherCountry.middleSchoolCompletion);
    int compareHigh = Float.compare(this.highSchoolCompletion, otherCountry.highSchoolCompletion);
    if (compareName != 0) {
      return compareName;
    } else if (comparePrimary != 0) {
      return comparePrimary;
    } else if (compareMiddle != 0) {
      return compareMiddle;
    } else if (compareHigh != 0) {
      return compareHigh;
    } else {
      return 0;
    }
  }

  private static void checkValidPercentage(float percentage) {
    if (Float.compare(percentage, minPercentage) < 0 ||
        Float.compare(percentage, maxPercentage) > 0) {
      throw new Error("Invalid percentage.");
    }
  }
}