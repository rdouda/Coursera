import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> linkedList = new LinkedList<>();

        // Add some elements to the list
        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Cherry");

        System.out.println("Original list:");
        for (String element : linkedList) {
            System.out.println(element);
        }

        // Insert an item at position 2
        String item = "Date";
        int position = 2;
        LinkedList<String> linkedListCopy = new LinkedList<>(linkedList);

        ListIterator<String> iterator = linkedListCopy.listIterator(position);
        iterator.add(item);

        System.out.println("Updated list:");
        for (String element : linkedListCopy) {
            System.out.println(element);
        }
    }
}
