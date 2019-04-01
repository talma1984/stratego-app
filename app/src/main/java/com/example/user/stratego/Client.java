package com.example.user.stratego;


import android.net.wifi.p2p.WifiP2pManager;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.io.*;
import java.net.*;

public class Client {

    Action action = new Action();
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private int message;
    private Socket connection;
    public static final String HOST = "127.0.0.1";
    public static final int PORT = 3000;
    private static int[] from;
    private static int[] to;

    public Client(String HOST) {



    }

    public void startRunning() {
        try {
            connectToServer();
            setupStream();

            whilePlaying();
        } catch (EOFException eofException) {

            showMassage(" the client has ended the connection ");

        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            closeStreams();
        }

    }

    private void whilePlaying() throws IOException {
        do {
            try {
                message = (int) input.readObject();
                showMassage(" " + message);
            }catch (ClassNotFoundException classNotFoundExceptiion){
                showMassage(" i dont know the obj Type");
            }
        }while (validateFromCordinate(from));
    }

    private boolean validateFromCordinate(int[] from) {
        int fromRow = from[0];
        int fromCol = from[1];

        if ( fromRow < 0 || fromRow > 5 || fromCol < 0 || fromCol > 9 ) {//make sure from tyle exist
        }
        return true;
    }
    private void connectToServer() throws IOException{
        showMassage("attempting to connect ");
        connection = new Socket(InetAddress.getByName(HOST),PORT);
        showMassage("connected to " + connection.getInetAddress().getHostName());


    }

    private void sendMessage(int message[]){

        try {
            output.writeObject( message);
            output.flush();
            showMassage(" good");
        }catch (IOException ioException){
            showMassage(" somthing is wrong with sending ");
        }
    }
    private void showMassage(final String text) {
        System.out.println(text);
    }

    private void closeStreams() {
        showMassage( " Closing connectios" );
        try {
            output.close();
            input.close();
            connection.close();
        }catch (IOException ioException){
            ioException.printStackTrace();
        }

    }
    private void setupStream() throws IOException {  //get stream to send and receive  data

        output = new ObjectOutputStream(connection.getOutputStream());//send data to someone else
        output.flush();
        input = new ObjectInputStream( connection.getInputStream());// making it possible to receive  data from  someone
        showMassage( " your streams are working" );

    }
}