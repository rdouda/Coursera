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
        linkedList.add("Date");
        linkedList.add("Elderberry");

        System.out.println("Original list:");
        for (String element : linkedList) {
            System.out.println(element);
        }

        // Iterate over the list in reverse order
        System.out.println("Reverse:");
        ListIterator<String> iterator = linkedList.listIterator(linkedList.size());
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }
}
