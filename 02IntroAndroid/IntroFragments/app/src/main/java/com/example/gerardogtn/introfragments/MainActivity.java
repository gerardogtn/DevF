package com.example.gerardogtn.introfragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.gerardogtn.introfragments.fragment.DynamicFragment;
import com.example.gerardogtn.introfragments.fragment.StaticFragment;


public class MainActivity extends AppCompatActivity implements StaticFragment.OnPokemonSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addDynamicFragment();
    }

    private void addDynamicFragment(){
        addDynamicFragment("", -1);
    }

    private void addDynamicFragment(String name, int atk){
        FragmentTransaction tm = getSupportFragmentManager().beginTransaction();
        tm.replace(R.id.dynamic_fragment, DynamicFragment.getInstance(name, atk));
        tm.commit();
    }


    @Override
    public void onPokemonSelected(String name, int atk) {
        addDynamicFragment(name, atk);
    }
}
