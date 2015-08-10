package com.paypal.keraj.mysample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by keraj on 8/8/2015.
 */
public class UserDataHelper extends SQLiteOpenHelper {

      private static final int DATABASE_VERSION = 1;
      private static final String DATABASE_NAME = "SampleData.db";

      public UserDataHelper(Context context ) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

      @Override
            public void onCreate(SQLiteDatabase db) {
            //All necessary tables you like to create will create here

            String CREATE_TABLE_USERDATA = "CREATE TABLE " + UserData.TABLE  + "("
                    + UserData.COL_USERNAME + " TEXT PRIMARY KEY,"
                    + UserData.COL_EMAIL + " TEXT, "
                    + UserData.COL_PASSWORD + " TEXT )";

            db.execSQL(CREATE_TABLE_USERDATA);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // Drop older table if existed, all data will be gone!!!
            db.execSQL("DROP TABLE IF EXISTS " + UserData.TABLE);

            // Create tables again
            onCreate(db);
        }


    }