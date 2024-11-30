package com.example.lab3;

import android.content.ContentValues;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "students"; // Имя базы данных
    private static final int DB_VERSION = 1; // Версия базы данных
    DateFormat df = new SimpleDateFormat("dd MM yyyy, HH:mm");
    DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE DRINK ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "FIO TEXT, "
                + "TIME NUMERIC);");

        ContentValues studentValues = new ContentValues();

        studentValues.put("FIO", "Андрианов Владислав Алексеевич");
        String date = df.format(Calendar.getInstance().getTime());
        studentValues.put("TIME", date);
        db.insert("students", null, studentValues);

        studentValues.put("FIO", "Бочаров Евгений Юрьевич");
        date = df.format(Calendar.getInstance().getTime());
        studentValues.put("TIME", date);
        db.insert("students", null, studentValues);

        studentValues.put("FIO", "Бажинов Иван Сергеевич");
        date = df.format(Calendar.getInstance().getTime());
        studentValues.put("TIME", date);
        db.insert("students", null, studentValues);

        studentValues.put("FIO", "Петров Петр Петрович");
        date = df.format(Calendar.getInstance().getTime());
        studentValues.put("TIME", date);
        db.insert("students", null, studentValues);

        studentValues.put("FIO", "Романов Роман Романович");
        date = df.format(Calendar.getInstance().getTime());
        studentValues.put("TIME", date);
        db.insert("students", null, studentValues);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
