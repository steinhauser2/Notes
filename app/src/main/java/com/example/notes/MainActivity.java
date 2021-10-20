package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("com.example.notes", Context.MODE_PRIVATE);

        if(!sharedPreferences.getString("username","").equals("")) {
            showMessage(sharedPreferences.getString("username", ""));
        }
        else {
            setContentView(R.layout.activity_main);
        }
    }

    public void handleLoginButton(View view) {
        EditText userName = findViewById(R.id.userNameText);
        String userStr = userName.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("com.example.notes", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("username", userStr).apply();

        showMessage(userStr);
    }

    public void showMessage(String s) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("message", s);
        startActivity(intent);
    }
}