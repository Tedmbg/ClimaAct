package com.example.climaact;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class TreeTypeAdapter extends RecyclerView.Adapter<TreeTypeAdapter.TreeTypeViewHolder> {

    private ArrayList<TreeType> treeTypes;

    public TreeTypeAdapter(ArrayList<TreeType> treeTypes) {
        this.treeTypes = treeTypes;
    }

    @NonNull
    @Override
    public TreeTypeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tree_type_item, parent, false);
        return new TreeTypeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TreeTypeViewHolder holder, int position) {
        TreeType currentTreeType = treeTypes.get(position);
        holder.textViewTreeName.setText(currentTreeType.getTreeName());
        holder.textViewTreeDescription.setText(currentTreeType.getTreeDescription());
    }

    @Override
    public int getItemCount() {
        return treeTypes.size();
    }

    public static class TreeTypeViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewTreeName;
        public TextView textViewTreeDescription;

        public TreeTypeViewHolder(View itemView) {
            super(itemView);
            textViewTreeName = itemView.findViewById(R.id.textViewTreeName);
            textViewTreeDescription = itemView.findViewById(R.id.textViewTreeDescription);
        }
    }
}
