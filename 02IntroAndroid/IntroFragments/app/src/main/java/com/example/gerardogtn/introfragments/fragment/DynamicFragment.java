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


public class DynamicFragment extends Fragment {

    @Bind(R.id.detail_image)
    public ImageView detailImage;

    @Bind(R.id.detail_text)
    public TextView detailText;

    String name;
    int attack;

    public DynamicFragment(){}

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dynamic, container, false);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        this.name = args.getString("name", "Sin nombre.");
        this.attack = args.getInt("attack", 0);
    }
}
