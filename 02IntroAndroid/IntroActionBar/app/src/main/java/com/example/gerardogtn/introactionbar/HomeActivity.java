package com.example.gerardogtn.introactionbar;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.Snackbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import butterknife.Bind;
import butterknife.ButterKnife;


public class HomeActivity extends AppCompatActivity {

    @Bind(R.id.toolbar_home)
    public Toolbar toolbar;

    @Bind(R.id.navigation_view)
    public NavigationView layout;

    @Bind(R.id.drawer_layout)
    public DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        replaceToolbar();
    }

    private void replaceToolbar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.action_settings) {
            sendSnackMessage("Settings");
        } else if (id == R.id.action_search){
            sendSnackMessage("Searching");
        } else if (id == R.id.action_shopping_cart){
            sendSnackMessage("Shopping");
        } else if (id == android.R.id.home ){
            drawerLayout.openDrawer(GravityCompat.START);
        }

        return super.onOptionsItemSelected(item);
    }


    // REQUIRES: None.
    // MODIFIES: None.
    // EFFECTS: Prints the given message in a snackbar. Returns true if notification was successful.
    private boolean sendSnackMessage(String msg){
        Snackbar.make(layout, msg, Snackbar.LENGTH_SHORT).show();
        return true;
    }
}
