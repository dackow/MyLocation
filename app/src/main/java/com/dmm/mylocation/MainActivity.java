package com.dmm.mylocation;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends ActionBarActivity implements MenuListFragment.IMenuList, OnFragmentInteractionListener {
    private List<String> menuOptionsItems = null;
    private ArrayAdapter<String> aa = null;
    private FragmentManager fragmentManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create menu fragment
        menuOptionsItems = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.menu_options)));
        aa = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, menuOptionsItems);

        fragmentManager = getFragmentManager();
        MenuListFragment menuFragment = (MenuListFragment) fragmentManager.findFragmentById(R.id.frgMenu);
        menuFragment.setListAdapter(aa);

        //invoke welcome screen first
        onItemClick(-1);
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

    @Override
    public void onItemClick(int position) {
        Fragment newFragment = null;
        switch (position) {
            case -1://Welcome
                newFragment = new WelcomeFragment();
                break;
            case 0://GPS
                newFragment = new GPSFragment();
                break;
            case 1://Network
                newFragment = new NetworkFragment();
                break;
            case 2://Cell
                newFragment = new CellFragment();
                break;
        }

        if (newFragment != null) {
            FragmentTransaction trans = fragmentManager.beginTransaction();
            trans.replace(R.id.flContent, newFragment);
            trans.addToBackStack(null);
            trans.commit();
        }

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
