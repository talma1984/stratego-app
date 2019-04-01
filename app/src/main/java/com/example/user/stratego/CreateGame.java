package com.example.user.stratego;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;


public class CreateGame extends Activity {


    private int map = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_game);
    }

    public void goToMainMenu(View view) {
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
        finish();
    }

    public void Create(View view) {
        if (map == 1) {
            Intent intent = new Intent(this, Game.class);
            startActivity(intent);
            finish();
        } else if (map == 2) {
            Intent intent = new Intent(this, Game.class);
            startActivity(intent);
            finish();
        } else if (map == 3) {
            Intent intent = new Intent(this, Game.class);
            startActivity(intent);
            finish();
        } else if (map == 4) {
            Intent intent = new Intent(this, Game.class);
            startActivity(intent);
            finish();
        }
    }

    public void btnChooseMap(View view) {
        boolean btn = ((RadioButton) view).isChecked();


        switch(view.getId()) {
            case R.id.amazonasMap:
                map = 1;

                break;
            case R.id.islandMap:
                map = 2;
                break;
            case R.id.sibiriaMap:
                map = 3;
                break;
            case R.id.SaharaMap:
                map = 4;
                break;
        }


    }

}
