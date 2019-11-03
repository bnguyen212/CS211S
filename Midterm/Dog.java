public class Dog extends Animal {

  public Dog(String name, int age, AnimalStatus status) {
    super(name, age, new InsideExerciser(), status);
  }
}