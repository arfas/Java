/*

* Student Info: Name=MOHAMMED ARFA ADEEB, ID=16610

* Suject: CS532C_HW2_Fall_2016

* Author: Mohammed Arfa Adeeb

* Filename: arraycompare.java

* Date and Time: Oct 5, 2016 8:27:19 PM

* Project Name: MOHAMMED ARFA ADEEB_16610_CS532B_HW2

*/
package array;

import java.util.ArrayList;
import static java.util.Collections.shuffle;

/**
 *
 * @author arfas
 */
public class arraycompare {
  






    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);
        shuffle(list);
        System.out.println(list);
        sort(list);
        System.out.println(list);

    }

    public static <E extends Comparable<E>> void sort(ArrayList<E> list) {


        for (int i = 0; i < list.size() - 1; i++) {
            E currentMin = list.get(i);
            int min = i;
            for (int j = i + 1; j < list.size(); j++) {

                if (list.get(j).compareTo(currentMin) < 0) {
                    currentMin = list.get(j);
                    min = j;
                }
            }

            if (min != i) {
                list.set(min, list.get(i));
                list.set(i, currentMin);
            }
        }
    }
    
}
    


    

