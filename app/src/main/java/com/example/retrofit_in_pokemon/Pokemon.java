package com.example.retrofit_in_pokemon;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pokemon {

    @SerializedName("Pokemon")
    @Expose
    private List<Pokemon_POJO> pokemon = null;

    public List<Pokemon_POJO> getPokemon() {
        return pokemon;
    }

    public void setPokemon(List<Pokemon_POJO> pokemon) {
        this.pokemon = pokemon;
    }

}
