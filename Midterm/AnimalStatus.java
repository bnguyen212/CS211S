public enum AnimalStatus {
  NEW("New and being evaluated", false), SHORT_TERM("Short term resident", true), LONG_TERM("Long term resident", false), FORMER("No longer a resident / adopted", false);

  private String status;
  private boolean isAdoptable;

  private AnimalStatus(String status, boolean isAdoptable) {
      this.status = status;
      this.isAdoptable = isAdoptable;
  }

  public boolean getIsAdoptable() {
      return isAdoptable;
  }

  @Override
  public String toString() {
      return "Status: " + status;
  }
}