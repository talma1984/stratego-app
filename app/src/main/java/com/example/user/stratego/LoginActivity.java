package com.example.user.stratego;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Set;

public class LoginActivity extends Activity {

    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String PREFS = "prefs";
    public static final String USERS = "users";
    private EditText txtUser, txtPassword;
    private Users users;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUser = findViewById(R.id.txtUserName);
        txtPassword = findViewById(R.id.txtPassword);
        users = Users.getUsers();

        SharedPreferences prefs = getSharedPreferences(PREFS, MODE_PRIVATE);
        if(prefs.contains(USERS)){
            Set<String> usersAsString = prefs.getStringSet(USERS, null);
            users.loadUsers(usersAsString);
        }
        if(prefs.contains(USERNAME)) {
            String userName = prefs.getString(USERNAME, null);
            String password = prefs.getString(PASSWORD, null);
            user = new User(userName, password);
            txtUser.setText(user.getUserName());
            txtPassword.setText(user.getPassword());
            //goToMainMenu();
            loginOrSignup(true);
        }


    }

    public void btnSignupClicked(View view) {
        loginOrSignup(false);
    }

    public void btnLoginClicked(View view) {
        loginOrSignup(true);
    }



    public void goToMainMenu(){
        Intent intent = new Intent(this, MainMenu.class);
        SharedPreferences prefs = getSharedPreferences(PREFS, MODE_PRIVATE);
        prefs.edit().putString(USERNAME, user.getUserName()).commit();
        startActivity(intent);
        finish();
    }

    public void goToMain(View view) {
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
        finish();

    }

    private void loginOrSignup(boolean isLogin){
        user = getUserFromUI();
        if(user == null)
            return;
        String message = null;
        if(isLogin){
            if(!users.login(user)){
                message = "username or password are incorrect";
            }
        }else{//signup
            if(!users.signup(user)){
                message = "username taken";
            }
        }
        if(message != null){
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }else {
            SharedPreferences prefs = getSharedPreferences(PREFS, MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString(USERNAME, user.getUserName())
                    .putString(PASSWORD, user.getPassword());
            if(!isLogin){
                Set<String> usersAsString = users.getUsersAsString();
                editor.putStringSet(USERS, usersAsString);
            }

            editor.commit();
            goToMainMenu();
        }
    }



    private User getUserFromUI(){
        String userName = txtUser.getText().toString();
        String password = txtPassword.getText().toString();
        if(userName.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "both username and password are mandatory!",
                    Toast.LENGTH_SHORT).show();
            return null;
        }
        return new User(userName, password);
    }
}