package com.example.gerardogtn.sampletab;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by gerardogtn on 7/10/15.
 */
public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicViewHolder>{

    private List<MusicModel> musicModels;
    private LayoutInflater inflater;


    public MusicAdapter(Context context, List<MusicModel> musicModels) {
        this.musicModels = musicModels;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MusicViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View item = inflater.inflate(R.layout.le_music, viewGroup, false);
        return new MusicViewHolder(item);
    }

    @Override
    public void onBindViewHolder(MusicViewHolder musicViewHolder, int i) {
        musicViewHolder.setData(musicModels.get(i));
    }

    @Override
    public int getItemCount() {
        return musicModels.size();
    }

    public class MusicViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.music_name)
        public TextView name;

        @Bind(R.id.music_song)
        public TextView description;

        @Bind(R.id.music_image)
        public ImageView image;

        public MusicViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData(MusicModel musicModel) {
            name.setText(musicModel.getArtist());
            description.setText(musicModel.getSampleSong());
            image.setImageResource(musicModel.getImageId());
        }
    }
}
