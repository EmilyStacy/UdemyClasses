package LinkedListCustomer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<String>();
        placesToVisit.add("Dallas");
        placesToVisit.add("New York");
        placesToVisit.add("Phoenix");
        placesToVisit.add("Philadelphia");
        placesToVisit.add("Los Angels");
        placesToVisit.add("San Francisco");
        placesToVisit.add("Seattle");
        printList(placesToVisit);


    }

    private static void printList(LinkedList<String> linkList) {
        Iterator<String> i = linkList.iterator();
        while(i.hasNext()){
            System.out.println("We are visiting " + i.next());
        }
        System.out.println("================================");

    }


}
