/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcdemo;

import java.awt.event.MouseEvent;

public class ViewController extends CircleView {

    public ViewController() {
        // Register mouse listener
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent e) {
                CircleModel model = getModel(); // Get model

                if (model != null) {
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        model.setRadius(model.getRadius() + 5); // Left button
                    } else if (e.getButton() == MouseEvent.BUTTON3) {
                        model.setRadius(model.getRadius() - 5); // Right button
                    }
                }
            }
        });
    }
}
