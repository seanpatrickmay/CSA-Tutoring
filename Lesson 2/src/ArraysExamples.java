public class ArraysExamples {
  
  public static void main(String[] args) {
    
    arrayExample();
    
  }
  
  public static void arrayExample() {
    int[] values = new int[3];
    
    //System.out.println(values[2]);
    
    //Assigning the variables:
    values[0] = 1;
    values[1] = 2;
    values[2] = 3;
    //values[3] = 4;
    
    System.out.println(values[0]);
    System.out.println(values[1]);
    System.out.println(values[2]);
    //System.out.println(values[-1]);
  }
  
  public static void settingArrayFaster() {
    int[] values = new int[20];
    
    for (int i = 0; i < 20; i++) {
      values[i] = i;
    }
    
    for (int i = 0; i < 20; i++) {
      System.out.println(values[i]);
    }
  }
  
  public static void setSmallerFaster() {
    int[] smallIntArray = {5, 10, 8, 11};
    
    System.out.println(smallIntArray[3]);
  }
  
  public static void loopingThrough() {
    int[] bigArray = new int[50];
    for (int i = 0; i < 50; i++) {
      bigArray[i] = i + 1;
    }
    
    for (int i : bigArray) {
      System.out.println(i);
    }
  }
  
  // Set the values in the list to:
  // "Fizz" if index is divisible by 3
  // "Buzz" if divisible by 5
  // "FizzBuzz" if divisible by both
  // The index itself otherwise
  // Example: ["FizzBuzz", 1, 2, "Fizz", 4, "Buzz", 6, ...]
  public static void fizzBuzzList() {
    int[] fizzBuzzValues = new int[50];
    
    for (int fizzBuzz : fizzBuzzValues) {
      System.out.println(fizzBuzz);
    }
  }
  
}
