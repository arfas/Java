/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bignumber;

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class BigNumberServer extends JFrame
        implements BigNumberConstants {

    public static void main(String[] args) {
        BigNumberServer frame = new BigNumberServer();
    }

    public BigNumberServer() {
        JTextArea jtaLog = new JTextArea();

        // Create a scroll pane to hold text area
        JScrollPane scrollPane = new JScrollPane(jtaLog);

        // Add the scroll pane to the frame
        add(scrollPane, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setTitle("BigNumberServer");
        setVisible(true);

        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(8000);
            jtaLog.append(new Date()
                    + ": Server started at socket 8000\n");

            // Number a session
            int sessionNo = 1;

            // Ready to create a session for every two players
            while (true) {
                jtaLog.append(new Date()
                        + ": Wait for players to join session " + sessionNo + '\n');

                // Connect to player 1
                Socket player1 = serverSocket.accept();

                jtaLog.append(new Date() + ": Player 1 joined session "
                        + sessionNo + '\n');
                jtaLog.append("Player 1's IP address"
                        + player1.getInetAddress().getHostAddress() + '\n');

                // Notify that the player is Player 1
                new DataOutputStream(
                        player1.getOutputStream()).writeInt(PLAYER1);

                // Connect to player 2
                Socket player2 = serverSocket.accept();

                jtaLog.append(new Date()
                        + ": Player 2 joined session " + sessionNo + '\n');
                jtaLog.append("Player 2's IP address"
                        + player2.getInetAddress().getHostAddress() + '\n');

                // Notify that the player is Player 2
                new DataOutputStream(
                        player2.getOutputStream()).writeInt(PLAYER2);

                // Display this session and increment session number
                jtaLog.append(new Date() + ": Start a thread for session "
                        + sessionNo++ + '\n');

                // Create a new thread for this session of two players
                HandleASession task = new HandleASession(player1, player2);

                // Start the new thread
                new Thread(task).start();
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}

// Define the thread class for handling a new session for two players
class HandleASession implements Runnable, BigNumberConstants {

    private Socket player1;
    private Socket player2;

    // Create and initialize cells
    private int[] numbers = new int[2];

    private DataInputStream fromPlayer1;
    private DataOutputStream toPlayer1;
    private DataInputStream fromPlayer2;
    private DataOutputStream toPlayer2;

    // Continue to play
    private boolean continueToPlay = true;

    /**
     * Construct a thread
     */
    public HandleASession(Socket player1, Socket player2) {
        this.player1 = player1;
        this.player2 = player2;

        // Initialize cells
        numbers[0] = 0;
        numbers[1] = 0;
    }

    /**
     * Implement the run() method for the thread
     */
    public void run() {
        try {
            // Create data input and output streams
            DataInputStream fromPlayer1 = new DataInputStream(
                    player1.getInputStream());
            DataOutputStream toPlayer1 = new DataOutputStream(
                    player1.getOutputStream());
            DataInputStream fromPlayer2 = new DataInputStream(
                    player2.getInputStream());
            DataOutputStream toPlayer2 = new DataOutputStream(
                    player2.getOutputStream());

      // Write anything to notify player 1 to start
            toPlayer1.writeInt(1);
            

      // Continuously serve the players and determine and report
            // the game status to the players
            while (true) {
                // Receive a move from player 1
                numbers[0] = fromPlayer1.readInt();
                numbers[1] = fromPlayer2.readInt();
  
                // Check if who wins
                if (numbers[0] > numbers[1]) {
                    toPlayer1.writeInt(PLAYER1_WON);
                    toPlayer2.writeInt(PLAYER1_WON);
                } else if (numbers[0] < numbers[1]) {
                    toPlayer1.writeInt(PLAYER2_WON);
                    toPlayer2.writeInt(PLAYER2_WON);
                } else {
                    toPlayer1.writeInt(DRAW);
                    toPlayer2.writeInt(DRAW);
                }
                
                sendMove(toPlayer1, numbers[1]);
                sendMove(toPlayer2, numbers[0]);
                
                //break;
                // Let make players play continuously 
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    /**
     * Send the move to other player
     */
    private void sendMove(DataOutputStream out, int number)
            throws IOException {
        out.writeInt(number); // Send the number
    }

    
}
