package com.example.gerardogtn.musicclient.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gerardogtn.musicclient.R;
import com.example.gerardogtn.musicclient.data.model.Artist;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by gerardogtn on 7/14/15.
 */
public class TopArtistAdapter extends RecyclerView.Adapter<TopArtistAdapter.TopArtistViewHolder> {

    private List<Artist> artists;
    private LayoutInflater inflater;

    public TopArtistAdapter(Context context, List<Artist> artists) {
        this.artists = artists;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public TopArtistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = inflater.inflate(R.layout.top_artist, parent, false);
        return new TopArtistViewHolder(item);
    }

    @Override
    public void onBindViewHolder(TopArtistViewHolder holder, int position) {
        holder.setData(artists.get(position));
    }

    @Override
    public int getItemCount() {
        return artists.size();
    }



    public class TopArtistViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.txt_artist)
        public TextView artistName;

        public TopArtistViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData(Artist artist) {
            artistName.setText(artist.getName());
        }
    }
}
