package com.example.retrofit_in_pokemon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerAdapt extends RecyclerView.Adapter<RecyclerAdapt.ViewHolder>{

    private ArrayList<Pokemon_POJO> pokemonPOJOArrayList;
    private Context context;
    private View.OnClickListener pokeListener;

    public RecyclerAdapt(ArrayList<Pokemon_POJO> pokemonPOJOArrayList, Context context) {
        this.pokemonPOJOArrayList = pokemonPOJOArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).asBitmap().load(pokemonPOJOArrayList.get(position).getImage()).into(holder.poke_image);
        holder.poke_name.setText(pokemonPOJOArrayList.get(position).getName());

    }

    public void setOnClickListener(View.OnClickListener itemClickListener){
        pokeListener = itemClickListener;
    }

    @Override
    public int getItemCount() {
        return pokemonPOJOArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView poke_image;
        TextView poke_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            poke_image = itemView.findViewById(R.id.poke_image);
            poke_name = itemView.findViewById(R.id.poke_name);

            itemView.setTag(this);
            itemView.setOnClickListener(pokeListener);
        }
    }
}
