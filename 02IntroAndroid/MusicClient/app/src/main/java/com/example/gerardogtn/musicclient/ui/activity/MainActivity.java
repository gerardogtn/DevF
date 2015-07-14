package com.example.gerardogtn.musicclient.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.gerardogtn.musicclient.R;
import com.example.gerardogtn.musicclient.data.model.Track;
import com.example.gerardogtn.musicclient.util.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements Response.Listener<String>, Response.ErrorListener {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String URL = "";


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

        try {
            parseTrackArray(response);
        } catch (JSONException e) {
            Log.e(LOG_TAG, "JSON parsing error");
            e.printStackTrace();
        }
    }

    private ArrayList<Track> parseTrackArray(String response) throws JSONException {
        ArrayList<Track> output = new ArrayList<>();

        JSONObject jsonResponse = new JSONObject(response);
        JSONArray jsonTracks = jsonResponse.getJSONObject("tracks").getJSONArray("track");

        for(int i = 0; i < jsonTracks.length(); i++){
            JSONObject currentJsonTrack = jsonTracks.getJSONObject(i);
            JSONObject artist = currentJsonTrack.getJSONObject("artist");
            Track currentTrack = parseTrack(currentJsonTrack, artist);
            output.add(currentTrack);
            Log.i(LOG_TAG, currentTrack.toString());
        }

        return output;
    }


    // REQUIRES: None.
    // MODIFIES: None.
    // Returns: If input is valid, returns a new Track with the info from the JSON objects.
    //          Otherwise, throws a JSONException.
    private Track parseTrack(JSONObject currentJsonTrack, JSONObject artist) throws JSONException {
        Track output = new Track();
        output.setName(currentJsonTrack.getString("name"));
        output.setDuration(robustParseInt(currentJsonTrack.getString("duration")));
        output.setPlayCount(robustParseInt(currentJsonTrack.getString("playcount")));
        output.setListeners(robustParseInt(currentJsonTrack.getString("listeners")));
        output.setArtistName(artist.getString("name"));

        return output;
    }


    // REQUIRES: None.
    // MODIFIES: None.
    // EFFECTS: If the String is empty, returns zero. Else, returns the int parsing of the string.
    private int robustParseInt(String duration){
        if (duration.isEmpty()){
            return 0;
        } else{
            return Integer.parseInt(duration);
        }
    }

    @Override
    public void onErrorResponse(VolleyError volleyError) {
        Log.e(LOG_TAG, "Parsing could not be completed");
        volleyError.printStackTrace();
    }
}
