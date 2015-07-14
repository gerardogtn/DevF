package com.example.gerardogtn.musicclient.ui.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.gerardogtn.musicclient.R;
import com.example.gerardogtn.musicclient.util.VolleySingleton;


public class MainActivity extends AppCompatActivity implements Response.Listener<String>, Response.ErrorListener {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String URL = "http://ws.audioscrobbler.com/2.0/?method=chart.gettoptracks&api_key=123ae7ccee87798c55c82b64c792a083&format=json";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        StringRequest topTracks = new StringRequest(Request.Method.GET, URL, this, this);
        VolleySingleton.getInstance(this).addToRequestQueue(topTracks);
    }

    @Override
    public void onResponse(String response) {
        Toast.makeText(this, "Request was succesful", Toast.LENGTH_SHORT).show();
        Log.i(LOG_TAG, response);
    }

    @Override
    public void onErrorResponse(VolleyError volleyError) {
        Log.e(LOG_TAG, "Parsing could not be completed");
        volleyError.printStackTrace();
    }
}
