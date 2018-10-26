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
import java.util.LinkedList;

public class OrderQueue {

    private LinkedList<Order> orderQueue = new LinkedList<>();

    public synchronized void pushOrder(Order order) {
        orderQueue.addLast(order);
        notifyAll();                           // notify any waiting threads 
        // that an order has been added
    }

    public synchronized Order pullOrder() {
        while (orderQueue.size() == 0) // if there are no orders in
        // the queue, wait
        {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        return orderQueue.removeFirst();
    }
}
