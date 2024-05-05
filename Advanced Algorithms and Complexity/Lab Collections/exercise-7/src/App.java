import java.util.LinkedList;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        LinkedList<String> linkedList = new LinkedList<>();

        // Add some elements to the list
        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Cherry");
        linkedList.add("Date");
        linkedList.add("Elderberry");

        System.out.println("Original list: " + linkedList);

        // Swap two specified elements of the list
        int index1 = 1;
        int index2 = 3;
        String temp = linkedList.get(index1);
        linkedList.set(index1, linkedList.get(index2));
        linkedList.set(index2, temp);

        System.out.println("Swapped list: " + linkedList);

        // Mix the elements (shuffle)
        Random random = new Random();
        for (int i = 0; i < linkedList.size(); i++) {
            int swapIndex = random.nextInt(linkedList.size());
            String temp2 = linkedList.get(i);
            linkedList.set(i, linkedList.get(swapIndex));
            linkedList.set(swapIndex, temp2);
        }

        System.out.println("Shuffled list: " + linkedList);

        // Create a clone of the LinkedList
        LinkedList<String> clonedLinkedList = (LinkedList<String>) linkedList.clone();

        System.out.println("Cloned list: " + clonedLinkedList);
    }
}
