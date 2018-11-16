package com.example.aaron.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;
private HomeFragment homefragment;
private HistoryFragment historyFragment;
    private ProfileFragment profileFragment;
    private SettingsFragment settingsFragment;
    private ChoreFragment choreFragment;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mMainFrame= (FrameLayout) findViewById(R.id.main_frame);
        mMainNav= (BottomNavigationView) findViewById(R.id.content_nav);

        homefragment= new HomeFragment();
        historyFragment= new HistoryFragment();
        choreFragment= new ChoreFragment();
        profileFragment= new ProfileFragment();
        settingsFragment= new SettingsFragment();
        setFragment(homefragment);


        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){

                    case R.id.nav_home :
                        setFragment(homefragment);
                        return true;
                    case R.id.nav_history :
                        setFragment(historyFragment);
                        return true;
                    case R.id.nav_chore :
                        setFragment(choreFragment);
                        return true;
                    case R.id.nav_profile :
                        setFragment(profileFragment);
                        return true;
                    case R.id.nav_settings :
                        setFragment(settingsFragment);
                        return true;

                    default:
                        return false;
                }




            }
        });



    }


    private void setFragment(Fragment fragment){

        FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment );
        fragmentTransaction.commit();


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
}
