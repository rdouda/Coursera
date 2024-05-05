import java.util.ArrayList;
import java.util.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        LinkedList<String> linkedList = new LinkedList<>();

        // Add some elements to the list
        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Cherry");
        linkedList.add("Date");

        System.out.println("Original list: " + linkedList);

        // Replace one element with another
        String oldElement = "Banana";
        String newElement = "Pear";
        int index = linkedList.indexOf(oldElement);
        if (index != -1) {
            linkedList.set(index, newElement);
        }

        System.out.println("Replaced list: " + linkedList);

        // Convert the LinkedList to an ArrayList
        ArrayList<String> arrayList = new ArrayList<>();
        for (String element : linkedList) {
            arrayList.add(element);
        }

        System.out.println("ArrayList: " + arrayList);
    }
}
