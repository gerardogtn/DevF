package com.example.gerardogtn.introfragments.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.gerardogtn.introfragments.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class StaticFragment extends Fragment {

    private OnPokemonSelectedListener mPokemonSelected = null;

    @Bind(R.id.squirtle_static)
    public ImageView squirtle;

    @Bind(R.id.bulbasaur_static)
    public ImageView bulbasaur;

    @Bind(R.id.charmander_static)
    public ImageView charmander;


    public StaticFragment() {}


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mPokemonSelected = (OnPokemonSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_static, container, false);
        ButterKnife.bind(this, root);
        return root;
    }


    @OnClick(R.id.squirtle_static)
    public void onSquirtleClick(){
        mPokemonSelected.onPokemonSelected("Squirtle", 83);
    }

    @OnClick(R.id.charmander_static)
    public void onCharmanderClick(){
        mPokemonSelected.onPokemonSelected("Charmander", 99);
    }

    @OnClick(R.id.bulbasaur_static)
    public void onBulbasaurClick(){
        mPokemonSelected.onPokemonSelected("Bulbasaur", 73);
    }

    public interface OnPokemonSelectedListener{
        void onPokemonSelected(String name, int atk);
    }

}
