public final class Worker {
  private final String name;
  private final int id;
  private final Manager boss;

  public Worker(String name, int id, Manager boss) {
    this.name = name;
    this.id = id;
    this.boss = new Manager(boss.getName(), boss.getSalary());
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public Manager getBoss() {
    return new Manager(boss.getName(), boss.getSalary());
  }
}