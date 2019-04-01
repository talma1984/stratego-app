package com.example.user.stratego;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import static com.example.user.stratego.BoardTileType.FLAG;

public class GameBrain {

    BoardTile[][] board = new BoardTile[6][10];
    PlayerType currentPlayer = PlayerType.P1;

    BoardTileType[] army = new BoardTileType[]{BoardTileType.BOMB, BoardTileType.BOMB, BoardTileType.BOMB,
            FLAG, BoardTileType.SPY, BoardTileType.SCOUT, BoardTileType.SCOUT, BoardTileType.SCOUT,
            BoardTileType.SCOUT, BoardTileType.BOMB_SQUAD, BoardTileType.BOMB_SQUAD, BoardTileType.BOMB_SQUAD,
            BoardTileType.SERGEANT, BoardTileType.SERGEANT, BoardTileType.LIEUTENANT, BoardTileType.LIEUTENANT,
            BoardTileType.GENERAL, BoardTileType.MAJOR, BoardTileType.MARSHAL, BoardTileType.COLONEL,};

    public void startGame() {
        getTooPlayers();
        initializeBoard();
        while (!isGameWon()) {                  //     check for win
            ChangeBoard(currentPlayer);
            Action action = getPlayerAction(currentPlayer);      //     else show corent player board and wait for input
            updateBoard(action);                                //     perform action
            currentPlayer = getNextPlayer();                     //     end turn
        }
        ChangeBoard(currentPlayer);                               //     return to check for win

    }



    private boolean getTooPlayers() {
        int players = 0;
        if (players == 2){
            return true;
        }else {
            return false;
        }
    }

    private PlayerType getNextPlayer() {
        if ( currentPlayer == PlayerType.P1 ) {
            return PlayerType.P2;
        }
        return PlayerType.P1;
    }

    private void updateBoard(Action action) {

    }

    private Action getPlayerAction(PlayerType currentPlayer) {
        return null;
    }

    private void ChangeBoard(PlayerType currentPlayer) {

    }

    private void initializeBoard() {

        int count = 1;
        while (count < army.length)
            getBoard(army);
        count++;


    }

    private void getBoard(BoardTileType[] army) {
        if ( currentPlayer == PlayerType.P1){

        }
    }

    public boolean isGameWon() {                 // check if the game has won (whether one of the flags is missing)
        int flags = 0;
        for (int row = 0; row < board.length ; row++) {
            for (int col = 0; col < board[0].length; col++){
                if (board[row][col].content == FLAG){
                    flags++;
                }
            }
        }
        if ( flags != 2){

            return true;

        }else {
            return false;
        }


    }
}