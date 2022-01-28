package com.ozturkomerfaruk.a24aralikuygulama;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DBAdapter {
    DBHelper myHelper;

    public DBAdapter(Context context) {
        myHelper = new DBHelper(context);
    }

    public long insertDataString(String Name, String Surname, String Password, String Genger, String Age) {
        SQLiteDatabase sqLiteDatabase = myHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(myHelper.NAME, Name);
        contentValues.put(myHelper.SURNAME, Surname);
        contentValues.put(myHelper.PASSWORD, Password);
        contentValues.put(myHelper.GENDER, Genger);
        contentValues.put(myHelper.AGE, Age);

        long id = sqLiteDatabase.insert(myHelper.TABLE_NAME, null, contentValues);
        return id;
    }

    public List<String> getData() {
        SQLiteDatabase sqLiteDatabase = myHelper.getWritableDatabase();

        String[] columns = {myHelper.UID, myHelper.NAME, myHelper.SURNAME, myHelper.PASSWORD, myHelper.GENDER, myHelper.AGE};
        Cursor cursor = sqLiteDatabase.query(myHelper.TABLE_NAME, columns, null, null, null, null, null);
        List<String> list = new ArrayList<String>();
        while (cursor.moveToNext()) {
            StringBuffer buffer = new StringBuffer();
            int uid = cursor.getInt(0);
            String name = cursor.getString(1);
            String surname = cursor.getString(2);
            String password = cursor.getString(3);
            String gender = cursor.getString(4);
            String age = cursor.getString(5);
            buffer.append(uid + "," +
                    name + "," +
                    surname + "," +
                    password + "," +
                    gender + "," +
                    age);
            list.add(buffer.toString());
        }
        return list;
    }

    public int delete(int Uid) {
        SQLiteDatabase sqLiteDatabase = myHelper.getWritableDatabase();
        String[] whereArg = {String.valueOf(Uid)};
        int count = sqLiteDatabase.delete(myHelper.TABLE_NAME, myHelper.UID + " =?", whereArg);
        return count;
    }

    public int update(int Uid, String NewName, String NewSurname, String NewPassword, String NewGender, String NewAge) {

        SQLiteDatabase sqLiteDatabase = myHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(myHelper.NAME, NewName);
        contentValues.put(myHelper.SURNAME, NewSurname);
        contentValues.put(myHelper.PASSWORD, NewPassword);
        contentValues.put(myHelper.GENDER, NewGender);
        contentValues.put(myHelper.AGE, NewAge);

        String[] whereArg = {String.valueOf(Uid)};

        int count = sqLiteDatabase.update(myHelper.TABLE_NAME, contentValues, myHelper.UID + " =?", whereArg);
        return count;
    }
}
