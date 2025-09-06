import java.util.Scanner;
import java.util.Random;
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
    userPlays();
  }
  
  /* -------------------------------------------------------------------------------------------------------- */
  /*             PART 2 - Copy these methods below above your main method, then implement them                */
  /* -------------------------------------------------------------------------------------------------------- */
  
  // Remember, try to test every method you implement


  
  // Just like .toString() earlier, we are again overriding the .equals() method here for the SlidingPuzzle class.
  // We need to make sure that the two sliding puzzles passed in are IDENTICAL to eachother, but we aren't able
  // to just use the pointers. Remember that a pointer just points to a location in memory.
  public boolean equals(SlidingPuzzle a, SlidingPuzzle b) {
    // Placeholder implementation, replace this
    return false;
  }

  
  // When overriding the .equals method, it is best practice to also override the .hashCode method.
  // Don't worry about implementing this, it's not necessary, but something fun to think about if you are bored.
  //
  // A hashCode is a unique integer assigned to every instance of an object.
  // Every distinct object should have its own hashCode, distinct meaning different by equality.
  // This means that two objects that are equal, defined by our own .equals() method, should have the same hashCode.
  // 
  // hashCodes are used for a data structure called a hashMap. They work by "mapping" each object to some value.
  // The hashCode is used as a unique identifier, to find where the object is stored in memory much quicker.
  // We will cover hashmaps in the future, but they aren't needed for this project
  //
  // To implement this correctly, try to find some way to make every distinct sliding puzzle have a unique integer, with no overlap.
  // In math terms, define a bijection: SlidingPuzzle -> Z (Integers)
  public int hashCode() {
    // Placeholder implementation, replace this if you want
    return 1;
  }
  

  // A method to shuffle the puzzle. There are a few valid ways to implement this.
  // Either way, you will have to use the Random class:
  // import java.util.Random; should be at the top of your file
  // You can then call Random rand = new Random();
  // rand.nextInt(bound) will then return a random integer in the range [0, bound-1]
  // Depending on your implementation, it may be interesting to think about how effective your shuffle method really is.
  private void shuffle() {
    // Implement here
  }

  
  // A helper function to determine if this puzzle is solved or not.
  // Remember, the solved configuration is the default one.
  private boolean isSolved() {
    // Placeholder implementation
    return false;
  }

  
  // A helper function for finding the puzzles connected directly by an edge to this node.
  // Returns a list of the edges, which we have said are the directions.
  private String[] getNeighboringPuzzles() {
    // Placeholder implementation
    return new String[]{"up", "down", "left", "right"};
  }

  
  // The main solve method. Returns a list of directions, which should solve this puzzle if inputted into move, in order.
  // Remember, we need a list of already visited nodes, and a list of the next nodes to visit.

  // I recommend trying to implement this without looking at pseudo-code first, but definitely use the notes if you get stuck.
  // https://web.stanford.edu/class/archive/cs/cs106x/cs106x.1192/lectures/Lecture22/Lecture22.pdf
  // This is the link to the BFS lecture notes. Slide 76 contains pseudo-code for BFS.

  // Don't get discouraged, implementing this method was very tricky for me when I was given this assignment.
  // Try to use any helper functions you've already implemented, as well.
  public String[] solve() {
    // Placeholder implementation
    return new String[]{"up", "up"};
  }

  
  // The method for prompting the user to play. It should be implemented as follows:
  //
  // Prompt the user for a board size
  // Create the board, and shuffle it
  // 
  // The following should then loop until the user solves the puzzle:
  //
  //  Print the board
  //  Ask the user for a move
  //  Move the board in that direction, if valid, else print some message to inform of invalid move.
  //
  // When solved:
  //  Print the board, then print a congratulations message
  //
  //
  // You will need the Scanner method:
  // import java.util.Scanner; should also be at the top of your file
  // Below is a very simple example of how you can use this to get user input. Try running it. You can type in your console.
  public static void userPlays() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Hi, how are you?");
    String response = scanner.nextLine();
    System.out.println("You said, \"" + response + "\"");
  }
  
}