package com.example.gerardogtn.introfragments.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gerardogtn.introfragments.R;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;


public class DynamicFragment extends Fragment {

    HashMap<String, Integer> imageId;

    @Bind(R.id.detail_image)
    ImageView pokemonImage;

    @Bind(R.id.detail_text)
    TextView pokemonText;
    
    String name;
    int attack;

    public DynamicFragment(){
        imageId = new HashMap<>();
        imageId.put("Charmander", R.drawable.charmander);
        imageId.put("Bulbasaur", R.drawable.bulbasaur);
        imageId.put("Squirtle", R.drawable.squirtle);
    }

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

    // REQUIRES: None.
    // MODIFIES: this.
    // EFFECTS: Sets pokemonText to the appropiate text and pokemonImage to the appropiate img.
    public void drawPokemon() {
        setAttackText();
        drawImage();
    }

    // REQUIRES: NONE.
    // MODIFIES: this.
    // EFFECTS: Gets the resource of the appropiate image through the imageId map. If a value
    // exists, draws the appropiate image. Else draws white background.
    private void drawImage(){
        Integer resourceId = imageId.get(this.name);
        if (resourceId != null) {
            drawAbstract(resourceId);
        } else {
            drawNone();
        }
    }

    // REQUIRES: None.
    // MODIFIES: this.
    // EFFECTS: If this.attack is positive then notifies it through the user through pokemonText.
    //          Else sets pokemonText empty.
    private void setAttackText(){
        if (this.attack >= 0){
            pokemonText.setText("Ataque: " + this.attack);
        } else {
            pokemonText.setText("");
        }
    }

    // REQUIRES: resourceId is a valid resource.
    // MODIFIES: this
    // EFFECTS: Sets this.pokemonImage to the given resourceId.
    private void drawAbstract(int resourceId){
        pokemonImage.setImageResource(resourceId);
    }

    // REQUIRES: None.
    // MODIFIES: this.
    // EFFECTS: Sets this.pokemonImage to the color white.
    private void drawNone(){
        drawAbstract(R.color.white);
    }
}
