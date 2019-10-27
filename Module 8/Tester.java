class Tester {

  public static void main(String[] args) {
    String[] array = new String[] {"Hello", "I", "Am", "Brian"};
    Integer[] array1 = new Integer[] {1,3,4,5,6,7,9,8};
    printArray(array);
    printArray(array1);
  }

  public static <T> void printArray(T[] arr) {
    for (int i = 0; i < arr.length; i+=2) {
      System.out.println(arr[i]);
    }
  }
}