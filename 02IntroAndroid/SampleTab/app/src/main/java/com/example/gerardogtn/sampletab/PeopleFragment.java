package com.example.gerardogtn.sampletab;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class PeopleFragment extends Fragment {


    public PeopleFragment() {

    }

    public static PeopleFragment newInstance(){
        PeopleFragment fragment = new PeopleFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_people, container, false);
    }


}
