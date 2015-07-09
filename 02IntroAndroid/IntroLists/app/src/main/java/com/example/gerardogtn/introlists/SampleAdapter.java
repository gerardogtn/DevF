package com.example.gerardogtn.introlists;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by gerardogtn on 7/6/15.
 */
public class SampleAdapter extends ArrayAdapter {

    private String names[];
    private LayoutInflater inflater;

    @Bind(R.id.element_sample)
    public TextView itemTextView;

    public SampleAdapter(Context context, int resource, String[] objects) {
        super(context, resource, objects);
        inflater = LayoutInflater.from(context);
        names = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View item = inflater.inflate(R.layout.element_sample_list,parent, false);
        ButterKnife.bind(this, item);
        itemTextView.setText(names[position]);
        return item;
    }
}
