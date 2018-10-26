/*

* Student Info: Name=MOHAMMED ARFA ADEEB, ID=16610

* Suject: CS532C_HW2_Fall_2016

* Author: Mohammed Arfa Adeeb

* Filename: array.java

* Date and Time: Oct 5, 2016 8:27:19 PM

* Project Name: MOHAMMED ARFA ADEEB_16610_CS532B_HW2

*/
package array;

import java.util.ArrayList;

/**
 *
 * @author arfas
 */
public class array { public static void main(String[] args) {

        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            strings.add("List of items for making a cake:");
             strings.add("Bowls");
              strings.add("measuring cups and spoons");
               strings.add("electric mixer");
                strings.add("cake pans");
                strings.add("parchent paper");
            strings.add("kitchen scissors");
            strings.add("Pastry brush");
            strings.add("toppings");
            strings.add("frosting");
            strings.add("cake pans");
            strings.add("cake filling");
            strings.add("parchent scissors");
            strings.add("cakestand");
            strings.add("offset spatula");
            strings.add("pastry brush");
            strings.add("pipng gel");
            strings.add("toothpick");
            
            
        }

        strings = removeDuplicates(strings);
        for (String s : strings) {
            System.out.println(s);
        }
    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {

        ArrayList<E> newList = new ArrayList<>(list.size());
        for (E aList : list) {
            if (!newList.contains(aList)) {
                newList.add(aList);
            }
        }
        return newList;
    }
}
    

    
   

