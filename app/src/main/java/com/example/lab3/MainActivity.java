package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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