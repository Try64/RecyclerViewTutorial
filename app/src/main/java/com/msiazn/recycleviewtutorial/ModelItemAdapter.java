package com.msiazn.recycleviewtutorial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class ModelItemAdapter extends RecyclerView.Adapter<ModelItemAdapter.ModelItemViewHolder> {

    ArrayList<ModelItem> list;
    OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ModelItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View view = parent.inflate(parent.getContext(),R.layout.item_view,false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new ModelItemViewHolder(view, this.listener);
    }

    public ModelItemAdapter(ArrayList<ModelItem> list) {
        this.list = list;

    }

    public interface OnItemClickListener {
        void onItemClicked(int position);
    }

    @Override
    public void onBindViewHolder(@NonNull ModelItemViewHolder holder, int position) {
        ModelItem modelItem = list.get(position);

        holder.title.setText(modelItem.getTitle());
        holder.desc.setText(modelItem.getDescription());
        holder.imageView.setImageResource(modelItem.getImageResourceId());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ModelItemViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView desc;
        public ImageView imageView;

        public ModelItemViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            desc = itemView.findViewById(R.id.desc);
            imageView = itemView.findViewById(R.id.imageview);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION) {
                            listener.onItemClicked(pos);
                        }
                    }
                }
            });
        }
    }


}
