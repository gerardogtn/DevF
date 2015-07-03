package com.example.gerardogtn.introactionbar;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.Snackbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class HomeActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private View layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setUpAttributes();
        setSupportActionBar(toolbar);
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
            return true;
        } else if (id == R.id.action_shopping_cart){
            sendSnackMessage("Shopping");
        }

        return super.onOptionsItemSelected(item);
    }

    private void setUpAttributes(){
        layout = findViewById(R.id.home_activity);
        toolbar = (Toolbar) findViewById(R.id.toolbar_home);
    }

    // REQUIRES: None.
    // MODIFIES: None.
    // EFFECTS: Prints the given message in a snackbar. Returns true if notification was successful.
    private boolean sendSnackMessage(String msg){
        Snackbar.make(layout, msg, Snackbar.LENGTH_SHORT).show();
        return true;
    }
}
