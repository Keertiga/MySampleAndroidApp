package com.paypal.keraj.mysample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
    public final static String EXTRA_MESSAGE = "com.mycompany.mySampleApp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void startSignup(View view){
    Intent intent=new Intent(this,RegisterActivity.class);
    startActivity(intent);
    }
    public void checkAuth(View view){
        UserDataOperations userDataOperations=new UserDataOperations(this);
        EditText email=(EditText)findViewById(R.id.email);
        EditText password=(EditText)findViewById(R.id.password);
        String emailVal= email.getText().toString();
        String passwordVal=password.getText().toString();
        Log.d("MainActivity","CheckAuth-email"+emailVal);
        Log.d("MainActivity","CheckAuth-password"+passwordVal);
        String username=userDataOperations.read(emailVal,passwordVal);
        Log.d("MainActivity","CheckAuth-username"+username);
        if(username!=null) {
            Intent intent=new Intent(this,TestActivity.class);
            intent.putExtra("EXTRA_MESSAGE","hello");
            startActivity(intent);
        }
    }


}
