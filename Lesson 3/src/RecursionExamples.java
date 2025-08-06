
public class RecursionExamples {
  public static void main(String[] args) {

  }

  public static int NthFibonacciNumber(int n) {
    if (n == 0) {
      return 0;
    }
    else if (n == 1 || n == 2) {
      return 1;
    }
    else {
      return NthFibonacciNumber(n - 1) + NthFibonacciNumber(n - 2);
    }
  }
  
  public static int factorial(int n) {
    // Write code to compute the factorial of n
    return 0;
  }
  
  public static int sumOfDigits(int n) {
    // Write code to compute the sum of the digits of n
    return 0;
  }
}
