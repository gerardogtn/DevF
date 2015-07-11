package com.example.gerardogtn.sampletab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by gerardogtn on 7/10/15.
 */
public class ProjectAdapter extends ArrayAdapter<ProjectModel> {

    private List<ProjectModel> projects;
    private LayoutInflater inflater;

    @Bind(R.id.project_title)
    public TextView title;

    @Bind(R.id.project_description)
    public TextView description;

    public ProjectAdapter(Context context, int resource, List<ProjectModel> projects) {
        super(context, resource, projects);
        this.projects = projects;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View item = inflater.inflate(R.layout.le_project, parent, false);
        ButterKnife.bind(this, item);
        fillFields(position);
        return item;
    }

    private void fillFields(int position) {
        title.setText(projects.get(position).getTitle());
        description.setText(projects.get(position).getDescription());
    }
}
