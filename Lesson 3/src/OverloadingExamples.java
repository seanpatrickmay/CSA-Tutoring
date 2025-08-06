
public class OverloadingExamples {
  public static void main(String[] args) {
    System.out.println(exponentiate(2, 5));
    
    System.out.println(exponentiate(7));
    
    System.out.println(exponentiate(2, 2, 2));
  }
  
  public static double exponentiate(int base, int power) {
    return Math.pow(base, power);
  }
  
  public static double exponentiate(int base) {
    return Math.pow(base, 2);
  }
  
  public static double exponentiate(int base, int power, int secondPower) {
    return Math.pow(Math.pow(base,  power), secondPower);
  }
  
  
  
}
