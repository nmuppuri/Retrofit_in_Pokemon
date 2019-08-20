package com.example.retrofit_in_pokemon;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService_Interface {

    @GET("Vy2abloQD")
    Call<List<Pokemon_POJO>> getPokemons();

    @GET("E14trR2lD")
    Call<Pokemon> getPokemonsObj();
}
