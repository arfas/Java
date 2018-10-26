package advcomps;


import javax.swing.*;

import javax.swing.event.*;

import java.awt.BorderLayout;


public class SimpleSpinner extends JFrame {
  
// Create a JSpinner
  private JSpinner spinner = new JSpinner();


  // Create a JLabel
  private JLabel label = new JLabel("", JLabel.CENTER);


  public SimpleSpinner()
 {
    // Add spinner and label to the UI
    add(spinner, BorderLayout.NORTH);

    add(label, BorderLayout.CENTER);

    // Register and create a listener
  
  spinner.addChangeListener(new ChangeListener() {
 
     @Override 
      public void stateChanged(javax.swing.event.ChangeEvent e) {
 
       label.setText("Previous value: " + spinner.getPreviousValue()
          + " Current value: " + spinner.getValue()
          + " Next value: " + spinner.getNextValue());
      }
    });
  }


  public static void main(String[] args) 
{

    SimpleSpinner spinner = new SimpleSpinner();

    // Add the applet instance to the frame

    spinner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


 
    // Display the frame
    spinner.setSize(300, 300);
  
  spinner.setVisible(true);
  }
}

