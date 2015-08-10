package com.paypal.keraj.mysample;

import android.provider.BaseColumns;

/**
 * Created by keraj on 8/8/2015.
 */
public class UserData {

    public static final String TABLE = "UserData";
    public static final String COL_USERNAME = "UserName";
    public static final String COL_EMAIL = "Email";
    public static final String COL_PASSWORD = "Password";

    public String UserName;
    public String Email;
    public String PassWord;
}
