public class GravityCalculator {
  public static void main(String[] arguments) {
    double gravity = -9.81; // Gravity, in m/s^2                              (a)
    double initialVelocity = 0.0; // Initial velocity of the object            (v_i)
    double fallingTime = 10.0; // Duration, in seconds, of the object's fall  (t)
    double initialPosition = 0.0; // Initial position of the object           (x_i)
    double finalPosition = 0.0; // Final position of the object
    
    System.out.println("The object's position after " + fallingTime
        + " seconds is " + finalPosition + " meters.");
  }
}
