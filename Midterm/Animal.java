import java.io.*;
import java.util.*;

public abstract class Animal implements Comparable<Animal> {

    private String name;
    private int age;
    private Exercisable exercise;
    private AnimalStatus status;
    public final static Comparator<Animal> AGE_COMPARATOR = new AnimalAgeComparator();

    public Animal(String name, int age, Exercisable exercise, AnimalStatus status) {
        this.name = name;
        this.exercise = exercise;
        this.age = age;
        this.status = status;
    }

    public static class AnimalAgeComparator implements Comparator<Animal> {

        @Override
        public int compare(Animal a1, Animal a2) {
            return Integer.compare(a1.age, a2.age);
        }
    }

    public AnimalStatus getStatus() {
        return status;
    }

    public void adopt() {
        this.status = AnimalStatus.FORMER;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }
    }

    public Exercisable getExercise() {
        return exercise;
    }

    public void setExercise(Exercisable exercise) {
        this.exercise = exercise;
    }

    public void exercise() {
        exercise.exercise();
     }

    @Override
    public String toString() {
        return "\n" + name + " (Age: " + age + ")\n" + status;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            Animal otherAnimal = (Animal) obj;
            return name.equalsIgnoreCase(otherAnimal.name) && age == otherAnimal.age;
        } else {
            return false;
        }
    }

    @Override
    public int compareTo (Animal otherAnimal) {
        if (name.equals(otherAnimal.name)) {
            return Integer.compare(age, otherAnimal.age);
        } else {
            return name.compareToIgnoreCase(otherAnimal.name);
        }
    }
}
