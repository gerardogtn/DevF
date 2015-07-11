package com.example.gerardogtn.sampletab;

import android.app.Activity;
import android.net.Uri;
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


public class ProjectFragment extends Fragment {


    private static List<ProjectModel> projects;

    @Bind(R.id.list_project)
    public ListView listView;

    public ProjectFragment() {
        projects = new ArrayList<>();
        projects.add(new ProjectModel("Layouts y Aplicaciones",
                "Uso de layout y aplicaciones para crear apps en Android."));
        projects.add(new ProjectModel("Fragmentos",
                "Uso de fragmentos dinamicos y estaticos."));
        projects.add(new ProjectModel("ActionBar",
                "Uso de la ActionBar de la libreria de diseno de Android."));
        projects.add(new ProjectModel("NavigationDrawer",
                "Uso de NavigationDrawer como opcion de navegacion en Android."));
        projects.add(new ProjectModel("Listas",
                "Uso de ListView, ListView con ViewHolder y RecycleView"));

    }

    public static ProjectFragment newInstance(){
        ProjectFragment fragment = new ProjectFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_project, container, false);
        ButterKnife.bind(this, root);
        ProjectAdapter adapter = new ProjectAdapter(getActivity(), 0, projects);
        listView.setAdapter(adapter);
        return root;
    }

}
