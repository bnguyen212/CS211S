import java.util.*;

public class FinalTester {

	public static void main(String[] args) {
    // ClassE hello = new ClassE();
    // hello.methodX();


    List<Animal> animalList = new ArrayList();
    List<Dog> dogList = new ArrayList();
    List<Bird> birdList = new ArrayList();
    methodE(animalList);
    methodE(dogList);
    methodE(birdList);
  }

  public static void methodA(List<Animal> list) {
    System.out.println("methodA");
  }

  public static void methodB(List<? extends Animal> list) {
    System.out.println("methodB");
  }

  public static void methodC(List<? super Dog> list) {
    System.out.println("methodC");
  }

  public static void methodD(List<? extends Dog> list) {
    System.out.println("methodD");
  }

  public static void methodE(List<?> list) {
    System.out.println("methodE");
  }
}