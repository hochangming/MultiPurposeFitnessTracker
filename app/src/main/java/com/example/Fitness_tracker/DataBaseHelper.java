package com.example.Fitness_tracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Health.db";
    public static final String TABLE_NAME = "Health";
    public static final String TABLE_NAME1 = "MultiTrack";
    public static final String COL1 = "NAME";
    public static final String COL2 = "AGE";
    public static final String COL3 = "WEIGHT";
    public static final String COL4 = "DAILY_CALORIC_INTAKE";

    public static final String COLUMN1 = "NAME";
    public static final String COLUMN2 = "SETS";
    public static final String COLUMN3 = "REPS";
    public static final String COLUMN4 = "TIME_TAKEN";
    Context con;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        con = context;
    }
    // **** CRUD (Create, Read, Update, Delete) Operations ***** //

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + "(NAME TEXT, " +
                " AGE INT, WEIGHT INT, DAILY_CALORIC_INTAKE INT)";
        String createTable1 = "CREATE TABLE " + TABLE_NAME1 + "(NAME TEXT, " +
                " SETS INT, REPS INT, TIME_TAKEN INT)";
        db.execSQL(createTable);
        db.execSQL(createTable1);
        db.execSQL("Create table user(email text primary key, password text)");

        Toast.makeText(con, "Table Created", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        db.execSQL("drop table if exists user");
        onCreate(db);
    }

    public boolean InsertData(String name, int age, int weight, int dailyCaloricIntake) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, String.valueOf(name));
        contentValues.put(COL2, age);
        contentValues.put(COL3, weight);
        contentValues.put(COL4, dailyCaloricIntake);

        long result = db.insert(TABLE_NAME, null, contentValues);
        Log.d("MI", result + "");

        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }

    public boolean insert_Data(String name, int sets_, int reps, int timeTaken) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN1, String.valueOf(name));
        contentValues.put(COLUMN2, sets_);
        contentValues.put(COLUMN3, reps);
        contentValues.put(COLUMN4, timeTaken);

        long result = db.insert(TABLE_NAME1, null, contentValues);
        Log.d("MI", result + "");

        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }

    public boolean insert(String email, String Password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", Password);
        long result = db.insert("user", null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void deleteProduct(String name) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE " + COL1 + "='" + name + "';");
    }

    public void delete_Product(String name) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME1 + " WHERE " + COLUMN1 + "='" + name + "';");
    }

    //query for outputting the whole table
    public Cursor getListContents() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return cursor;
    }

    //query for outputting the whole table
    public Cursor get_List_Contents() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME1, null);
        return cursor;
    }

    public boolean checkemail(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where email=?", new String[]{email});
        if (cursor.getCount() > 0) return false;
        else return true;
    }

    public boolean emailPassword(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where email=? and password =?", new String[]{email, password});
        if (cursor.getCount() > 0) return true;
        else return false;
    }

}
