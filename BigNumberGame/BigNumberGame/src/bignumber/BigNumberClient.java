/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bignumber;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.io.*;
import java.net.*;

public class BigNumberClient extends JFrame
        implements Runnable, BigNumberConstants {

    // Input and output streams from/to server
    private DataInputStream fromServer;
    private DataOutputStream toServer;

    // Continue to play?
    private boolean continueToPlay = true;

    // Wait for the player to input a number
    private boolean waiting = true;

    // Host name or ip
    private String host = "localhost";
    
    // Create and initialize a title label
    private JLabel jlblTitle = new JLabel();

    // Create and initialize a status label
    private JLabel jlblStatus = new JLabel();

    // Create a Text Box for getting input
    private JTextField txtNumber = new JTextField();
    
    // Create a label for the other player
    private JLabel lblOpponentNumber = new JLabel();
    
    // Create a button for sending the number
    private JButton btnSend = new JButton("Send");
    /**
     * Initialize UI
     */
    public BigNumberClient() {
        // Panel p to hold cells
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(3, 2, 0, 0));
        p.add(new JLabel("You"));
        p.add(new JLabel("Opponent"));
        p.add(txtNumber);
        p.add(lblOpponentNumber);
        p.add(btnSend);   

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                waiting = false;
            }
         });
        
        btnSend.setEnabled(false);
        
        // Set properties for labels and borders for labels and panel
        p.setBorder(new LineBorder(Color.black, 1));
        jlblTitle.setHorizontalAlignment(JLabel.CENTER);
        jlblTitle.setFont(new Font("SansSerif", Font.BOLD, 16));
        jlblTitle.setBorder(new LineBorder(Color.black, 1));
        jlblStatus.setBorder(new LineBorder(Color.black, 1));

        // Place the panel and the labels to the applet
        add(jlblTitle, BorderLayout.NORTH);
        add(p, BorderLayout.CENTER);
        add(jlblStatus, BorderLayout.SOUTH);

        // Connect to the server
        connectToServer();

        // Display the frame
        setSize(320, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void connectToServer() {
        try {
            // Create a socket to connect to the server
            Socket socket;
            socket = new Socket(host, 8000);

            // Create an input stream to receive data from the server
            fromServer = new DataInputStream(socket.getInputStream());

            // Create an output stream to send data to the server
            toServer = new DataOutputStream(socket.getOutputStream());
        } catch (Exception ex) {
            System.err.println(ex);
        }

        // Control the game on a separate thread
        Thread thread = new Thread(this);
        thread.start();
    }

    public void run() {
        try {
            // Get notification from the server
            int player = fromServer.readInt();

            // Am I player 1 or 2?
            if (player == PLAYER1) {
                jlblTitle.setText("Player 1");
                jlblStatus.setText("Waiting for player 2 to join");

                // Receive startup notification from the server
                fromServer.readInt(); // Whatever read is ignored

                // The other player has joined
                jlblStatus.setText("Player 2 has joined. I can play now");

            } else if (player == PLAYER2) {
                jlblTitle.setText("Player 2");
                jlblStatus.setText("I can play now");
            }
            
            // Both players have joined
            btnSend.setEnabled(true);

            // Continue to play
            while (continueToPlay) {
                waitForPlayerAction(); // Wait for player 1 to move
                sendMove(); // Send the move to the server
                receiveInfoFromServer(); // Receive info from the server
            }
        } catch (Exception ex) {
        }
    }

    /**
     * Wait for the player to mark a cell
     */
    private void waitForPlayerAction() throws InterruptedException {
        while (waiting) {
            Thread.sleep(100);
        }

        waiting = true;
    }

    /**
     * Send this player's move to the server
     */
    private void sendMove() throws IOException {
        toServer.writeInt(Integer.parseInt(txtNumber.getText())); // Send the input number
        jlblStatus.setText("The number has been sent to the server.");
    }

    /**
     * Receive info from the server
     */
    private void receiveInfoFromServer() throws IOException {
        // Receive game status
        int status = fromServer.readInt();

        if (status == PLAYER1_WON) {
            // Player 1 won, stop playing
            jlblStatus.setText("Player 1 has won! You can play again");
            receiveMove();
        } else if (status == PLAYER2_WON) {
            // Player 2 won, stop playing
            jlblStatus.setText("Player 2 has won! You can play again");
            receiveMove();
        } else if (status == DRAW) {
            // No winner, game is over
            jlblStatus.setText("Game is over, no winner! You can play again");
            receiveMove();
        }    
        
        // Because I make it to true, the players can play again and again
        continueToPlay = true;
    }

    private void receiveMove() throws IOException {
        // Get the other player's move
        int number = fromServer.readInt();
        lblOpponentNumber.setText(Integer.toString(number));
    }
 
    /**
     * This main method enables the applet to run as an application
     */
    public static void main(String[] args) {
        // Create a frame
        BigNumberClient frame = new BigNumberClient();
    }
}
