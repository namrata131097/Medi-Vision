package com.example.rishab.task_reminder;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ReminderEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reminder_edit);

        if(getIntent() != null) {     //Section I
            Bundle extras = getIntent().getExtras();   //Section II
            int rowId = extras != null ? extras.getInt("RowId") : -1;   //Section III
            // Do stuff with the row id here
        }
    }
}
