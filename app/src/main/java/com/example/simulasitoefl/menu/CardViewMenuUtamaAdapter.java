package com.example.simulasitoefl.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.simulasitoefl.R;

import java.util.ArrayList;

public class CardViewMenuUtamaAdapter extends RecyclerView.Adapter<CardViewMenuUtamaAdapter.CardViewViewHolder>{

    private ArrayList<MenuUtama> listMenuUtama;
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public CardViewMenuUtamaAdapter(ArrayList<MenuUtama> list) {
        this.listMenuUtama = list;

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Kamu memilih " + listMenuUtama.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.menu_item, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder holder, int position) {

        MenuUtama menuUtama = listMenuUtama.get(position);

        Glide.with(holder.itemView.getContext())
                .load(menuUtama.getIcon())
                .apply(new RequestOptions().override(48, 48))
                .into(holder.imgPhoto);

        holder.tvMenu.setText(menuUtama.getMenu());
        holder.tvDescription.setText(menuUtama.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listMenuUtama.get(holder.getAdapterPosition()));
            }
        });
    }

    public interface OnItemClickCallback {
        void onItemClicked(MenuUtama data);
    }


    @Override
    public int getItemCount() {
        return listMenuUtama.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvMenu, tvDescription;

        CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_menu_icon);
            tvMenu = itemView.findViewById(R.id.tv_practice);
            tvDescription = itemView.findViewById(R.id.tv_description);
        }
    }
}
