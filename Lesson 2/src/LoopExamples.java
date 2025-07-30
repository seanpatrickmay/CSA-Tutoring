public class LoopExamples {
  
  public static void main(String[] args) {
    printOrderedPairs(10, 10);
  }

  // WHILE LOOPS:
  
  public static void exampleWhileLoopMethod(int iterations) {
    int counter = 0;
    while (counter < iterations) {
      counter = counter + 1;
      System.out.println("Loop iteration number " + counter);
    }
  }
  
  public static void printStringXTimes(String string, int numTimes) {
    while (numTimes > 0) {
      System.out.println(string);
      numTimes = numTimes - 1;
    }
  }
  
  // Method that prints every other number up to iterations, starting at 0
  public static void printEveryOther(int iterations) {
    
  }
  
  // Find the error
  public static void flawedWhileLoopMethod(int iterations) {
    while (iterations != 0) {
      System.out.println("Running flawed while loop method iteration " + iterations);
      iterations = iterations - 2;
    }
  }
  
  
  // FOR LOOPS:
  
  public static void exampleForLoopMethod(int iterations) {
    for (int i = 0; i < iterations; i++) {
      System.out.println("Iteration number " + i);
    }
  }
  
  // Better way to do this?
  public static void printDivisibleInRange(int divisor, int max) {
    for (int i = 0; i < max; i++) {
      if (i % divisor == 0) {
        System.out.println(i);
      }
    }
  }
  
  public static int nthFibonacciNumber(int n) {
    int last = 0;
    int secondToLast = 1;
    int current = 0;
    for (int i = 0; i < n; i++) {
        // Fill in the loop
      
      
    }
    return current;
  }
  
  // Method that prints all ordered pairs (0, 0), (0, 1) (1, 0), ... (xmax, ymax)
  public static void printOrderedPairs(int xmax, int ymax) {
    
  }
}