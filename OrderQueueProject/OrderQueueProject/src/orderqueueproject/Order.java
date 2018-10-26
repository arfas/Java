/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderqueueproject;

/**
 *
 * @author ken
 */
public class Order {

    private int number;

    public Order(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Order #" + number;
    }
}
