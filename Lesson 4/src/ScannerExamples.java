/**
 * ScannerSystemInExamples.java
 * ------------------------------------------------------------
 * This file focuses ONLY on examples that use System.in with java.util.Scanner.
 * Each example has a short explanation in comments.
 *
 * How to use:
 *   1) Compile:  javac ScannerSystemInExamples.java
 *   2) Run:      java ScannerSystemInExamples
 *   3) Uncomment ONE example call in main() at a time (they are interactive).
 *
 * IMPORTANT: We do NOT close the Scanner on System.in on purpose.
 * Closing it would also close the underlying input stream for the JVM.
 */

import java.util.*;

public class ScannerExamples {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // do not close
        System.out.println("=== System.in + Scanner examples ===\n");

        // Uncomment ONE at a time to try:
         example1_BasicTokens(in);
        // example2_NextIntThenNextLine(in);
        // example3_MenuLoop(in);
        // example4_SafeReadIntHelperDemo(in);
        // example5_ReadUntilEOF(in);
        // example6_CustomDelimiterCSVFromKeyboard(in);
        // example7_ReadNumbersUntilBlankLine(in);

    }

    // ---------------------------------------------------------------------
    // Example 1: Basic token reading from System.in using nextInt/next/nextDouble
    // ---------------------------------------------------------------------
    // Explanation:
    // Scanner splits input into *tokens* using whitespace (spaces/newlines) by default.
    // nextInt(), next(), nextDouble() each read the *next token* of a specific type.
    // Type a value, press Enter; or type values separated by spaces.
    private static void example1_BasicTokens(Scanner in) {
        System.out.println("Enter three tokens: an int, a word, and a double (e.g., 42 hello 3.14)");
        System.out.print("> ");
        int n = in.nextInt();       // reads the next integer token
        String word = in.next();    // reads the next text token (no spaces)
        double x = in.nextDouble(); // reads the next floating-point token
        System.out.printf("You entered → n=%d, word=%s, x=%.3f\n", n, word, x);
    }

    // ---------------------------------------------------------------------
    // Example 2: The "newline trap" when mixing nextInt/nextDouble with nextLine
    // ---------------------------------------------------------------------
    // Explanation:
    // nextInt() leaves the end-of-line (the "\n") pending in the buffer. If you
    // immediately call nextLine(), it will read that leftover empty line.
    // FIX: call an extra nextLine() once to consume the rest of the current line
    // before reading a full line.
    private static void example2_NextIntThenNextLine(Scanner in) {
        System.out.print("Enter your age (int), then press Enter: ");
        int age = in.nextInt();  // reads the number, but leaves the newline pending
        in.nextLine();           // consume the end-of-line
        System.out.print("Enter your full name (may include spaces): ");
        String fullName = in.nextLine();
        System.out.println("Hello, " + fullName + ". Age=" + age);
    }

    // ---------------------------------------------------------------------
    // Example 3: A tiny command REPL (menu loop) using nextLine()
    // ---------------------------------------------------------------------
    // Explanation:
    // This demonstrates reading whole lines from the keyboard to implement
    // a simple command loop. Use nextLine() to capture an entire command.
    private static void example3_MenuLoop(Scanner in) {
        System.out.println("Commands: add <text> | list | quit");
        java.util.List<String> items = new java.util.ArrayList<>();
        while (true) {
            System.out.print("cmd> ");
            String line = in.nextLine().trim();
            if (line.equalsIgnoreCase("quit") || line.equalsIgnoreCase("q")) {
                System.out.println("bye");
                break;
            } else if (line.startsWith("add ")) {
                String text = line.substring(4); // everything after "add "
                items.add(text);
            } else if (line.equals("list")) {
                System.out.println(items);
            } else {
                System.out.println("unknown command");
            }
        }
    }

    // ---------------------------------------------------------------------
    // Example 4: Robust integer input helper using hasNextInt + nextLine
    // ---------------------------------------------------------------------
    // Explanation:
    // Use hasNextInt() to validate BEFORE calling nextInt(). If invalid input
    // appears, consume the bad line with nextLine() and re-prompt.
    private static void example4_SafeReadIntHelperDemo(Scanner in) {
        int age = safeReadInt(in, "Enter your age: ");
        int year = safeReadInt(in, "Enter your birth year: ");
        System.out.println("You entered age=" + age + ", year=" + year);
    }

    private static int safeReadInt(Scanner in, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (in.hasNextInt()) {
                int x = in.nextInt();
                in.nextLine(); // consume to end of line
                return x;
            } else {
                System.out.println("Please enter a valid integer.");
                in.nextLine(); // discard bad token/line
            }
        }
    }

    // ---------------------------------------------------------------------
    // Example 5: Reading until EOF (Ctrl+D on macOS/Linux, Ctrl+Z then Enter on Windows)
    // ---------------------------------------------------------------------
    // Explanation:
    // This pattern is common in programming contests and pipelines where input
    // ends when the stream closes. hasNext() returns false at EOF.
    private static void example5_ReadUntilEOF(Scanner in) {
        System.out.println("Type tokens, then signal EOF (Ctrl+D / Ctrl+Z+Enter).\n");
        int tokens = 0;
        while (in.hasNext()) { // false only when the stream ends
            in.next();
            tokens++;
        }
        System.out.println("Total tokens read: " + tokens);
        // NOTE: After EOF, System.in is closed by the OS; the JVM cannot read more.
    }

    // ---------------------------------------------------------------------
    // Example 6: Custom delimiter while using System.in (CSV-like input)
    // ---------------------------------------------------------------------
    // Explanation:
    // By default Scanner splits on whitespace. You can change the delimiter to
    // split on commas OR newlines. Enter lines like:  Ada, 36, 3.9
    private static void example6_CustomDelimiterCSVFromKeyboard(Scanner in) {
        System.out.println("Enter: name, age, gpa  (then press Enter). Example: Ada, 36, 3.9");
        // Save the old delimiter and set a new one
        in.useDelimiter(",\\s*|\\R"); // comma+optional spaces OR any line break
        System.out.print("> ");
        String name = in.next();
        int age = in.nextInt();
        double gpa = in.nextDouble();
        System.out.printf("Parsed → name=%s age=%d gpa=%.2f\n", name, age, gpa);
        // Restore default whitespace delimiter (optional but good hygiene)
        in.reset(); // resets delimiter & many settings to defaults
    }

    // ---------------------------------------------------------------------
    // Example 7: Read numbers line-by-line until a BLANK line, then sum
    // ---------------------------------------------------------------------
    // Explanation:
    // When mixing free-form lines with numbers, it’s often easier to read lines
    // with nextLine() and stop on an empty line. Then parse the line as needed.
    private static void example7_ReadNumbersUntilBlankLine(Scanner in) {
        System.out.println("Enter integers (space-separated). Press Enter on an empty line to finish.");
        long sum = 0;
        while (true) {
            System.out.print("> ");
            String line = in.nextLine().trim();
            if (line.isEmpty()) break; // BLANK line ends input
            // Split on whitespace and parse
            for (String tok : line.split("\\s+")) {
                try {
                    sum += Integer.parseInt(tok);
                } catch (NumberFormatException nfe) {
                    System.out.println("Ignoring non-integer token: '" + tok + "'");
                }
            }
        }
        System.out.println("Sum = " + sum);
    }
}
