package com.example.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView welcomeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        welcomeText = (TextView) findViewById(R.id.textView);
        Intent intent = getIntent();
        String str = intent.getStringExtra("message");
        welcomeText.setText("Welcome " + str + "!");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.notes_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.logout_menu:
                Intent intent = new Intent(this, MainActivity.class);
                SharedPreferences sharedPreferences = getSharedPreferences("com.example.notes", Context.MODE_PRIVATE);
                sharedPreferences.edit().remove("username").apply();
                startActivity(intent);
                break;
            case R.id.notes_menu:

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}