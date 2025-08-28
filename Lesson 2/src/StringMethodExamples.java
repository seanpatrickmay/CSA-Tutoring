public class StringMethodExamples {

  public static void main(String[] args) {
      indexOfExample();
      String myString = "Hello!";
      System.out.println(myString.substring(2));
  }

  public static void lengthExample() {
    String password = "myPassword1234";
    System.out.println("Length: " + password.length());
  }

  public static void substringExample() {
    String myString = "Hello World!";
    System.out.println("First 5 characters: " + myString.substring(0, 5));
  }
  
  public static String lastCharacterExample(String input) {
    // Write code to return the last character of the input string
    return "";
  }

  public static void indexOfExample() {
    //String exampleString = "01234A67";
    String exampleString = "01A34A67";
    int AIndex = exampleString.indexOf('A');
    System.out.println(AIndex);
  }

  public static void toUpperLowerExample() {
    String username = "GeT_RiGhT";
    System.out.println("Original: " + username);
    System.out.println("Lower: " + username.toLowerCase());
    System.out.println("Caps: " + username.toUpperCase());
  }
  
  public static void capitalizeOnlyFirst(String input) {
    // Write code to print out the input string, with only the first letter capitalized.
  }

  public static void equalsExample() {
    String answer1 = "Yes";
    String answer2 = "yes";
    System.out.println("Strict equals? " + answer1.equals(answer2));
    System.out.println("Ignore case? " + answer1.toLowerCase().equals(answer2.toLowerCase()));
  }

  public static void replaceExample() {
    String notEmotional = "Hi. Nice to meet you.";
    System.out.println(notEmotional.replace(".", "!"));
  }
  
  public static void replaceQuotationMarks() {
    String stringWithQuotes = "\"Hello, goodbye\", were my Father's words";
    // Write code to replace all the ' and " with spaces, and print it out
  }

  public static void containsExample() {
    String email = "john.doe@example.com";
    System.out.println("Email contains '@'? " + email.contains("@"));

  }
  
  public static boolean isAlphabetic(String input) {
    // Write code to determine if a given input string contains ONLY letters
    return false;
  }
}