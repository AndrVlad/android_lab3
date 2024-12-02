package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            DBHelper myDatabaseHelper = new DBHelper(this);
            SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
            myDatabaseHelper.resetStudentsTable();
            db.close();
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    public void onClickBtn1(View view) {
        Intent intent = new Intent(this, ShowData.class);
        startActivity(intent);
    }

    public void onClickBtn2(View view) {

    }

    public void onClickBtn3(View view) {

    }
}