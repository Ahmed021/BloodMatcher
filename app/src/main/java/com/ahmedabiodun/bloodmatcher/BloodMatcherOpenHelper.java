package com.ahmedabiodun.bloodmatcher;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;

import com.ahmedabiodun.bloodmatcher.BloodMatcherDatabaseContract.AuthDataEntry;

public class BloodMatcherOpenHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "bloodMatcher.db";
    public static final int DATABASE_VERSION = 1;
    private final Context mContext;

    public BloodMatcherOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.mContext = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(AuthDataEntry.SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //
    }

    public long addUser(String username, String password) {
        BloodMatcherOpenHelper helper = new BloodMatcherOpenHelper(mContext);
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AuthDataEntry.COLUMN_USERNAME, username);
        values.put(AuthDataEntry.COLUMN_PASSWORD, password);

        long newRowId = db.insert(AuthDataEntry.TABLE_NAME, null, values);
        return newRowId;
    }

    public boolean checkUser(String username, String password) {
        BloodMatcherOpenHelper helper = new BloodMatcherOpenHelper(mContext);
        SQLiteDatabase db = helper.getReadableDatabase();

        String[] columns = {
                BaseColumns._ID,
                AuthDataEntry.COLUMN_USERNAME,
                AuthDataEntry.COLUMN_PASSWORD
        };

        String selection = AuthDataEntry.COLUMN_USERNAME + " = ?" + " AND " +
                AuthDataEntry.COLUMN_PASSWORD + " = ?";
        String[] selectionArgs = {username, password};
        String sortOrder = AuthDataEntry.COLUMN_USERNAME + " DESC";

        Cursor cursor = db.query(AuthDataEntry.TABLE_NAME, columns, selection, selectionArgs,
                null, null, sortOrder);

        int count = cursor.getCount();
        cursor.close();

        if (count > 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
