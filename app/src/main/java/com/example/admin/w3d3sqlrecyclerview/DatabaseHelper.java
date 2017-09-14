package com.example.admin.w3d3sqlrecyclerview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by admin on 9/13/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MY_DATABASE";
    public static final String TABLE_NAME = "Animals";
    public static final String ANIMAL_ID = "animal_id";
    public static final String ANIMAL_NAME = "name";
    public static final String ANIMAL_TYPE = "type";
    public static final String ANIMAL_AGE = "age";
    public static final String ANIMAL_WEIGHT = "weight";
    public static final String ANIMAL_IMG1 = "img1";
    public static final String ANIMAL_IMG2 = "img2";
    public static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" +
                ANIMAL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ANIMAL_NAME + " TEXT, " +
                ANIMAL_TYPE + " TEXT, " +
                ANIMAL_AGE + " INTEGER, " +
                ANIMAL_WEIGHT + " INTEGER, " +
                ANIMAL_IMG1 + " INTEGER," +
                ANIMAL_IMG2 + " INTEGER" +
                ")";

        sqLiteDatabase.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long saveAnimal(String name, String type, int age, int weight, int img1, int img2){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ANIMAL_NAME, name);
        contentValues.put(ANIMAL_TYPE, type);
        contentValues.put(ANIMAL_AGE, age);
        contentValues.put(ANIMAL_WEIGHT, weight);
        contentValues.put(ANIMAL_IMG1, img1);
        contentValues.put(ANIMAL_IMG2, img2);
        long saved = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        return saved;
    }

    public ArrayList<Animal> getAnimals(){
        ArrayList<Animal> Selection = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        if (cursor.moveToFirst()){
            do {
                Animal tmp = new Animal(cursor.getInt(0),cursor.getString(1),cursor.getString(2),
                        cursor.getInt(3),cursor.getInt(4),cursor.getInt(5),cursor.getInt(6));
                Selection.add(tmp);
            }while (cursor.moveToNext());
        }
        return Selection;
    }

    public void deleteAnimal(int id) {
        //Log.d(TAG, "deleteContact: " + email);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME,ANIMAL_ID + " = " + id,null);
        //sqLiteDatabase.delete(TABLE_NAME,null,CONTACT_EMAIL + " " + s);
    }
}
