/*
Class to represent a sliding puzzle.
The specification for a sliding puzzle is:
An MxN grid of pieces, with one missing.
The default configuration is the pieces in order, with top left missing.
Ex: 3x3: _ 1 2
         3 4 5
         6 7 8

At any point in time, there are a certain number of moves you can make.
You can slide the puzzle up, down, left, or right.
However, some of these may not be available. For example, from the starting position,
you are unable to slide right, or down.

By slide, I mean move a piece adjacent to the blank into the blank space.
For example, sliding left from the starting 3x3 position gives us:

1 _ 2
3 4 5
6 7 8

The point of this assignment is to create:
1.) An interface for a human user to interact with the puzzle, and solve it

2.) An algorithm that, given a puzzle, will generate a sequence of moves to solve it

*/


class SlidingPuzzle {
  // What variables do you think are needed to represent a sliding puzzle?
  // Declare them here.
  
  
  // The constructor. Currently, this constructor should create a new sliding puzzle, with the default configuration.
  // Decide what you want to use to represent the blank space. There are many valid answers.
  public SlidingPuzzle(int m, int n) {
    
  }
  
  // Overriding the toString method. This enables us to call System.out.println(myPuzzle), and print it nicely
  // You can decide exactly how the string representation should look like.
  public String toString() {
    // Placeholder
    return "";
  }
  
  // This method should return the x and y coordinate of the missing piece.
  private int[] missingCoordinates() {
    return new int[]{0, 0};
  }
  
  // This method should return true if the given direction is valid to move.
  // Like described above, only left and up are valid for the starting position.
  // Think about what helper functions you may need to complete this. Have we made any already?
  private boolean canMove(String direction) {
    // Placeholder
    return false;
  }
  
  // This method should modify this sliding puzzle, changing it according to the move.
  // Can you use some of the methods we have already created to implement this?
  private void move(String direction) {
    // Remember the "this" keyword is used to access instance variables
    // For example, if we have an object "Cat" with instance variable "name",
    // we can say Cat.name to access whatever name we assigned to it.
    // However, if we are writing a function inside the Cat class, we would call this.name to access.
  }
  
  // Remember how we said that non-primitive objects can be modified.
  // We need a way to create a  "deep" copy of our object, to avoid modifying it in future method calls.
  public SlidingPuzzle copy() {
    // Replace this implementation.
    return this;
  }
  
  public static void main(String[] args) {
    // Use this main method to debug.
  }
  
  
}