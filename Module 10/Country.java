import java.util.Comparator;

class Country {

  private String name;
  private float primarySchoolCompletion;

  public final static Comparator<Country> PRIMARY_SCHOOL_COMPLETION_COMPARATOR = new PrimarySchoolCompletionComparator();

  private static class PrimarySchoolCompletionComparator implements Comparator<Country> {

    @Override
    public int compare(Country c1, Country c2) {
      return Float.compare(c1.primarySchoolCompletion, c2.primarySchoolCompletion);
    }
  }

  public Country(String name, float primarySchool) {
    this.name = name;
    this.primarySchoolCompletion = primarySchool;
  }

  public float getPrimarySchoolCompletion() {
    return primarySchoolCompletion;
  }

  @Override
  public String toString() {
    return name;
  }
}