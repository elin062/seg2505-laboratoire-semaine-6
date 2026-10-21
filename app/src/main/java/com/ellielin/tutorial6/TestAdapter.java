package com.ellielin.tutorial6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.WordViewHolder> {

    private List<Word> wordList;

    public TestAdapter(List<Word> wordList) {
        this.wordList = wordList;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.word, viewGroup, false);
        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        Word word = wordList.get(position);
        holder.word.setText(word.getWord());
    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }

    // ViewHolder class
    static class WordViewHolder extends RecyclerView.ViewHolder {
        TextView word;
        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            word = itemView.findViewById(R.id.word);
        }
    }
}