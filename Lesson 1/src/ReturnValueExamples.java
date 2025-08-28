public class ReturnValueExamples {
  public static void main(String[] args) {
    
    System.out.println(one());
    
    System.out.println(square(8));
    
    System.out.println(appendStrings("apples", "bananas"));
  }
  
  public static int one() {
    String myString = "Hello";
    return 1;
  }
  
  public static int square(int number) {
    return number * number;
  }
  
  public static String appendStrings(String firstString, String secondString) {
    return firstString + secondString;
  }
}
