public class MethodExamples {
  public static void main(String[] args) {
    printString("Line 1");
    threeLines();
    printString("Line 2");
  }
  
  public static void printString(String toPrint) {
    System.out.println(toPrint);
  }
  
  public static void newLine() {
    System.out.println("`");
  }
  
  public static void threeLines() {
    newLine();
    newLine();
    newLine();
  }
}