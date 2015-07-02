package com.example.gerardogtn.introfragments.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gerardogtn.introfragments.R;

import butterknife.Bind;
import butterknife.ButterKnife;


public class DynamicFragment extends Fragment {


    @Bind(R.id.detail_image)
    ImageView pokemonImage;
    @Bind(R.id.detail_text)
    TextView pokemonText;
    String name;
    int attack;

    public DynamicFragment(){}

    public static DynamicFragment getInstance(){
        return getInstance("", -1);
    }

    // REQUIRES: None.
    // MODIFIES: this.
    // EFFECTS: Returns a new DynamicFragment with name name and attack atk.
    public static DynamicFragment getInstance(String name, int atk){
        DynamicFragment instance = new DynamicFragment();
        Bundle args = new Bundle();
        args.putString("name", name);
        args.putInt("attack", atk);
        instance.setArguments(args);
        return instance;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        this.name = args.getString("name", "Sin nombre.");
        this.attack = args.getInt("attack", 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.fragment_dynamic, container, false);
        ButterKnife.bind(this, root);
        drawPokemon();
        return root;
    }


    public void setName(String name){
        this.name = name;
    }

    public void setAttack(int atk){
        this.attack = atk;
    }

    public void drawPokemon() {
        setAttackText();
        if (name.toLowerCase().equals("squirtle")){
            drawSquirtle();
        } else if (name.toLowerCase().equals("bulbasaur")){
            drawBulbasaur();
        } else if (name.toLowerCase().equals("charmander")){
            drawCharmander();
        } else {
            drawNone();
        }
    }

    private void setAttackText(){
        if (this.attack >= 0){
            pokemonText.setText("Ataque: " + this.attack);
        } else {
            pokemonText.setText("");
        }
    }

    private void drawSquirtle() {
        pokemonImage.setImageResource(R.drawable.squirtle);
    }

    private void drawBulbasaur(){
        pokemonImage.setImageResource(R.drawable.bulbasaur);
    }

    private void drawCharmander(){
        pokemonImage.setImageResource(R.drawable.charmander);
    }

    private void drawNone(){
        pokemonImage.setImageResource(R.color.White);
    }
}
