package fst;

import java.util.ArrayList;
import java.util.List;

public class Activity9 {

    public static void main(String[] args) {

        List<String> myList = new ArrayList<>();
        myList.add("Person 1");
        myList.add("Person 2");
        myList.add("Person 3");
        myList.add("Person 4");
        myList.add("Person 5");

        for (String name : myList) {
            System.out.println(name);
        }

        System.out.println("Third name -> " + myList.get(2));
        System.out.println("Is Person 6 exist -> " + myList.contains("Person 6"));
        System.out.println("Total names -> " + myList.size());
        myList.remove("Person 2");
        System.out.println("Total names after removal of Person 2 -> " + myList.size());

    }
}
