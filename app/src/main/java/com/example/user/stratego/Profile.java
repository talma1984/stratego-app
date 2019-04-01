package com.example.user.stratego;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Profile extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        SharedPreferences prefs = getSharedPreferences(LoginActivity.PREFS, MODE_PRIVATE);
        String userName = prefs.getString(LoginActivity.USERNAME, LoginActivity.PASSWORD);
        if (userName != null) {
            TextView lblMessage = findViewById(R.id.lblMessage);
            lblMessage.setText("welcome " + userName + "!");
        }
    }
        public void goToMainMenu (View view){
            Intent intent = new Intent(this, MainMenu.class);
            startActivity(intent);
            finish();
        }
    }
