package com.example.simplesqliteapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnAddData, btnViewData, btnUpdateData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddData = findViewById(R.id.btnAddData);
        btnViewData = findViewById(R.id.btnViewData);
        btnUpdateData = findViewById(R.id.btnUpdateData);


        btnAddData.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, AddDataActivity.class)));
        btnViewData.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ViewDataActivity.class)));
        btnUpdateData.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, UpdateDeleteActivity.class)));
    }
}
