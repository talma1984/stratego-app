package com.company;

import sun.invoke.empty.Empty;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import javax.imageio.IIOException;
import javax.swing.*;


public class Server {

    private int message;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private ServerSocket server;
    private Socket connectionOne;
    private Socket connectionTne;
    public static final int PORT = 3000;
    private static int from;
    private static int to;
    int player1 = 1;
    int player2 = 2;
    PlayerType currentPlayer = PlayerType.P1;


    public void startRunning() {

        try {
            server = new ServerSocket( PORT );
            while (true) {
                try {
                    do {
                        waitToOtherPlayer();
                        setupStreamOne();
                        creatGame();
                        whilePlaying();
                    } while (!true);
                } catch (EOFException eofException) {
                    showMassage( " the server has ended the connection " );
                } finally {
                    closeStreams();
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private int getPlayerOne() throws IIOException, IOException {

        System.out.println( " try to get players" );
        sendMessage( player1 );
        return player1;
    }

    private int getPlayerTow() throws IIOException, IOException {

        System.out.println( " try to get players" );
        sendMessage( player2 );
        return player2;
    }

    private void closeStreams() {
        showMassage( " Closing connectios" );
        try {
            output.close();
            input.close();
            connectionOne.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private void waitToOtherPlayer() throws IOException {

        showMassage( " Waiting to other player to connect    " );
        connectionOne = server.accept();
        showMassage( " Now connected to "+connectionOne.getInetAddress().getHostName() );

    }

    private void showMassage(final String text) {
        System.out.println( text );
    }

    private void setupStreamOne() throws IOException {  //get stream to send and receive  data

        output = new ObjectOutputStream( connectionOne.getOutputStream() );//send data to someone else
        output.flush();
        input = new ObjectInputStream( connectionOne.getInputStream() );// making it possible to receive  data from  someone
        showMassage( " your streams are working" );
    }

    private void whilePlaying() throws IOException { //
        showMassage( "you are now connected to the server" );
        int message;

        do {
            try {
//                printBoard( currentPlayer );
                from = (int) input.readObject();
                to = (int) input.readObject();
                getPlayers( currentPlayer );
                
                sendMessage( from );
                sendMessage( to );
                sendPlayer( currentPlayer );
                getNextPlayer();
                //     end turn
            } catch (ClassNotFoundException classNotFoundException) {
                showMassage( " somthing is wrong" );
            }
        } while (isGameWon( !true ));      //     check for win

    }

    private void creatGame() {
        int players = 0;

        do {
            try {
                players++;
                if ( players == 1 ) {
                    getPlayerOne();
                    waitToOtherPlayer();
                } else if ( players == 2 ) {
                    setupStreamOne();
                    getPlayerTow();
                } else if ( players > 2 ) {
                    startRunning();
                }
            } catch (IIOException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }while (players < 2);
    }

    private boolean isGameWon(boolean b) {
        return true;
    }

    private void sendMessage(int message) {
        try {
            output.writeObject( message);
            output.flush();
        }catch (IOException ioException){
            showMassage( "error" );
        }
    }

    private void getMessage(int message) {
        try {
            message = (int) input.readObject();
            System.out.println( message);

        }catch (IOException ioException){
            showMassage( "error" );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void sendMessageString(String message) {
        try {
            output.writeObject( message);
            output.flush();
        }catch (IOException ioException){
            showMassage( "error" );
        }
    }

    private void sendPlayer(PlayerType currentPlayer){
        try {
            output.writeObject( currentPlayer );
            output.flush();
            showMassage( " good" );
        } catch (IOException ioException) {
            showMassage( " somthing is wrong with sending " );
        }
    }
    private PlayerType getNextPlayer() {
        if ( currentPlayer == PlayerType.P1 ) {
            return PlayerType.P2;
        }
        return PlayerType.P1;
    }

    private void getPlayers(PlayerType currentPlayer){
        try {
            try {
                message = (int) input.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println( message);

        } catch (IOException ioException) {
            showMassage( " somthing is wrong with sending " );
        }
    }
}
