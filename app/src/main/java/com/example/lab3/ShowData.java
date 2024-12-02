package com.example.lab3;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ShowData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show_data);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        try {
            DBHelper myDatabaseHelper = new DBHelper(this);
            SQLiteDatabase db = myDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query("students", new String[] {"_id",
                    "FIO", "TIME"},null, null, null, null, null);

            TextView textView = (TextView) findViewById(R.id.textView1);
            textView.setText("");
            while (cursor.moveToNext()) {
                String _id = cursor.getString(0);
                String FIO = cursor.getString(1);
                String TIME = cursor.getString(2);

                textView.append(" " + _id + " "+ FIO + " " + TIME + "\n");
            }
            cursor.close();
            db.close();

        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}