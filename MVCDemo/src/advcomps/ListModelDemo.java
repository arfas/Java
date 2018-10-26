/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package advcomps;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ListModelDemo extends JFrame {
  private DefaultListModel<String> listModel 
    = new DefaultListModel<String>();
  private JList<String> jlst = new JList<String>(listModel);
  private JButton jbtAdd = new JButton("Add new item");
  private JButton jbtRemove = new JButton("Remove selected item");

 
  public ListModelDemo() {
    // Add items to the list model
    listModel.addElement("Item1");
    listModel.addElement("Item2");
    listModel.addElement("Item3");
    listModel.addElement("Item4");
    listModel.addElement("Item5");
    listModel.addElement("Item6");

    JPanel panel = new JPanel();
    panel.add(jbtAdd);
    panel.add(jbtRemove);

    add(panel, BorderLayout.NORTH);
    add(new JScrollPane(jlst), BorderLayout.CENTER);

    // Register listeners
    jbtAdd.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String newItem =
          JOptionPane.showInputDialog("Enter a new item");

        if (newItem != null)
          if (jlst.getSelectedIndex() == -1)
            listModel.addElement(newItem);
          else
            listModel.add(jlst.getSelectedIndex(), newItem);
      }
    });

    jbtRemove.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        listModel.remove(jlst.getSelectedIndex());
      }
    });
  }

  public static void main(String[] args) {
    ListModelDemo frame = new ListModelDemo();
    
    //EXIT_ON_CLOSE == 3
    frame.setDefaultCloseOperation(3);
    frame.setTitle("ListModelDemo");
  
    frame.setSize(400, 320);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}

