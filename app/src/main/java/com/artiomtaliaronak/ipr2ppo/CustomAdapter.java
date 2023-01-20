package com.artiomtaliaronak.ipr2ppo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    Context context;
    private ArrayList albumId, albumTitle, albumAuthor, albumTracks;

    CustomAdapter(Context context, ArrayList albumId, ArrayList albumTitle, ArrayList albumAuthor, ArrayList albumTracks){
        this.context = context;
        this.albumId = albumId;
        this.albumTitle = albumTitle;
        this.albumAuthor = albumAuthor;
        this.albumTracks = albumTracks;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, final int position) {
        holder.albumIdText.setText(String.valueOf(albumId.get(position)));
        holder.albumTitleText.setText(String.valueOf(albumTitle.get(position)));
        holder.albumAuthorText.setText(String.valueOf(albumAuthor.get(position)));
        holder.albumTrackText.setText(String.valueOf(albumTracks.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(albumId.get(position)));
                intent.putExtra("title", String.valueOf(albumTitle.get(position)));
                intent.putExtra("author", String.valueOf(albumAuthor.get(position)));
                intent.putExtra("tracks", String.valueOf(albumTracks.get(position)));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return albumId.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView albumIdText, albumTitleText, albumAuthorText, albumTrackText;
        LinearLayout mainLayout;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            albumIdText = itemView.findViewById(R.id.albumIdText);
            albumTitleText = itemView.findViewById(R.id.albumTitleText);
            albumAuthorText = itemView.findViewById(R.id.albumAuthorText);
            albumTrackText = itemView.findViewById(R.id.albumTrackText);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
