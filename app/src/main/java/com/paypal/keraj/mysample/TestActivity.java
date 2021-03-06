package com.paypal.keraj.mysample;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class TestActivity extends ActionBarActivity {
    public String EXTRA_MESSAGE="placeholder";
    private String[] itemList;
    private ListView drawerList;
    private DrawerLayout drawerLayout;
  //  private ActionBarDrawerToggle drawerToggle;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actionBar=getSupportActionBar();
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);
        actionBar.setLogo(R.drawable.minion);
        setContentView(R.layout.activity_test);
        itemList = getResources().getStringArray(R.array.itemList);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList=(ListView)findViewById(R.id.left_drawer);
        drawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, itemList));
        drawerList.setOnItemClickListener(new SlideMenuClickListener());
     //   actionBar=getSupportActionBar();
       // actionBar.show();
        //actionBar.setLogo(R.drawable.ic_drawer);
       //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setHomeButtonEnabled(true);


       /* drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,R.drawable.ic_drawer,R.string.drawer_open, R.string.drawer_close ){
            @Override
            public void onDrawerClosed(View drawerView) {
                invalidateOptionsMenu(); // calls onPrepareOptionsMenu()
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                invalidateOptionsMenu(); // calls onPrepareOptionsMenu()
            }
        };*/
    }

    private class SlideMenuClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            // display view for selected nav drawer item
            displayView(position);
        }
    }

    private void displayView(int position) {
        // update the main content by replacing fragments
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new MainFragment();
                break;
            case 2:
                fragment = new EndFragment();
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, fragment).commit();

            // update selected item and title, then close the drawer
            drawerList.setItemChecked(position, true);
            drawerList.setSelection(position);
            setTitle(itemList[position]);
            drawerLayout.closeDrawer(drawerList);
        } else {
           Log.e("MainActivity", "Error in creating fragment");
        }
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {
            case R.id.action_search:
                //openSearch();
                return true;
            case R.id.action_settings:
               // openSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
