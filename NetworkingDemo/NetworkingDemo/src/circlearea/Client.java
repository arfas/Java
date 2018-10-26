/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circlearea;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    // IO streams

    private DataOutputStream toServer;
    private DataInputStream fromServer;

    public static void main(String[] args) {
        Client client = new Client();
    }

    public Client() {
        try {
            // Create a socket to connect to the server
            Socket socket = new Socket("localhost", 8000);

            // Create an input stream to receive data from the server
            fromServer = new DataInputStream(
                    socket.getInputStream());

            // Create an output stream to send data to the server
            toServer
                    = new DataOutputStream(socket.getOutputStream());

            Scanner sc = new Scanner(System.in);
            // Get the radius from the text field
            double radius = sc.nextDouble();

            // Send the radius to the server
            toServer.writeDouble(radius);
            toServer.flush();

            // Get area from the server
            double area = fromServer.readDouble();

            // Display to the text area
            System.out.print("Radius is " + radius + "\n");
            System.out.print("Area received from the server is "
                    + area + '\n');
        } catch (IOException ex) {
            System.out.print(ex.toString() + '\n');
        }
    }
}
