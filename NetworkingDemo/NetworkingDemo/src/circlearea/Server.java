/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circlearea;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

    public static void main(String[] args) {
        Server server = new Server();
    }

    public Server() {
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.print("Server started at " + new Date() + '\n');

            // Listen for a connection request
            Socket socket = serverSocket.accept();

            // Create data input and output streams
            DataInputStream inputFromClient = new DataInputStream(
                    socket.getInputStream());
            DataOutputStream outputToClient = new DataOutputStream(
                    socket.getOutputStream());

            while (true) {
                // Receive radius from the client
                double radius = inputFromClient.readDouble();

                // Compute area
                double area = radius * radius * Math.PI;

                // Send area back to the client
                outputToClient.writeDouble(area);

                System.out.print("Radius received from client: " + radius + '\n');
                System.out.print("Area found: " + area + '\n');
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
