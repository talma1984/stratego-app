package com.example.user.stratego;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EndGame extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);
    }

    public void goToMainMenu(View view) {
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
        finish();
    }

    public void btnCreateNewGame(View view) {
        Intent intent = new Intent(this, CreateGame.class);
        startActivity(intent);
        finish();
    }

    public void btnQuickGame(View view) {
        Intent intent = new Intent(this, GameRoom.class);
        startActivity(intent);
        finish();
    }

    public void btnexit(View view) {
        finish();
    }
}