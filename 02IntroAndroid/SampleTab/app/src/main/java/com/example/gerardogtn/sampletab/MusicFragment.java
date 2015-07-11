package com.example.gerardogtn.sampletab;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MusicFragment extends Fragment {

    private static List<MusicModel> musicians;

    @Bind(R.id.list_music)
    RecyclerView recyclerView;

    public MusicFragment() {
        musicians = new ArrayList<>();
        musicians.add(new MusicModel(R.drawable.taylor_swift, "Taylor Swift", "Shake it off!"));
        musicians.add(new MusicModel(R.drawable.daft_punk, "Daft Punk", "Get Lucky"));
        musicians.add(new MusicModel(R.drawable.the_kooks, "The Kooks", "Naive"));
        musicians.add(new MusicModel(R.drawable.topo_gigio, "Topo Gigio", "El raton vaquero"));

    }

    public static MusicFragment newInstance(){
        MusicFragment fragment = new MusicFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.fragment_music, container, false);
        ButterKnife.bind(this, root);
        setUpRecycleView();
        return root;
    }

    private void setUpRecycleView() {
        Context context = getActivity();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        MusicAdapter musicAdapter = new MusicAdapter(context, musicians);
        recyclerView.setAdapter(musicAdapter);

    }


}
