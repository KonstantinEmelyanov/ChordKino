package ru.emelyanovkonstantin.chordkino;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.emelyanovkonstantin.chordkino.dto.SongDTO;

/**
 * Created by EmelyanovKonstantin on 30.07.2018.
 */
public class SongListAdapter extends RecyclerView.Adapter<SongListAdapter.SongViewHolder> {
    private List<SongDTO> data;
    public SongListAdapter(List<SongDTO> data){
        this.data = data;
    }

    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.song_item,parent,false);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SongViewHolder holder, int position) {
        final int songId = data.get(position).getId();
        holder.name.setText(data.get(position).getName());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),TextActivity.class);
                intent.putExtra("songId",songId);
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class SongViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView name;
        public SongViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cardView2);
            name = (TextView) itemView.findViewById(R.id.name2);
        }
    }
}
