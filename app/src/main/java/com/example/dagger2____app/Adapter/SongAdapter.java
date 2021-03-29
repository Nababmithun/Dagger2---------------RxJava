package com.example.dagger2____app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dagger2____app.Model.Songs;
import com.example.dagger2____app.R;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {


    private Context context;
    private List<Songs> allSongs;

    public SongAdapter(Context context, List<Songs> allSongs) {
        this.context = context;
        this.allSongs = allSongs;
    }



    @NonNull
    @Override
    public SongAdapter.SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.song_layout, parent, false);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {

        Songs mSong = allSongs.get(position);

        holder.songTitle.setText(mSong.getSongTitle());
        holder.songAuthor.setText(mSong.getSongAuthor());
        String imagePath = Helper.ImageUrll + "images/" + mSong.getSongImage();
        Glide.with(context).load(imagePath).fitCenter().into(holder.songImage);
    }

    @Override
    public int getItemCount() {
        return allSongs.size();
    }

    public class SongViewHolder extends RecyclerView.ViewHolder {


        private TextView songTitle;
        private TextView songAuthor;
        private ImageView songImage;


        public SongViewHolder(@NonNull View itemView) {
            super(itemView);

            songTitle = itemView.findViewById(R.id.song_name);
            songAuthor = itemView.findViewById(R.id.song_author);
            songImage = itemView.findViewById(R.id.song_image);
        }
    }
}
