package com.example.aps;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context){
        super(context, "Customer.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table User(email text primary key, name text, mobile text, nic text, address text, password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists User");
    }

    public Boolean update(String name, String email, String mobile, String nic, String address) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("mobile", mobile);
        contentValues.put("nic", nic);
        contentValues.put("address", address);
        Cursor cursor = db.rawQuery("Select * from User where email = ?", new String[]{email});
        if (cursor.getCount() > 0) {
            long ins = db.update("User", contentValues, "email=?", new String[]{email});
            if (ins == -1) return false;
            else return true;
        }else{
            return false;
        }
    }

    public Boolean delete(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from User where email = ?", new String[]{email});
        if (cursor.getCount() > 0) {
            long ins = db.delete("User", "email=?", new String[]{email});
            if (ins == -1) return false;
            else return true;
        }else{
            return false;
        }
    }

    public Cursor getdata() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from User", null);
        return cursor;
    }

    public Boolean updatepass(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        Cursor cursor = db.rawQuery("Select * from User where email = ?", new String[]{email});
        if (cursor.getCount() > 0) {
            long ins = db.update("User", contentValues, "email=?", new String[]{email});
            if (ins == -1) return false;
            else return true;
        }else{
        return false;
        }
    }

}
