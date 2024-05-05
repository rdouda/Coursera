import java.util.*;
// SortedList class using the LinkedList class
public class SortedList {
    private List<String> sortedList;

    public SortedList() {
        this.sortedList = new LinkedList<String>();
    }

    public void adds(String element) {
        if (this.sortedList.isEmpty()) {
            this.sortedList.add(element);
        } else {
            boolean added = false;
            for (int i = 0; i < this.sortedList.size(); i++) {
                String currentElement = this.sortedList.get(i);
                if (element.compareTo(currentElement) <= 0) {
                    this.sortedList.add(i, element);
                    added = true;
                    break;
                }
            }
            if (!added) {
                this.sortedList.add(element);
            }
        }
    }

    public void displays() {
        for (String element : this.sortedList) {
            System.out.println(element);
        }
    }
}