package com.example.simplesqliteapp;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ViewDataActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    TextView textViewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        myDb = new DatabaseHelper(this);
        textViewData = findViewById(R.id.textViewData);

        viewAllData();
    }

    public void viewAllData() {
        Cursor res = myDb.getAllData();

        if (res.getCount() == 0) {
            textViewData.setText("Kayıt Bulunamadı");
            return;
        }

        StringBuilder buffer = new StringBuilder();
        while (res.moveToNext()) {
            buffer.append("ID: ").append(res.getString(0)).append("\n");
            buffer.append("İsim: ").append(res.getString(1)).append("\n");
            buffer.append("Yaş: ").append(res.getString(2)).append("\n");
            buffer.append("Maaş: ").append(res.getString(3)).append("\n");
            buffer.append("Emekli: ").append(res.getString(4)).append("\n\n");
        }

        textViewData.setText(buffer.toString());
    }
}
