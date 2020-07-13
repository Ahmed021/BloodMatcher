package com.ahmedabiodun.bloodmatcher;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.ahmedabiodun.bloodmatcher.MedicalDatabaseContract.AuthDataEntry;

public class DatabaseDataWorker {
    private SQLiteDatabase mDb;

    public DatabaseDataWorker(SQLiteDatabase db) {
        mDb = db;
    }

    public void insertSampleUsers() {
        insertUser("user1", "123456", "A+");
    }

    private void insertUser(String username, String password, String bloodType) {
        ContentValues values = new ContentValues();
        values.put(AuthDataEntry.COLUMN_USERNAME, username);
        values.put(AuthDataEntry.COLUMN_PASSWORD, password);
        values.put(AuthDataEntry.COLUMN_BLOOD_TYPE, bloodType);

        mDb.insert(AuthDataEntry.TABLE_NAME, null, values);
    }
}
