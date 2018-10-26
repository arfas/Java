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
public class OrderQueueApp {

    public static void main(String[] args) {
        final int TAKER_COUNT = 3;   // number of OrderTaker threads
        final int ORDER_COUNT = 2;   // number of orders per OrderTaker thread
        final int HANDLER_COUNT = 2; // number of OrderHandler threads

        OrderQueue queue = new OrderQueue();      // create the order queue

        System.out.println("Starting the order queue.");

        System.out.println("Starting " + TAKER_COUNT + " order takers, "
                + "each producing " + ORDER_COUNT + " orders.");

        System.out.println("Starting " + HANDLER_COUNT
                + " order handlers.\n");

        String s
                = "     OrderTaker threads            OrderHandler threads    \n"
                + "============================  =============================";
        System.out.println(s);

        for (int i = 0; i < TAKER_COUNT; i++) // create the Taker threads
        {
            OrderTaker t = new OrderTaker(ORDER_COUNT, queue);
            t.start();
        }

        for (int i = 0; i < HANDLER_COUNT; i++) // create the Handler threads
        {
            OrderHandler h = new OrderHandler(queue);
            h.start();
        }
    }
}
