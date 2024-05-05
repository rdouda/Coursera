import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;
public class App {
    public static void main(String[] args) throws Exception {
        // Create an array of ArrayList type
        ArrayList<ArrayList<Integer>> tab = new ArrayList<>();

        // Add some elements to the inner arrays
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(-2);
        list1.add(3);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(-5);
        list2.add(6);

        tab.add(list1);
        tab.add(list2);

        // Display in natural order
        // Solution 1: Using a nested loop
        System.out.println("Natural Order:");
        for (ArrayList<Integer> list : tab) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        // Solution 2: Using an iterator
        System.out.println("Natural Order:");
        for (ArrayList<Integer> list : tab) {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                System.out.print(it.next() + " ");
            }
            System.out.println();
        }

        // Solution 3: Using Java Stream API
        System.out.println("Natural Order:");
        for (ArrayList<Integer> list : tab) {
            list.stream().forEach(System.out::print);
            System.out.println();
        }

        // Solution 4: Using a lambda expression with `forEach`
        System.out.println("Natural Order:");
        tab.forEach(list -> list.forEach(System.out::print));
        System.out.println();


        // Display in reverse order
        // Solution 1
        System.out.println("Reverse Order:");
        for (ArrayList<Integer> list : tab) {
            for (int i = list.size() - 1; i >= 0; i--) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
        // Solution 2
        System.out.println("Reverse Order:");
        for (ArrayList<Integer> list : tab) {
            List<Integer> reversedList = new ArrayList<>(list);
            Collections.reverse(reversedList);
            for (Integer num : reversedList) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        // Display elements of even rank
        // Solution 1
        System.out.println("Elements of Even Rank:");
        for (ArrayList<Integer> list : tab) {
            for (int i = 0; i < list.size(); i++) {
                if (i % 2 == 0) {
                    System.out.print(list.get(i) + " ");
                }
            }
            System.out.println();
        }
        // Solution 2
        System.out.println("Elements of Rank 3:");;
        for (ArrayList<Integer> list : tab) {
            for (int i = 0; i < list.size(); i++) {
                if (i % 3 == 0) {
                    System.out.print(list.get(i) + " ");
                }
            }
            System.out.println();
        }

        // Zeroing negative value elements
        System.out.println("Zeroing Negative Value Elements:");
        for (ArrayList<Integer> list : tab) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) < 0) {
                    list.set(i, 0);
                }
            }
            System.out.println();
        }

        // Display the modified arrays
        System.out.println("Modified Arrays:");
        for (ArrayList<Integer> list : tab) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
