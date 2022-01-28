package com.ozturkomerfaruk.a24aralikuygulama;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    static final String DATABASE_NAME = "myDatabase";
    static final String TABLE_NAME = "UserTable";
    static final int DATABASE_VERSION = 1;

    static final String UID = "_id";
    static final String NAME = "Name";
    static final String SURNAME = "Surname";
    static final String PASSWORD = "Password";
    static final String GENDER = "Gender";
    static final String AGE = "Age";

    Context context;

    static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" +
            UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NAME + " VARCHAR(255) , " +
            SURNAME + " VARCHAR(255) , " +
            PASSWORD + " VARCHAR(255) , " +
            GENDER + " VARCHAR(255) , " +
            AGE + " AGE(255))";

    public DBHelper(Context _context) {
        super(_context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = _context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(CREATE_TABLE);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
