import java.io.*;
import java.util.*;

public class Tester {

  public static void main(String[] args) {
    List<Animal> list = new ArrayList<>();
    Animal a1 = new Dog("Dog 1", 12, AnimalStatus.NEW);
    Animal a2 = new Dog("Dog 2", 5, AnimalStatus.SHORT_TERM);
    Animal a3 = new Dog("Dog 3", 7, AnimalStatus.LONG_TERM);
    Animal a4 = new Dog("Dog 4", 19, AnimalStatus.FORMER);
    Animal a5 = new Dog("Dog 5", 11, AnimalStatus.NEW);
    Animal a6 = new Cat("Cat 1", 2, new OutsideExerciser(), AnimalStatus.SHORT_TERM);
    Animal a7 = new Cat("Cat 2", 23, new OutsideExerciser(), AnimalStatus.LONG_TERM);
    Animal a8 = new Cat("DOG 3", 7, new InsideExerciser(), AnimalStatus.NEW);
    Animal a9 = new Cat("Cat 4", 7, new OutsideExerciser(), AnimalStatus.FORMER);
    Animal a10 = new Cat("Cat 5", 10, new InsideExerciser(), AnimalStatus.SHORT_TERM);
    System.out.println(a3.equals(a8));
    System.out.println(a1.equals(a10));
    a1.exercise();
    a9.exercise();
    list.add(a10);
    list.add(a5);
    list.add(a1);
    list.add(a9);
    list.add(a3);
    list.add(a8);
    list.add(a7);
    list.add(a6);
    list.add(a4);
    list.add(a2);
    System.out.println(list);
    Collections.sort(list);
    System.out.println(list);
    Collections.sort(list, Animal.AGE_COMPARATOR);
    System.out.println(list);
    Map<String, Animal> animap = new HashMap<>();
    for (Animal a : list) {
      animap.put(a.getName(), a);
    }
    printOlderAnimalsToFile(list, 10, "animalsMin10.txt");
    // System.out.println(countAdoptableAnimals(list));
    // System.out.println(list);
    List<String> adoptList = new ArrayList<>();
    adoptList.add(a2.getName());
    adoptList.add(a6.getName());
    adoptList.add(a10.getName());
    adoptionUpdates(animap, adoptList);
    // System.out.println(list);
  }

  public static void printOlderAnimalsToFile(List<Animal> animals, int minAge, String fileName) {
    try (PrintWriter out = new PrintWriter(new FileOutputStream(fileName))) {
      for (Animal a : animals) {
        if (a.getAge() > minAge) {
          out.println(a.getName());
        }
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public static int countAdoptableAnimals(List<Animal> animals) {
    int count = 0;
    for (Animal a : animals) {
      AnimalStatus status = a.getStatus();
      if (status.getIsAdoptable()) {
        count++;
      }
    }
    return count;
  }

  public static void adoptionUpdates(Map<String, Animal> animalMap, List<String> animalNameList) {
    for (String animalName : animalNameList) {
      Animal animal = animalMap.get(animalName);
      if (animal != null) {
        animal.adopt();
      }
    }
  }
}