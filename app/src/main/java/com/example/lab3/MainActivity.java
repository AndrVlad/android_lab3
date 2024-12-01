package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    DateFormat df = new SimpleDateFormat("dd MM yyyy, HH:mm");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            DBHelper myDatabaseHelper = new DBHelper(this);
            db = myDatabaseHelper.getWritableDatabase();
            myDatabaseHelper.resetStudentsTable();

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
        ContentValues studentValues = new ContentValues();
        String date = df.format(Calendar.getInstance().getTime());

        studentValues.put("FIO", "Кашеваров Андрей Евгеньевич");
        studentValues.put("TIME", date);
        if(db.insert("students", null, studentValues) == -1) {
            Toast toast = Toast.makeText(this, "Ошибка при добавлении записи", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Toast toast = Toast.makeText(this, "Запись добавлена", Toast.LENGTH_SHORT);
            toast.show();
        };
    }

    public void onClickBtn3(View view) {

    }

    protected void onDestroy() {
        super.onDestroy();
        if (db != null) {
            db.close();
        }
    }
}