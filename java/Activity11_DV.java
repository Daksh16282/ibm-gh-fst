package fst;

import java.util.HashMap;
import java.util.Map;

public class Activity11 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Red");
        map.put(2, "Blue");
        map.put(3, "Green");
        map.put(4, "Violet");
        map.put(5, "Indigo");

        // Printing Map
        System.out.println(map);
        // Removing element
        System.out.println("Removed pair with value -> " + map.remove(5));
        // Check if green exists
        System.out.println("Is green color present? -> " + map.containsValue("Green"));
        // Size of Map
        System.out.println("Size of map is -> " + map.size());
        // Updated Map
        System.out.println(map);
    }
}
