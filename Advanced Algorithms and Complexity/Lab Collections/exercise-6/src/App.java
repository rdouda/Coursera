import java.util.LinkedList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> linkedList = new LinkedList<>();

        // Add some elements to the list
        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Cherry");
        linkedList.add("Date");

        System.out.println("Original list: " + linkedList);

        // Return the first item of the list
        String firstItem = linkedList.get(0);
        System.out.println("First item: " + firstItem);

        // Return the last item of the list
        String lastItem = linkedList.get(linkedList.size() - 1);
        System.out.println("Last item: " + lastItem);
    }
}
