import java.util.*;
import java.util.Iterator;  // explicit for Section 8 demo

public class ArrayLists {

    public static void main(String[] args) {
        section1_WhatIsArrayList_demo();
        System.out.println("");
        section2_DeclaringConstructing_demo();
        System.out.println("");
        section3_AddingElements_demo();
        System.out.println("");
        section4_AccessingUpdating_demo();
        System.out.println("");
        section5_RemovingElements_demo();
        System.out.println("");
        section6_Searching_demo();
        System.out.println("");
        section8_IterationPatterns_demo();
        System.out.println("");
        section9_Sorting_demo();
        System.out.println("");
        section10_Conversions_demo();
        System.out.println("");
        section11_SublistViews_demo();
        System.out.println("");
        section12_CommonUtility_demo();
        System.out.println("");
        section14A_FilterEvens();
        System.out.println("");
        section14B_RemoveShortWords();
        System.out.println("");
        section14C_MergeSortedLists_demo();
        System.out.println("");
        section14D_SortByLengthThenAlpha();
        System.out.println("");
        section14E_TwoDStructure();
        System.out.println("");
        section14F_CountOccurrences();
    }

    // ================================================================
    // 1) What is an ArrayList?
    // ---------------------------------------------------------------
    // An ArrayList<E> is a resizable list of elements of type E. Unlike a
    // fixed-length array, it can grow/shrink as you add/remove elements.
    // Internally it uses an array and resizes automatically.
    // Import examples:
    //   import java.util.ArrayList;
    //   import java.util.List; // optional, see Section 7
    // Key points:
    //  - Ordered: preserves insertion order.
    //  - Indexed: access via 0..size()-1.
    //  - Allows duplicates and null (AP problems rarely use null).
    //  - Stores OBJECTS (use wrappers: Integer, Double, Boolean… not primitives).
    private static void section1_WhatIsArrayList_demo() {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(10);
        nums.add(20);
        System.out.println("1) What is ArrayList → " + nums);
    }

    // ================================================================
    // 2) Declaring & Constructing
    // ---------------------------------------------------------------
    // Basic:
    //   ArrayList<Integer> nums = new ArrayList<>();
    //   ArrayList<String> words = new ArrayList<String>(); // older explicit type
    // With initial capacity (capacity ≠ size):
    //   ArrayList<Integer> big = new ArrayList<>(1000);
    // Using the List interface (recommended style):
    //   List<String> names = new ArrayList<>();
    private static void section2_DeclaringConstructing_demo() {
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<Integer> big = new ArrayList<>(5);
        List<String> names = new ArrayList<>();
        names.add("Ada"); names.add("Grace");
        System.out.println("2) Declaring/Constructing → size(nums)=" + nums.size() + ", names=" + names);
    }

    // ================================================================
    // 3) Adding Elements
    // ---------------------------------------------------------------
    // pets.add("cat");           // [cat]
    // pets.add("dog");           // [cat, dog]
    // pets.add(1, "parrot");    // [cat, parrot, dog]
    // Bulk add via addAll
    private static void section3_AddingElements_demo() {
        List<String> pets = new ArrayList<>();
        pets.add("cat");
        pets.add("dog");
        pets.add(1, "parrot");
        List<String> more = new ArrayList<>();
        more.add("hamster");
        more.add("gecko");
        pets.addAll(more);
        System.out.println("3) Adding → " + pets);
    }

    // ================================================================
    // 4) Accessing & Updating
    // ---------------------------------------------------------------
    // String first = pets.get(0);
    // pets.set(2, "turtle");
    // int n = pets.size();
    private static void section4_AccessingUpdating_demo() {
        List<String> pets = new ArrayList<>(Arrays.asList("cat","parrot","dog","hamster","gecko"));
        String first = pets.get(0);
        pets.set(2, "turtle");
        int n = pets.size();
        System.out.println("4) Access/Update → first=" + first + ", size=" + n + ", pets=" + pets);
    }

    // ================================================================
    // 5) Removing Elements
    // ---------------------------------------------------------------
    // pets.remove(3);        // by index, returns removed element
    // pets.remove("parrot"); // by value, returns boolean
    // pets.clear();          // remove all
    private static void section5_RemovingElements_demo() {
        List<String> pets = new ArrayList<>(Arrays.asList("cat","parrot","turtle","hamster","gecko"));
        pets.remove(3);            // remove "hamster"
        pets.remove("parrot");     // remove by value
        System.out.println("5) Removing → " + pets);
    }

    // ================================================================
    // 6) Searching
    // ---------------------------------------------------------------
    // contains(x), indexOf(x), lastIndexOf(x)
    private static void section6_Searching_demo() {
        List<Integer> nums = new ArrayList<>(Arrays.asList(10, 20, 10));
        System.out.println("6) Searching → contains(20)=" + nums.contains(20)
                + ", indexOf(10)=" + nums.indexOf(10)
                + ", lastIndexOf(10)=" + nums.lastIndexOf(10));
    }

    // ================================================================
    // 7) Interfaces & Generics (brief but important)
    // ---------------------------------------------------------------
    // - ArrayList<E> uses generics: the type E must be a class type (Integer, etc.).
    //   ArrayList<Integer> ✅   ArrayList<int> ❌
    // - Prefer coding to the List<E> interface:
    //     List<Double> grades = new ArrayList<>();
    //   This makes it easy to swap implementations later.

    // ================================================================
    // 8) Iteration Patterns
    // ---------------------------------------------------------------
    // Index for-loop, Enhanced for-loop, Iterator for safe removal.
    private static void section8_IterationPatterns_demo() {
        List<String> items = new ArrayList<>(Arrays.asList("apple","banana","grape","guava","cherry"));
        System.out.print("8) Index loop → ");
        for (int i = 0; i < items.size(); i++) {
            System.out.print(i + ":" + items.get(i) + (i < items.size()-1 ? ", " : "\n"));
        }
        System.out.print("   For-each → ");
        for (String s : items) {
            System.out.print(s + " ");
        }
        System.out.println();
        // Safe removal using Iterator
        Iterator<String> it = items.iterator();
        while (it.hasNext()) {
            String p = it.next();
            if (p.startsWith("g")) it.remove();
        }
        System.out.println("   After iterator removal (remove words starting with 'g'): " + items);
    }

    // ================================================================
    // 9) Sorting
    // ---------------------------------------------------------------
    // Collections.sort(list) for natural order; list.sort(comp) for custom.
    private static void section9_Sorting_demo() {
        List<String> words = new ArrayList<>(Arrays.asList("pear","apple","fig","banana","kiwi"));
        Collections.sort(words); // natural order
        System.out.println("9) Sort natural → " + words);
        words.sort((a,b) -> Integer.compare(a.length(), b.length()));
        System.out.println("   Sort by length → " + words);
    }

    // ================================================================
    // 10) Converting Between Arrays and ArrayLists
    // ---------------------------------------------------------------
    // Array → ArrayList: new ArrayList<>(Arrays.asList(a))
    // Arrays.asList returns a fixed-size list; wrapping makes it resizable.
    // ArrayList → Array: toArray(new T[0])
    private static void section10_Conversions_demo() {
        String[] a = {"red","green","blue"};
        List<String> colors = new ArrayList<>(Arrays.asList(a));
        String[] copy = colors.toArray(new String[0]);
        System.out.println("10) Conversions → colors=" + colors + ", arrayCopy=" + Arrays.toString(copy));
    }

    // ================================================================
    // 11) Sublist Views
    // ---------------------------------------------------------------
    // List<Integer> mid = numbers.subList(2,5); // view (modifying affects parent)
    private static void section11_SublistViews_demo() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6));
        List<Integer> mid = numbers.subList(2,5); // [2,3,4]
        mid.set(0, 99); // changes original
        System.out.println("11) Sublist → numbers=" + numbers + ", mid=" + mid);
    }

    // ================================================================
    // 12) Common Utility Methods
    // ---------------------------------------------------------------
    // addAll, removeAll, retainAll, isEmpty, equals, toString
    private static void section12_CommonUtility_demo() {
        List<String> a = new ArrayList<>(Arrays.asList("a","b","c","d"));
        List<String> b = new ArrayList<>(Arrays.asList("b","d","e"));
        List<String> copy = new ArrayList<>(a);
        copy.removeAll(b); // remove any in b
        System.out.println("12) removeAll (a - b) → " + copy);
        copy = new ArrayList<>(a);
        copy.retainAll(b); // keep only in both
        System.out.println("    retainAll (a ∩ b) → " + copy);
        System.out.println("    isEmpty? " + copy.isEmpty());
    }

    // ================================================================
    // 13) Performance Notes (Big‑O, intuitive)
    // ---------------------------------------------------------------
    //  - add(e) at end: amortized O(1)
    //  - add(i,e) / remove(i): O(n) (shift elements)
    //  - get(i) / set(i): O(1)
    //  - contains(x): O(n)
    // If you insert/remove frequently in middle, other structures (e.g., LinkedList)
    // may be better (beyond AP scope).

    // ================================================================
    // 14) Real Examples
    // ---------------------------------------------------------------
    // A) Filter even numbers from 1..20 into a list
    private static void section14A_FilterEvens() {
        List<Integer> evens = new ArrayList<>();
        for (int i = 1; i <= 20; i++) if (i % 2 == 0) evens.add(i);
        System.out.println("14A) Evens → " + evens);
    }
    // B) Remove all words shorter than 3 letters (iterator removal)
    private static void section14B_RemoveShortWords() {
        List<String> words = new ArrayList<>(Arrays.asList("to","be","or","not","to","be"));
        Iterator<String> it = words.iterator();
        while (it.hasNext()) if (it.next().length() < 3) it.remove();
        System.out.println("14B) Remove short words → " + words);
    }
    // C) Merge two sorted lists (classic AP-style)
    private static void section14C_MergeSortedLists_demo() {
        System.out.println("14C) Merge → " + mergeSorted(Arrays.asList(1,3,5), Arrays.asList(2,4,6)));
    }
    public static List<Integer> mergeSorted(List<Integer> a, List<Integer> b) {
        List<Integer> out = new ArrayList<>(a.size() + b.size());
        int i = 0, j = 0;
        while (i < a.size() && j < b.size()) {
            if (a.get(i) <= b.get(j)) out.add(a.get(i++));
            else out.add(b.get(j++));
        }
        while (i < a.size()) out.add(a.get(i++));
        while (j < b.size()) out.add(b.get(j++));
        return out;
    }
    // D) Sorting with a custom Comparator (by length then alphabetically)
    private static void section14D_SortByLengthThenAlpha() {
        List<String> items = new ArrayList<>(Arrays.asList("pear","apple","fig","banana","kiwi"));
        items.sort((s1,s2) -> {
            int cmp = Integer.compare(s1.length(), s2.length());
            if (cmp != 0) return cmp;
            return s1.compareTo(s2);
        });
        System.out.println("14D) Sort by length then alpha → " + items);
    }
    // E) 2D structure — ArrayList of ArrayLists
    private static void section14E_TwoDStructure() {
        List<List<Integer>> grid = new ArrayList<>();
        int rows = 3, cols = 4, val = 1;
        for (int r = 0; r < rows; r++) {
            List<Integer> row = new ArrayList<>();
            for (int c = 0; c < cols; c++) row.add(val++);
            grid.add(row);
        }
        System.out.println("14E) 2D structure → " + grid + "; element (1,2)=" + grid.get(1).get(2));
    }
    // F) Counting occurrences with ArrayList (basic)
    private static void section14F_CountOccurrences() {
        List<String> data = new ArrayList<>(Arrays.asList("a","b","a","c","b","a"));
        List<String> uniq = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        for (String s : data) {
            int idx = uniq.indexOf(s);
            if (idx == -1) { uniq.add(s); counts.add(1); }
            else counts.set(idx, counts.get(idx) + 1);
        }
        System.out.println("14F) Unique → " + uniq + ", counts → " + counts);
    }

    // ================================================================
    // 15) Common Pitfalls & Tips
    // ---------------------------------------------------------------
    // - Primitive vs Wrapper: cannot have ArrayList<int>; use ArrayList<Integer>.
    // - Off-by-one: last valid index is size()-1.
    // - Concurrent modification: do not call list.remove(...) in a for-each; use Iterator.
    // - Arrays.asList is fixed-size: wrap with new ArrayList<>(...) to modify size.
    // - "==" vs ".equals": use .equals to compare object values (e.g., String).
    // - Autoboxing: int → Integer automatically on add; beware of nulls.

    // ================================================================
    // 16) Practice Exercises (with expected outcomes)
    // ---------------------------------------------------------------
    // 1. Insert in sorted order: method that inserts an int into a sorted
    //    ArrayList<Integer> while keeping order. Test: [1,3,5] + 4 → [1,3,4,5].
    // 2. Remove odds: remove all odd numbers in-place using Iterator.
    // 3. Reverse: create a new list that is the reverse of the original.
    // 4. Merge (challenge): implement mergeSorted(a,b) in O(n+m) (see 14C to check).
    // 5. Unique in order: given ["a","b","a","c","b"] → ["a","b","c"].

    // ================================================================
    // 17) Quick Reference (cheat-sheet)
    // ---------------------------------------------------------------
    // List<E> list = new ArrayList<>();
    // list.add(e);               // append
    // list.add(i, e);            // insert at i
    // E x = list.get(i);         // read at i
    // list.set(i, e);            // replace at i
    // E y = list.remove(i);      // remove at i (returns removed)
    // boolean ok = list.remove(e);// remove first occurrence
    // int n = list.size();
    // boolean has = list.contains(e);
    // int i = list.indexOf(e);   // -1 if not found
    // list.clear();
    // Collections.sort(list);    // natural order
    // list.sort(comparator);     // custom order (Java 8+)
}
