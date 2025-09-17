package com.example.simplesqliteapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class UpdateDeleteActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editId, editName, editAge, editSalary, editRetirementAge;
    Button btnUpdate, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);

        // DatabaseHelper Nesnesini Başlat
        myDb = new DatabaseHelper(this);

        // XML Bileşenlerini Bağlama
        editId = findViewById(R.id.editId);
        editName = findViewById(R.id.editName);
        editAge = findViewById(R.id.editAge);
        editSalary = findViewById(R.id.editSalary);
        editRetirementAge = findViewById(R.id.editRetirementAge);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        // Metotları Çağırma
        updateData();
        deleteData();
    }

    // Veri Güncelleme Metodu
    public void updateData() {
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // EditText'lerden Veri Al
                String id = editId.getText().toString().trim();
                String name = editName.getText().toString().trim();
                String age = editAge.getText().toString().trim();
                String salary = editSalary.getText().toString().trim();
                String retirementAge = editRetirementAge.getText().toString().trim();

                // Boş Alan Kontrolü
                if (id.isEmpty() || name.isEmpty() || age.isEmpty() || salary.isEmpty() || retirementAge.isEmpty()) {
                    Toast.makeText(UpdateDeleteActivity.this, "Lütfen Tüm Alanları Doldurun", Toast.LENGTH_LONG).show();
                    return;
                }

                // Veriyi Güncelle
                boolean isUpdated = myDb.updateData(id, name, age, salary, retirementAge);
                if (isUpdated) {
                    Toast.makeText(UpdateDeleteActivity.this, "Veri Güncellendi", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(UpdateDeleteActivity.this, "Güncelleme Başarısız", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    // Veri Silme Metodu
    public void deleteData() {
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ID Al
                String id = editId.getText().toString().trim();

                // Boş ID Kontrolü
                if (id.isEmpty()) {
                    Toast.makeText(UpdateDeleteActivity.this, "Lütfen Bir ID Girin", Toast.LENGTH_LONG).show();
                    return;
                }

                // Veriyi Sil
                int isDeleted = myDb.deleteData(id);
                if (isDeleted > 0) {
                    Toast.makeText(UpdateDeleteActivity.this, "Veri Silindi", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(UpdateDeleteActivity.this, "Silme İşlemi Başarısız", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
