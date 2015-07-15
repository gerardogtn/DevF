package com.example.gerardogtn.musicclient.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gerardogtn.musicclient.R;
import com.example.gerardogtn.musicclient.data.model.Track;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by gerardogtn on 7/14/15.
 */
public class TopTrackAdapter extends RecyclerView.Adapter<TopTrackAdapter.TopTrackViewHolder> {

    private List<Track> tracks;
    private LayoutInflater inflater;

    public TopTrackAdapter(Context context, List<Track> tracks){
        this.tracks = tracks;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public TopTrackViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = inflater.inflate(R.layout.top_track, parent, false);
        return new TopTrackViewHolder(item);
    }

    @Override
    public void onBindViewHolder(TopTrackViewHolder holder, int position) {
        holder.setData(tracks.get(position));
    }

    @Override
    public int getItemCount() {
        return tracks.size();
    }



    public class TopTrackViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.txt_artist_name)
        public TextView artistName;

        @Bind(R.id.txt_song_duration)
        public TextView songDuration;

        @Bind(R.id.txt_song_title)
        public TextView songTitle;

        public TopTrackViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData(Track track) {
            artistName.setText(track.getArtistName());
            songDuration.setText(track.getDuration());
            songTitle.setText(track.getName());
        }
    }
}
