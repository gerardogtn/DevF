package com.example.gerardogtn.introfragments;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.gerardogtn.introfragments.fragment.DynamicFragment;
import com.example.gerardogtn.introfragments.fragment.StaticFragment;


public class MainActivity extends AppCompatActivity implements StaticFragment.OnPokemonSelectedListener{
    DynamicFragment dynamicFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addDynamicFragment();
    }

    private void addDynamicFragment(){
        FragmentTransaction tm = getSupportFragmentManager().beginTransaction();
        dynamicFragment = DynamicFragment.getInstance();
        tm.replace(R.id.dynamic_fragment, dynamicFragment);
        tm.commit();
    }

    @Override
    public void onPokemonSelected(String name, int atk) {
        dynamicFragment.setName(name);
        dynamicFragment.setAttack(atk);
        dynamicFragment.drawPokemon();
    }
}
