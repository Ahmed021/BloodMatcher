package com.ahmedabiodun.medical;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.ahmedabiodun.medical.MedicalDatabaseContract.AuthDataEntry;

public class MedicalOpenHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Medical.db";
    public static final int DATABASE_VERSION = 1;

    public MedicalOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(AuthDataEntry.SQL_CREATE_TABLE);
        db.execSQL(MedicalDatabaseContract.BloodTypeDonorsEntry.SQL_CREATE_TABLE);

        DatabaseDataWorker worker = new DatabaseDataWorker(db);
        worker.insertSampleUsers();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //
    }

    public int addUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AuthDataEntry.COLUMN_USERNAME, username);
        values.put(AuthDataEntry.COLUMN_PASSWORD, password);

        int result = (int) db.insert(AuthDataEntry.TABLE_NAME, null, values);
        return result;
    }

    public boolean checkUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = {AuthDataEntry._ID};

        String selection = AuthDataEntry.COLUMN_USERNAME + " = ?" + " AND " +
                AuthDataEntry.COLUMN_PASSWORD + " = ?";
        String[] selectionArgs = {username, password};
        Cursor cursor = db.query(AuthDataEntry.TABLE_NAME, columns, selection, selectionArgs,
                null, null, null);

        int count = cursor.getCount();
        cursor.close();
        db.close();


        if (count > 0)
            return true;
        else
            return false;
    }
}
