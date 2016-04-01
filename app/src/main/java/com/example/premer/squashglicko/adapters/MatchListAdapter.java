package com.example.premer.squashglicko.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.premer.squashglicko.Match;
import com.example.premer.squashglicko.R;

import java.util.ArrayList;


/**
 * Created by premer on 31.03.16.
 */
public class MatchListAdapter extends RecyclerView.Adapter<MatchListAdapter.ViewHolder>{
    private ArrayList<Match> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mPlayer1NameTextView;
        public TextView mPlayer2NameTextView;
        public TextView mPlayer1GlickoTextView;
        public TextView mPlayer2GlickoTextView;
        public TextView mResultTextView;



        public ViewHolder(View v){
            super(v);

            mPlayer1NameTextView = (TextView) v.findViewById(R.id.player1Name);
            mPlayer2NameTextView = (TextView) v.findViewById(R.id.player2Name);
            mPlayer1GlickoTextView = (TextView) v.findViewById(R.id.player1Glicko);
            mPlayer2GlickoTextView = (TextView) v.findViewById(R.id.player2Glicko);
            mResultTextView = (TextView) v.findViewById(R.id.result);
        }
    }

    public MatchListAdapter(ArrayList<Match> dataset){
        mDataset = dataset;
    }


    @Override
    public MatchListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);

        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(MatchListAdapter.ViewHolder holder, int position) {
        Match match = mDataset.get(position);
        String result = match.getPlayer1() + " " + match.getPlayer1Score() + "-"
                + match.getPlayer2Score() +" " + match.getPlayer2();
        holder.mPlayer1NameTextView.setText(match.getPlayer1());
        holder.mPlayer2NameTextView.setText(match.getPlayer2());
        holder.mPlayer1GlickoTextView.setText("(1659)");
        holder.mPlayer2GlickoTextView.setText("(2837)");
        holder.mResultTextView.setText(match.getPlayer1Score() + " - " + match.getPlayer2Score());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
