package com.ahmedabiodun.bloodmatcher;

import android.provider.BaseColumns;

public final class MedicalDatabaseContract {
    private MedicalDatabaseContract() {}

    public static final class AuthDataEntry implements BaseColumns {
        public static final String TABLE_NAME = "auth";
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_PASSWORD = "password";
        public static final String COLUMN_BLOOD_TYPE = "blood_type";

        // CREATE TABLE auth (username, password, blood_type)
        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + "(" +
                        _ID + " INTEGER PRIMARY KEY" +
                        COLUMN_USERNAME + " TEXT UNIQUE NOT NULL, " +
                        COLUMN_PASSWORD + " TEXT NOT NULL, " +
                        COLUMN_BLOOD_TYPE + " TEXT NOT NULL)";

    }

    public static final class BloodTypeDonorsEntry implements BaseColumns{
        public static final String TABLE_NAME = "blood_type_donors";
        public static final String COLUMN_BLOOD_TYPE = "blood_type";
        public static final String COLUMN_DONATE_BLOOD_TO = "donate_blood_to";
        public static final String COLUMN_RECEIVE_BLOOD_FROM = "receive_blood_from";

        //CREATE TABLE blood_type_donors (blood_type, donate_blood_to, receive_blood_from)
        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + "(" +
                        _ID + " INTEGER PRIMARY KEY" +
                        COLUMN_BLOOD_TYPE + " TEXT UNIQUE NOT NULL, " +
                        COLUMN_DONATE_BLOOD_TO + " TEXT NOT NULL, " +
                        COLUMN_RECEIVE_BLOOD_FROM + " TEXT NOT NULL)";
    }

}
