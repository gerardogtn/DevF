package com.example.gerardogtn.layoutexamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by gerardogtn on 6/24/15.
 */
public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friska_home);
    }

}
