package fst;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Activity10 {
    public static void main(String[] args) {
        Set<Integer> hs = new HashSet<>();
        hs.add(10);
        hs.add(20);
        hs.add(30);
        hs.add(40);
        hs.add(50);
        hs.add(60);

        System.out.println("Size of set is " + hs.size());
        // Removing element that exists
        System.out.println("Is 30 removed? ->" + hs.remove(30));
        // Removing element that doesn't exist
        System.out.println("Is 9 removed? ->" + hs.remove(9));
        // Check presence
        System.out.println("Is 50 present ? ->" + hs.contains(50));
        // Printing updated set
        Iterator<Integer> iterator = hs.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
