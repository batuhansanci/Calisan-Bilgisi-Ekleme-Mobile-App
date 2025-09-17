package com.example.simplesqliteapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddDataActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editName, editAge, editSalary, editRetirementAge;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        myDb = new DatabaseHelper(this);

        editName = findViewById(R.id.editName);
        editAge = findViewById(R.id.editAge);
        editSalary = findViewById(R.id.editSalary);
        editRetirementAge = findViewById(R.id.editRetirementAge);
        btnSave = findViewById(R.id.btnSave);

        addData();
    }

    public void addData() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                String age = editAge.getText().toString();
                String salary = editSalary.getText().toString();
                String retirementAge = editRetirementAge.getText().toString();

                boolean isInserted = myDb.insertData(name, age, salary, retirementAge);
                if (isInserted)
                    Toast.makeText(AddDataActivity.this, "Veri Kaydedildi", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(AddDataActivity.this, "Hata Oluştu", Toast.LENGTH_LONG).show();
            }
        });
    }
}
