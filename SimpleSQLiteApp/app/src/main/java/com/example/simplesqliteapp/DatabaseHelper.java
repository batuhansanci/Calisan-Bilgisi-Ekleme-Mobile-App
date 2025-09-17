package com.example.simplesqliteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Veritabanı ve tablo bilgileri
    private static final String DATABASE_NAME = "UserData.db";
    private static final String TABLE_NAME = "user_table";
    private static final String COL_1 = "ID"; // Otomatik Artan ID
    private static final String COL_2 = "NAME"; // İsim
    private static final String COL_3 = "AGE"; // Yaş
    private static final String COL_4 = "SALARY"; // Maaş
    private static final String COL_5 = "RETIREMENT_AGE"; // Emeklilik Yaşı

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NAME TEXT, AGE INTEGER, SALARY REAL, RETIREMENT_AGE INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Veri ekleme
    public boolean insertData(String name, String age, String salary, String retirementAge) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, age);
        contentValues.put(COL_4, salary);
        contentValues.put(COL_5, retirementAge);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    // Veri güncelleme
    public boolean updateData(String id, String name, String age, String salary, String retirementAge) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, age);
        contentValues.put(COL_4, salary);
        contentValues.put(COL_5, retirementAge);
        int result = db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{id});
        return result > 0;
    }

    // Veri silme
    public Integer deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[]{id});
    }

    // Tüm verileri getirme
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }
}
