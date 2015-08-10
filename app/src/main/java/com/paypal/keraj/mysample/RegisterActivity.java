package com.paypal.keraj.mysample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;


public class RegisterActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void register(View view){
        UserDataOperations operations=new UserDataOperations(this);
        EditText username=(EditText)findViewById(R.id.username);
        EditText email=(EditText)findViewById(R.id.email);
        EditText password=(EditText)findViewById(R.id.password);
        UserData userData=new UserData();
        userData.UserName=username.getText().toString();
        userData.Email=email.getText().toString();
        userData.PassWord=password.getText().toString();
        operations.insert(userData);
        setContentView(R.layout.activity_test);
    }
}
