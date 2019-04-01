package com.example.user.stratego;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



public class MainMenu extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        SharedPreferences prefs = getSharedPreferences(LoginActivity.PREFS, MODE_PRIVATE);
        String userName = prefs.getString(LoginActivity.USERNAME, LoginActivity.PASSWORD);
        if(userName != null){
            TextView lblMessage = findViewById(R.id.lblMessage);
            lblMessage.setText("welcome " + userName + "!");


        }


    }

    public void btnLogoutClicked(View view) {
        SharedPreferences prefs = getSharedPreferences(LoginActivity.PREFS, MODE_PRIVATE);
        prefs.edit().remove(LoginActivity.USERNAME).remove(LoginActivity.PASSWORD).commit();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();

    }

    public void btnStartNewGame(View view) {
        Intent intent = new Intent(this,PlayerVsPlayer.class);
        startActivity(intent);
        finish();
    }

    public void btnGameRules(View view) {
        Intent intent = new Intent(this,Rules.class);
        startActivity(intent);
        finish();
    }

    public void quickGame(View view) {
        Intent intent = new Intent(this,Game.class);
        startActivity(intent);
        finish();
    }

    public void btnGoToProfile(View view) {
        Intent intent = new Intent(this,Profile.class);
        startActivity(intent);
        finish();
    }
}