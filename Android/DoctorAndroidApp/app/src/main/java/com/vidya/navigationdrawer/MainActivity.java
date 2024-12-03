package com.vidya.navigationdrawer;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.vidya.navigationdrawer.ui.login.ui.main.LoginDataFragment;

import androidx.core.app.ActivityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private boolean READ_PHONE_STATE_granted = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        fab.setVisibility(View.GONE);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        navigationView.setItemIconTintList(null);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


       // NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        // for getting menu from navigationView
        Menu menu = navigationView.getMenu();

        // finding menuItem that you want to change
        MenuItem nav_connection = menu.findItem(R.id.nav_home);

        // set new title to the MenuItem"change name from connection to logout"
        nav_connection.setTitle("Appointments");

        MenuItem nav_connection1 = menu.findItem(R.id.nav_gallery);

        // set new title to the MenuItem"change name from connection to logout"
        nav_connection1.setTitle("Specialist");

        MenuItem nav_connection2 = menu.findItem(R.id.nav_slideshow);
        nav_connection2.setTitle("logout");


        MenuItem nav_connection3 = menu.findItem(R.id.userproblemFragment);
        nav_connection3.setTitle("Consult");


        MenuItem nav_connection4 = menu.findItem(R.id.reviewtheappfragment);
        nav_connection4.setTitle("My doctors");


        MenuItem nav_connection5 = menu.findItem(R.id.chatfragment);
        nav_connection5.setTitle("Chat with doctor");
        // set new title to the MenuItem"change name from connection to logout"
        //nav_connection2.setVisible(false);
        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.textView1forheader);
        navUsername.setText("Welcome "+ LoginDataFragment.usernameglobal);


        TextView email = (TextView) headerView.findViewById(R.id.textView);
        email.setText("");

       // View hView =  navigationView.inflateHeaderView(R.layout.nav_header_main);
        ImageView imgvw = (ImageView)headerView.findViewById(R.id.imageView);

        imgvw.setImageResource(R.drawable.ic_menu_gallery);
        // add NavigationItemSelectedListener to check the navigation clicks
       // navigationView.setNavigationItemSelectedListener(MainActivity.this);

        CheckPermission();
    }

    private void CheckPermission() {


        int PERMISSION_ALL = 1;

        if (Build.VERSION.SDK_INT >= 23) {
            String[] PERMISSIONS = {
                    android.Manifest.permission.ACCESS_FINE_LOCATION,
                    android.Manifest.permission.CAMERA,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.CALL_PHONE
            };

            if (!hasPermissions(this, PERMISSIONS)) {
                ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
                READ_PHONE_STATE_granted = true;
            } else {


                //   finish();
            }
        } else {


            //  finish();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
    public static boolean hasPermissions(Context context, String... permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

}