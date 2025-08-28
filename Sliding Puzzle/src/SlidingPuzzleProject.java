import java.util.*;

/**
 * AP CSA Project: Sliding Puzzle (15-puzzle / N-Puzzle)
 * -----------------------------------------------------
 * Goal: Implement a sliding puzzle you can print in the console, play manually,
 * and solve with a RECURSIVE backtracking method (no libraries).
 *
 * This file is a GUIDE and SKELETON. It lists the classes/methods you must
 * implement but intentionally does NOT include the solutions. Read the
 * TODOs. Implement one milestone at a time and test as you go.
 *
 * Rules of the game: You have an N x N board containing the numbers 1..(N*N-1)
 * and one blank (represented as 0). You may slide ONE adjacent tile into the
 * blank space (up/down/left/right), effectively moving the blank in the opposite
 * direction. The solved board has tiles in order with 0 in the last cell.
 *
 * Suggested milestones (you can reorder if you like):
 *   1) Text representation and basic Board operations
 *   2) Manual play loop (read moves from the keyboard)
 *   3) Recursive solver (backtracking/DFS) that returns a sequence of moves
 *
 * Notes:
 *  - Keep methods small and well‑named.
 *  - Add Javadoc comments for each public method you write.
 *  - Write helper methods when a step is getting long or repetitive.
 *  - Use unit-style checks in main while developing (print, assert, etc.).
 */
public class SlidingPuzzleProject {

    /** Directions the blank can move. */
    public enum Direction { UP, DOWN, LEFT, RIGHT }

    /**
     * Immutable 2D location helper.
     */
    public static final class Pos {
        public final int r, c;
        public Pos(int r, int c) { this.r = r; this.c = c; }
        @Override public String toString() { return "(" + r + "," + c + ")"; }
        @Override public boolean equals(Object o) {
            if (!(o instanceof Pos)) return false;
            Pos p = (Pos)o; return r == p.r && c == p.c;
        }
        @Override public int hashCode() { return Objects.hash(r, c); }
    }

    /**
     * Board represents an N x N grid of tiles with a single blank (0).
     *
     * Responsibilities:
     *  - Store the tiles
     *  - Report size, read a tile, find the blank
     *  - Tell whether a move is legal, and return a NEW Board after a move
     *  - Provide a text rendering (toString)
     *  - Tell whether the board is solved
     *  - Support equals/hashCode so you can store Boards in sets/maps
     */
    public static class Board {
        // Choose your representation. 2D array is fine:
        // private final int[][] tiles;
        // private final int n;

        /** Create a solved n x n board: 1..n*n-1 followed by 0 in last cell. */
        public Board(int n) {
            // TODO: initialize fields with a solved board
            throw new UnsupportedOperationException("TODO: Board(int n)");
        }

        /** Deep copy from a 2D array; assumes tiles.length == tiles[i].length. */
        public Board(int[][] tiles) {
            // TODO: copy input to your internal representation (defensive copy)
            throw new UnsupportedOperationException("TODO: Board(int[][])");
        }

        /** Optional: random solvable board (or just a shuffled-by-legal-moves board). */
        public static Board shuffled(int n, int moves, Random rng) {
            // TODO: start from solved and perform 'moves' random legal blank moves
            // (This guarantees reachability.)
            throw new UnsupportedOperationException("TODO: Board.shuffled");
        }

        /** @return board dimension n. */
        public int size() {
            // TODO
            throw new UnsupportedOperationException("TODO: size()");
        }

        /** @return value at row r, col c (0-based). */
        public int get(int r, int c) {
            // TODO
            throw new UnsupportedOperationException("TODO: get(r,c)");
        }

        /** @return the location (row,col) of the blank (tile 0). */
        public Pos findBlank() {
            // TODO
            throw new UnsupportedOperationException("TODO: findBlank()");
        }

        /** @return true if moving the blank in direction d is legal on this board. */
        public boolean canMove(Direction d) {
            // TODO: use findBlank + bounds check
            throw new UnsupportedOperationException("TODO: canMove(d)");
        }

        /**
         * @return a NEW Board that results from moving the blank in direction d.
         * Pre: canMove(d) is true.
         */
        public Board move(Direction d) {
            // TODO: swap blank with the adjacent tile and return a NEW Board
            throw new UnsupportedOperationException("TODO: move(d)");
        }

        /** @return true if tiles are in order with 0 in the last position. */
        public boolean isSolved() {
            // TODO
            throw new UnsupportedOperationException("TODO: isSolved()");
        }

        /** Provide a nicely aligned grid for console printing. */
        @Override public String toString() {
            // TODO: width based on max number of digits; represent 0 as "_" or space
            throw new UnsupportedOperationException("TODO: toString()");
        }

        /** Two boards are equal if all tiles match. */
        @Override public boolean equals(Object o) {
            // TODO: compare content (not reference)
            throw new UnsupportedOperationException("TODO: equals()");
        }

        @Override public int hashCode() {
            // TODO: hash based on contents so equal boards share a hash
            throw new UnsupportedOperationException("TODO: hashCode()");
        }
    }

    /**
     * SlidingPuzzle ties together a Board and operations like playing and solving.
     */
    public static class SlidingPuzzle {
        private Board board;

        /** Start with a solved board of given size. */
        public SlidingPuzzle(int n) {
            // TODO
            throw new UnsupportedOperationException("TODO: SlidingPuzzle(int)");
        }

        /** Start with a specific board. */
        public SlidingPuzzle(Board start) {
            // TODO
            throw new UnsupportedOperationException("TODO: SlidingPuzzle(Board)");
        }

        /**
         * Print the current board and prompt for moves until solved or user quits.
         * Valid inputs (suggestion): W=UP, A=LEFT, S=DOWN, D=RIGHT, Q=quit, H=help.
         *
         * Requirements:
         *  - Ignore illegal moves gracefully (print a message and continue)
         *  - After each legal move, print the updated board
         *  - End if solved (congratulate and show number of moves)
         */
        public void playInteractive(Scanner in) {
            // TODO: loop reading one character; map to Direction; call board.move
            // Suggestion: keep a counter of moves; print help on 'H'
            throw new UnsupportedOperationException("TODO: playInteractive");
        }

        /** @return the current board (for testing). */
        public Board getBoard() {
            return board;
        }

        // ======== RECURSIVE SOLVER SECTION ========
        // Implement a solver that uses RECURSION to search for a sequence of
        // moves from a start board to the solved board. Depth‑first search with
        // backtracking is a natural fit. You may also keep a Set of visited boards
        // to avoid cycles. Aim to return the first solution found.

        /**
         * Solve the given board recursively and return the sequence of moves.
         * If no solution is found within your limits, return an empty Optional.
         *
         * Tips (do not copy/paste—design your own):
         *  - Base case: if the board is solved, you're done.
         *  - Recursive step: try each legal move, recursively attempt to solve.
         *  - Use a Set<Board> to record states you've already explored.
         *  - Consider a maximum depth to prevent extremely deep recursion.
         */
        public static Optional<List<Direction>> solve(Board start) {
            // TODO: create visited set; call your private recursive helper
            throw new UnsupportedOperationException("TODO: solve(board)");
        }

        /** Private helper for recursion. Decide on parameters & return type. */
        private static Optional<List<Direction>> solveRec(/* parameters you need */) {
            // TODO: implement your recursive backtracking here
            throw new UnsupportedOperationException("TODO: solveRec(..)");
        }

        /** Utility: generate all legal neighbor boards from a board. */
        private static Map<Direction, Board> neighbors(Board b) {
            // TODO: for each Direction, if legal, put into map
            throw new UnsupportedOperationException("TODO: neighbors(b)");
        }
    }

    // ======== MAIN: quick manual tests as you build ========
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Sliding Puzzle — AP CSA Project");
        System.out.print("Enter board size n (e.g., 3 or 4): ");
        int n = in.nextInt();
        in.nextLine(); // consume newline

        // TODO: choose one of the following to start
        // Board b = new Board(n); // solved
        // Board b = Board.shuffled(n, /*moves=*/ 100, new Random());

        // TODO: create the game and either play or auto-solve
        // SlidingPuzzle game = new SlidingPuzzle(b);
        // game.playInteractive(in);

        // Example for the solver (after you implement it):
        // Optional<List<Direction>> solution = SlidingPuzzle.solve(b);
        // System.out.println(solution.isPresent() ? solution.get() : "No solution found");

        System.out.println("Good luck! Implement methods step by step and test often.");
    }
}
