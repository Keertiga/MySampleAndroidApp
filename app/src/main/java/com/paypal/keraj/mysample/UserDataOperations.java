package com.paypal.keraj.mysample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by keraj on 8/8/2015.
 */
public class UserDataOperations {
    private UserDataHelper helper;

    public UserDataOperations(Context context){
        helper=new UserDataHelper(context);
    }

    public int insert(UserData userData){
        SQLiteDatabase db=helper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(userData.COL_USERNAME,userData.UserName);
        values.put(userData.COL_EMAIL,userData.Email);
        values.put(userData.COL_PASSWORD,userData.PassWord);
        long returnValue=db.insert(userData.TABLE,null,values);
        db.close();
        return (int) returnValue;
    }

    public String read(String email,String password){
        String retValue=null;
        SQLiteDatabase db=helper.getReadableDatabase();
        ArrayList<HashMap<String,String>> userList=new ArrayList<HashMap<String,String>>();
        String[] projection={UserData.COL_USERNAME};
        String selection=UserData.COL_EMAIL+"=? and "+UserData.COL_PASSWORD+"=?";
      // String selection=UserData.COL_EMAIL+"='"+email+"' and "+UserData.COL_PASSWORD+"='"+password+"'";
        String[] selectArgs={email,password};
       // String sqlQuery= SQLiteQueryBuilder.buildQueryString(false,UserData.TABLE,null,selection,null,null,null,null);
       // Log.d("UserDataOperations","ReadsqlQuery"+sqlQuery);
        Cursor cursor=db.query(UserData.TABLE, projection, selection, selectArgs, null, null, null);
       // Cursor cursor=db.rawQuery(sqlQuery,null);
        Log.d("UserDataOperations", "read-count" +cursor.getCount() );
        cursor.moveToFirst();
        if(cursor.getCount()==1) {
            Log.d("UserDataOperations", "Inside read-count");
            retValue = cursor.getString(cursor.getColumnIndexOrThrow(UserData.COL_USERNAME));
            Log.d("UserDataOperations","read-return String"+retValue);
        }
        db.close();
        return retValue;

      /*  if(cursor.moveToFirst()){
            do{
               HashMap<String,String> user=new HashMap<String,String>();
                user.put("username",cursor.getString(cursor.getColumnIndexOrThrow(UserData.COL_USERNAME)));
                user.put("email",cursor.getString(cursor.getColumnIndexOrThrow(UserData.COL_EMAIL)));
                user.put("password",cursor.getString(cursor.getColumnIndexOrThrow(UserData.COL_PASSWORD)));
            }while(cursor.moveToNext());
        }*/

    }
}
