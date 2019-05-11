package com.example.mark.flavia;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent= new Intent(Main2Activity.this,ListActivity.class);
               startActivity(intent);
            }
        });




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.sqlite) {
            Intent inten= new Intent(Main2Activity.this,SqliteActivity.class);
            startActivity(inten);
            return true;
        }else if (id == R.id.fragments) {
            Intent inte= new Intent(Main2Activity.this,MainActivity.class);
            startActivity(inte);
            return true;
        }if (id == R.id.shared) {
            Intent flavia= new Intent(Main2Activity.this,sharedPrefeActivity.class);
            startActivity(flavia);
            return true;
        }if (id == R.id.exit) {
            Intent flavias= new Intent(Main2Activity.this,ListActivity.class);
            startActivity(flavias);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Fragments) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.nav_SharedPreferences) {
            Intent intent = new Intent(getApplicationContext(),sharedPrefeActivity.class );
            startActivity(intent);

        } else if (id == R.id.nav_Broadcoast_receivers) {
            MyReceiver mr = new MyReceiver();
            Toast.makeText(getApplicationContext(), "Broad cast started", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_sqlite) {
            Intent intent = new Intent(getApplicationContext(),SqliteActivity.class);
            startActivity(intent);

        }else if (id == R.id.search) {
            Intent intents = new Intent(getApplicationContext(), ListActivity.class);
            startActivity(intents);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
