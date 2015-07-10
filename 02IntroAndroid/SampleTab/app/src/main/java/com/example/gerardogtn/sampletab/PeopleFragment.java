package com.example.gerardogtn.sampletab;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class PeopleFragment extends Fragment {

    private static List<PersonModel> people;

    @Bind(R.id.list_people)
    ListView listView;

    public PeopleFragment() {
        people = new ArrayList<>();
        people.add(new PersonModel("Chava", R.drawable.chava, true));
        people.add(new PersonModel("Petter", R.drawable.petter, true));
        people.add(new PersonModel("Angel", R.drawable.angel));
        people.add(new PersonModel("Emilio", R.drawable.emilio));
        people.add(new PersonModel("Fer", R.drawable.fer));
        people.add(new PersonModel("Gerardo", R.drawable.gerardo));
        people.add(new PersonModel("Salvador", R.drawable.salvador));
        people.add(new PersonModel("Sebastian", R.drawable.sebastian));
    }

    public static PeopleFragment newInstance(){
        PeopleFragment fragment = new PeopleFragment();
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.fragment_people, container, false);
        ButterKnife.bind(this, root);

        PersonAdapter adapter = new PersonAdapter(getActivity(), 0, people);
        listView.setAdapter(adapter);
        return root;
    }


}
