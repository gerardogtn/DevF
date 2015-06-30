package com.example.gerardogtn.introfragments;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.gerardogtn.introfragments.fragment.DynamicFragment;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addDynamicFragment();
    }

    private void addDynamicFragment(){
        FragmentTransaction tm = getSupportFragmentManager().beginTransaction();
        tm.add(R.id.dynamic_fragment, DynamicFragment.getInstance("Charizard", 23));
        tm.commit();
    }

}
