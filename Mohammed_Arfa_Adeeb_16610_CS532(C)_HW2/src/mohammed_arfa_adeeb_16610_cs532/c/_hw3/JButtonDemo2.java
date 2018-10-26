/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mohammed_arfa_adeeb_16610_cs532.c._hw3;
import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.border.BevelBorder;

/**
 *
 * @author arfas
 */
public class JButtonDemo2{
    
   


 DataInputStream fromServer;
 DataOutputStream toServer;

	JFrame jtfMainFrame;
	JButton jbnButton1, jbnButton2,jbnButton3,jbnButton4,jbnButton5;
	JTextField jtfInput;
	JPanel jplPanel;
         private JLabel jlblTitle = new JLabel();
          JLabel jlblStatus = new JLabel();
           boolean continueToPlay = true;
           boolean waiting = true;
           String host = "localhost";
	public JButtonDemo2() {
		jtfMainFrame = new JFrame("Rock Paper Scissors");
		jtfMainFrame.setSize(300, 300);
                jbnButton1 = new JButton("Ready");
		jbnButton2 = new JButton("Rock");
		jbnButton3 = new JButton("Paper");
                jbnButton4= new JButton("Scissors");
                jbnButton5 = new JButton("Quit");
                
		jtfInput = new JTextField(20);
		jplPanel = new JPanel();
               
                
		jbnButton1.setMnemonic(KeyEvent.VK_I); //Set ShortCut Keys
		jbnButton1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				jtfInput.setText("Ready");
			}
		});
		jbnButton2.setMnemonic(KeyEvent.VK_I);
		jbnButton2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				jtfInput.setText("Rock");
			}
		});
jbnButton3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				jtfInput.setText("Paper");
			}
		});
		jbnButton3.setMnemonic(KeyEvent.VK_I);
		jbnButton4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				jtfInput.setText("Scissors");
			}
		});
                jbnButton5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				jtfInput.setText("Exit");
			}
		});
		
		
					jplPanel.setLayout(new FlowLayout());
		jplPanel.add(jtfInput);
		jplPanel.add(jbnButton1);
		jplPanel.add(jbnButton2);
                jplPanel.add(jbnButton3);
                jplPanel.add(jbnButton4);
                jplPanel.add(jbnButton5);
               
                
		jtfMainFrame.getContentPane().add(jplPanel, BorderLayout.CENTER);
		jtfMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jtfMainFrame.pack();
		jtfMainFrame.setVisible(true);
                
                 
        }
       
	public static void main(String[] args) {
		// Set the look and feel to Java Swing Look
		try {
			UIManager.setLookAndFeel(UIManager
					.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
		}
		JButtonDemo2 frame = new JButtonDemo2();
	}
}