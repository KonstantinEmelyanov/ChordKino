package ru.emelyanovkonstantin.chordkino;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.emelyanovkonstantin.chordkino.dto.RemindDTO;

/**
 * Created by EmelyanovKonstantin on 24.07.2018.
 */
public class RemindListAdapter extends RecyclerView.Adapter<RemindListAdapter.RemindViewHolder> {
    private List<RemindDTO> data;

    public RemindListAdapter(List<RemindDTO> data) {
        this.data = data;
    }

    @Override
    public RemindViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.remind_item, parent, false);
        return new RemindViewHolder(view);
    }

 // @Override
 // public void onBindViewHolder(RemindViewHolder holder, int position) {
 //     holder.title.setText(data.get(position).getTitle());

 // }
 @Override
 public void onBindViewHolder(RemindViewHolder holder, int position) {
        final int itemString = data.get(position).getId();
     holder.title.setText(data.get(position).getName());
     holder.cardView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent intent = new Intent(view.getContext(),SongActivity.class);
             intent.putExtra("albumId", itemString);
             view.getContext().startActivity(intent);
         }
     });

 }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class RemindViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView title;
        TextView year;

        public RemindViewHolder (View itemView){
            super(itemView);
            cardView=(CardView) itemView.findViewById(R.id.cardView);
            title=(TextView)itemView.findViewById(R.id.title);
            year=(TextView) itemView.findViewById(R.id.year);


        }
    }
}
