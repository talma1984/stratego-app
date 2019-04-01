package com.example.user.stratego;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Rules extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

    }

    public void goToMainMenu(View view) {
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
        finish();
    }
}
