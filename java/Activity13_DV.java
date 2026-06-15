package fst;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random indexGen = new Random();
        List<Integer> list = new ArrayList<>();

        System.out.println("Enter list values,press any other key to stop");
        // hasNextInt() become false when input is not an integer
        while (scan.hasNextInt()) {
            list.add(scan.nextInt());
        }
        // Declaring size as 0, as java auto creates a new array of size list.size()
        // when specified size is < list.size()
        Integer[] nums = list.toArray(new Integer[0]);
        int randomIdx = indexGen.nextInt(nums.length);
        System.out.println("Value in list at generated index " + randomIdx + " is " + nums[randomIdx]);

        scan.close();
    }
}
