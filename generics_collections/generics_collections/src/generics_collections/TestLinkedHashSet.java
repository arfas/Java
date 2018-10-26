/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generics_collections;

import java.util.*;

public class TestLinkedHashSet {

    public static void main(String[] args) {
        // Create a hash set
        Set<String> set = new LinkedHashSet<String>();

        // Add strings to the set
        set.add("London");
        set.add("Paris");
        set.add("New York");
        set.add("San Francisco");
        set.add("Beijing");
        set.add("New York");

        System.out.println(set);

        // Display the elements in the hash set
        for (String element : set) {
            System.out.print(element.toLowerCase() + " ");
        }
    }
}
