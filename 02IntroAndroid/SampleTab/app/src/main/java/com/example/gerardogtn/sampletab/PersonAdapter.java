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
public class PersonAdapter extends ArrayAdapter<PersonModel> {

    private List<PersonModel> people;
    private LayoutInflater inflater;

    public PersonAdapter(Context context, int resource, List<PersonModel> people) {
        super(context, resource, people);
        this.people = people;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View item;
        PersonViewHolder viewHolder;

        if (convertView == null){
            item = inflater.inflate(R.layout.le_people, parent, false);
            viewHolder = new PersonViewHolder(item);
            item.setTag(viewHolder);
        } else{
            item = convertView;
            viewHolder = (PersonViewHolder) item.getTag();
        }

        viewHolder.setData(people.get(position));

        return item;
    }

    public class PersonViewHolder{
        
        @Bind(R.id.person_name)
        public TextView name;

        @Bind(R.id.program_description)
        public TextView description;

        @Bind(R.id.person_image)
        public ImageView image;


        public PersonViewHolder(View viewItem){
            ButterKnife.bind(this, viewItem);
        }

        public void setData(PersonModel personModel){
            name.setText(personModel.getName());
            image.setImageResource(personModel.getImageId());

            if (personModel.isSensei()){
                description.setText("Sensei de Android");
            } else{
                description.setText("Estudiante de Android");
            }
        }
    }
}

