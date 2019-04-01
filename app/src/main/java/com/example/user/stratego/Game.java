package com.example.user.stratego;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import static com.example.user.stratego.BoardTileType.FLAG;

public class Game extends Activity {

    GameBrain gameBrain = new GameBrain();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        SharedPreferences prefs = getSharedPreferences(LoginActivity.PREFS, MODE_PRIVATE);
        String userName = prefs.getString(LoginActivity.USERNAME, LoginActivity.PASSWORD);


        Client client = new Client(Client.HOST);
        client.startRunning();
//       do {
//           gameBrain.startGame();
//       }
//
//       while (gameBrain.isGameWon() == true);
//            goToEndGame();
    }
    public void goToEndGame() {

        Intent intent = new Intent(this, EndGame.class);
        startActivity(intent);
        finish();
    }


}