/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generics_collections;

public class IntegerMatrix extends GenericMatrix<Integer> {

    @Override
    /**
     * Add two integers
     */
    protected Integer add(Integer o1, Integer o2) {
        return o1 + o2;
    }

    @Override
    /**
     * Multiply two integers
     */
    protected Integer multiply(Integer o1, Integer o2) {
        return o1 * o2;
    }

    @Override
    /**
     * Specify zero for an integer
     */
    protected Integer zero() {
        return 0;
    }
}
