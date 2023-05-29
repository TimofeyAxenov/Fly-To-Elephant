package com.example.flytoelephant;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    private ArrayList<String> moves;

    public HistoryAdapter(ArrayList<String> moves){
        this.moves = moves;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_move, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(moves.get(position));
    }

    @Override
    public int getItemCount() {
        return moves.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView1;
        private final TextView textView2;
        private final TextView textView3;
        private final TextView textView4;
        private final TextView textView5;

        public ViewHolder(View view) {
            super(view);
            textView1 = view.findViewById(R.id.Letter1);
            textView2 = view.findViewById(R.id.Letter2);
            textView3 = view.findViewById(R.id.Letter3);
            textView4 = view.findViewById(R.id.Letter4);
            textView5 = view.findViewById(R.id.Letter5);

        }

        public void bind(String move){
            textView1.setText(String.valueOf(move.charAt(0)));
            textView2.setText(String.valueOf(move.charAt(1)));
            textView3.setText(String.valueOf(move.charAt(2)));
            textView4.setText(String.valueOf(move.charAt(3)));
            textView5.setText(String.valueOf(move.charAt(4)));
        }
    }
}
