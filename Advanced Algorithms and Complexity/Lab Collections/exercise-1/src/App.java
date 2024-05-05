import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<String> originalList = new ArrayList<>();
        originalList.add("Apple");
        originalList.add("Banana");
        originalList.add("Orange");

        // Create a new ArrayList to copy the original list
        ArrayList<String> copiedList = new ArrayList<>(originalList.size());

        // Initialize copiedList with the same size as originalList
        for (int i = 0; i < originalList.size(); i++) {
            copiedList.add(null);
        }

        // Copy the elements from originalList to copiedList using Collections.copy()
        Collections.copy(copiedList, originalList);

        // Print the original list
        System.out.println("Original List:");
        for (String item : originalList) {
            System.out.println(item);
        }

        // Print the copied list
        System.out.println("\nCopied List:");
        for (String item : copiedList) {
            System.out.println(item);
        }
        /*  Output:
            Original List:
            Apple
            Banana
            Orange

            Copied List:
            Apple
            Banana
            Orange
         */
    }
}
