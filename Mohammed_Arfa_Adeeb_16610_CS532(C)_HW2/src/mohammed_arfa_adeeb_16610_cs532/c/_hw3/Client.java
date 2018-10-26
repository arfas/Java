/*

* Student Info: Name=MOHAMMED ARFA ADEEB, ID=16610

* Suject: CS532C_HW3_Fall_2016

* Author: Mohammed Arfa Adeeb

* Filename: client.java

* Date and Time: Nov 5, 2016 8:27:19 PM

* Project Name: MOHAMMED ARFA ADEEB_16610_CS532B_HW3

*/
package mohammed_arfa_adeeb_16610_cs532.c._hw3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import static mohammed_arfa_adeeb_16610_cs532.c._hw3.BigNumberConstants.DRAW;
import static mohammed_arfa_adeeb_16610_cs532.c._hw3.BigNumberConstants.PLAYER1;
import static mohammed_arfa_adeeb_16610_cs532.c._hw3.BigNumberConstants.PLAYER1_WON;
import static mohammed_arfa_adeeb_16610_cs532.c._hw3.BigNumberConstants.PLAYER2;
import static mohammed_arfa_adeeb_16610_cs532.c._hw3.BigNumberConstants.PLAYER2_WON;

/**
 *
 * @author arfas
 */
public class Client extends JFrame implements Runnable, BigNumberConstants {
    

 
  private boolean myTurn = false;

    // Indicate the token for the player
    private char myToken = ' ';

    // Indicate the token for the other player
    private char otherToken = ' ';

    // Create and initialize cells
    private Cell[][] cell = new Cell[3][3];

    // Create and initialize a title label
    private JLabel jlblTitle = new JLabel();

    // Create and initialize a status label
    private JLabel jlblStatus = new JLabel();

    private JButton btnSend1 = new JButton("Ready");
    private JButton btnSend2 = new JButton("Rock");
    private JButton btnSend3 = new JButton("Paper");
    private JButton btnSend4 = new JButton("Scissors");
    private JButton btnSend5 = new JButton("Quit");
    // Indicate selected row and column by the current move
    private int rowSelected;
    private int columnSelected;

    // Input and output streams from/to server
    private DataInputStream fromServer;
    private DataOutputStream toServer;

    // Continue to play?
    private boolean continueToPlay = true;

    // Wait for the player to mark a cell
    private boolean waiting = true;

    // Host name or ip
    private String host = "localhost";
     private JTextField txtNumber = new JTextField();

    /**
     * Initialize UI
     */
    public Client() {
        // Panel p to hold cells
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(3, 3, 0, 0));
         p.add(txtNumber);
p.add(btnSend1);
p.add(btnSend2);
p.add(btnSend3);
p.add(btnSend4);
p.add(btnSend5);
 //Set ShortCut Keys
		
                btnSend2.setMnemonic(KeyEvent.VK_I); //Set ShortCut Keys
		btnSend2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				txtNumber.setText("Rock");
			}
		});
                btnSend3.setMnemonic(KeyEvent.VK_I); //Set ShortCut Keys
		btnSend3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				txtNumber.setText("Paper");
			}
		});
                btnSend4.setMnemonic(KeyEvent.VK_I); //Set ShortCut Keys
		btnSend4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				txtNumber.setText("Scissors");
			}
		});
                btnSend5.setMnemonic(KeyEvent.VK_I); //Set ShortCut Keys
		btnSend5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

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
                myToken = 'X';
                otherToken = 'O';
                jlblTitle.setText("Player 1 ");
                jlblStatus.setText("Waiting for player 2 to join");

                // Receive startup notification from the server
                fromServer.readInt(); // Whatever read is ignored

                // The other player has joined
                jlblStatus.setText("Player 2 has joined. I start first");

                // It is my turn
                myTurn = true;
                 btnSend1.setMnemonic(KeyEvent.VK_I);
                btnSend1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				jlblStatus.setText("Player 1 is ready");
			}
		});
                 btnSend1.setEnabled(false);
                 
            } else if (player == PLAYER2) {
                myToken = 'O';
                otherToken = 'X';
                jlblTitle.setText("Player 2");
                jlblStatus.setText("Waiting for player 1 to move");
                btnSend1.setMnemonic(KeyEvent.VK_I);
                btnSend1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				jlblStatus.setText("Player 2 is ready ");
			}
		});
                 btnSend1.setEnabled(false);
                 
            }
btnSend1.setEnabled(true);
            // Continue to play
            while (continueToPlay) {
                if (player == PLAYER1) {
                    waitForPlayerAction(); // Wait for player 1 to move
                    sendMove(); // Send the move to the server
                    receiveInfoFromServer(); // Receive info from the server
                
                } else if (player == PLAYER2) {
                    receiveInfoFromServer(); // Receive info from the server
                    waitForPlayerAction(); // Wait for player 2 to move
                    sendMove(); // Send player 2's move to the server
                }
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
        String text=txtNumber.getText();
        toServer.writeInt(rowSelected); // Send the selected row
        toServer.writeInt(columnSelected); // Send the selected column
        toServer.writeChars(text);
        jlblStatus.setText("The text has been sent");
        
    }

    /**
     * Receive info from the server
     */
    private void receiveInfoFromServer() throws IOException {
        // Receive game status
        int status = fromServer.readInt();

        if (status == PLAYER1_WON) {
            // Player 1 won, stop playing
            continueToPlay = false;
            if (myToken == 'X') {
                jlblStatus.setText("I won! ");
            } else if (myToken == 'O') {
                jlblStatus.setText("Player 1  has won!");
                receiveMove();
            }
        } else if (status == PLAYER2_WON) {
            // Player 2 won, stop playing
            continueToPlay = false;
            if (myToken == 'O') {
                jlblStatus.setText("I won! ");
            } else if (myToken == 'X') {
                jlblStatus.setText("Player 2  has won!");
                receiveMove();
            }
        } else if (status == DRAW) {
            // No winner, game is over
            continueToPlay = false;
            jlblStatus.setText("Game is over, no winner!");

            if (myToken == 'O') {
                receiveMove();
            }
        } else {
            receiveMove();
            jlblStatus.setText("My turn");
            myTurn = true; // It is my turn
        }
    }

    private void receiveMove() throws IOException {
        // Get the other player's move
        int row = fromServer.readInt();
        int column = fromServer.readInt();
        cell[row][column].setToken(otherToken);
    }

    // An inner class for a cell
    public class Cell extends JPanel {

        // Indicate the row and column of this cell in the board
        private int row;
        private int column;

        // Token used for this cell
        private char token = ' ';

        public Cell(int row, int column) {
            this.row = row;
            this.column = column;
            setBorder(new LineBorder(Color.black, 1)); // Set cell's border
            addMouseListener(new ClickListener());  // Register listener
        }

        /**
         * Return token
         */
        public char getToken() {
            return token;
        }

        /**
         * Set a new token
         */
        public void setToken(char c) {
            token = c;
            repaint();
        }

        @Override
        /**
         * Paint the cell
         */
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (token == 'X') {
                g.drawLine(10, 10, getWidth() - 10, getHeight() - 10);
                g.drawLine(getWidth() - 10, 10, 10, getHeight() - 10);
            } else if (token == 'O') {
                g.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
            }
        }

        /**
         * Handle mouse click on a cell
         */
        private class ClickListener extends MouseAdapter {

            public void mouseClicked(MouseEvent e) {
                // If cell is not occupied and the player has the turn
                if ((token == ' ') && myTurn) {
                    setToken(myToken);  // Set the player's token in the cell
                    myTurn = false;
                    rowSelected = row;
                    columnSelected = column;
                    jlblStatus.setText("Waiting for the other player to move");
                    waiting = false; // Just completed a successful move
                }
            }
        }
        
    }

    /**
     * This main method enables the applet to run as an application
     */
    public static void main(String[] args) {
        // Create a frame
        Client frame = new Client();
    }
}
