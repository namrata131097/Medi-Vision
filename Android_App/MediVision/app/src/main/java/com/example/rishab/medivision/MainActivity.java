package com.example.rishab.medivision;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


    public  void open_register(View view){
        Intent myIntent = new Intent(MainActivity.this, Registeration.class);
        startActivity(myIntent);
    }

    public  void open_appoint(View view){
        Intent myIntent = new Intent(MainActivity.this, Appoint.class);
        startActivity(myIntent);
    }

    public  void open_reminder(View view){
        Intent myIntent = new Intent(MainActivity.this, Reminder.class);
        startActivity(myIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
