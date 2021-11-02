package com.neo.daggerretrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.neo.daggerretrofit.model.RecyclerData;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {
    private List<RecyclerData> listData;

    @NonNull
    @Override
    public RvAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvAdapter.MyViewHolder holder, int position) {
        RecyclerData item = listData.get(position);

        holder.tvTitle.setText(item.getName());
        holder.tvDescription.setText(item.getDescription());
        Glide.with(holder.thumbImage)
                .load(item.getOwner().getAvatarUrl())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.thumbImage);
    }

    @Override
    public int getItemCount() {
        if(listData != null){
            return listData.size();
        } else{
            return 0;
        }
    }

    public void setListData(List<RecyclerData> newList){
        this.listData = newList;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle, tvDescription;
        ImageView thumbImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDesc);
            thumbImage = itemView.findViewById(R.id.thumbImage);
        }


    }
}
