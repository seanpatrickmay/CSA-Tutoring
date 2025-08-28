import java.util.*;

/**
 * Instructions:
 *  - Implement the static method mergeSorted(List<Integer> a, List<Integer> b)
 *    that returns a NEW sorted list containing all elements of a and b.
 *  - Assume inputs are individually sorted ascending.
 *  - Do not use library sort; implement a linear-time merge.
 *
 * The main method below runs a set of test cases and prints results.
 */
public class MergeSortedListsTest {

    /**
     * TODO: Implement this function in MergeSortedListsTest.
     * Precondition: a and b are sorted ascending (non-decreasing).
     */
    public static List<Integer> mergeSorted(List<Integer> a, List<Integer> b) {
        throw new UnsupportedOperationException("TODO: mergeSorted");
    }

    // ====== SIMPLE TEST HARNESS ======
    private static void runTest(String name, List<Integer> a, List<Integer> b, List<Integer> expected) {
        try {
            List<Integer> result = mergeSorted(a, b);
            boolean pass = result.equals(expected);
            System.out.println(name + ": " + (pass ? "PASS" : "FAIL"));
            if (!pass) {
                System.out.println("  expected: " + expected);
                System.out.println("  got     : " + result);
            }
        } catch (UnsupportedOperationException e) {
            System.out.println(name + ": mergeSorted not implemented yet.");
        }
    }

    public static void main(String[] args) {
        runTest("Empty lists", Collections.emptyList(), Collections.emptyList(), Collections.emptyList());

        List<Integer> a = Arrays.asList(1, 2, 3);
        runTest("One empty one non-empty A", a, Collections.emptyList(), Arrays.asList(1, 2, 3));
        runTest("One empty one non-empty B", Collections.emptyList(), a, Arrays.asList(1, 2, 3));

        runTest("Simple merge", Arrays.asList(1, 3, 5), Arrays.asList(2, 4, 6), Arrays.asList(1, 2, 3, 4, 5, 6));

        runTest("Duplicates", Arrays.asList(1, 2, 2, 3), Arrays.asList(2, 2, 4), Arrays.asList(1, 2, 2, 2, 2, 3, 4));

        runTest("Interleaved", Arrays.asList(1, 4, 7), Arrays.asList(2, 3, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 6, 7));

        runTest("Already ordered", Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 6));
    }
}
