package com.example.retrofit_in_pokemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerAdapt recyclerAdapt;
    RecyclerView recyclerView;

    ArrayList<Pokemon_POJO> pokemon_pojo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        GetDataService_Interface service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService_Interface.class);


        //Call<List<Pokemon_POJO>> pokes = service.getPokemons();
        Call<Pokemon> pokes2 = service.getPokemonsObj();

        /*pokes.enqueue(new Callback<List<Pokemon_POJO>>() {
            @Override
            public void onResponse(Call<List<Pokemon_POJO>> call, Response<List<Pokemon_POJO>> response) {

                generateData(response.body());

            }

            @Override
            public void onFailure(Call<List<Pokemon_POJO>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "Try Again", Toast.LENGTH_LONG).show();

            }
        });*/

        pokes2.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {

                Pokemon pojo2 = response.body();
                pokemon_pojo = new ArrayList<>(pojo2.getPokemon());
                generateData2(pokemon_pojo);


            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "Try Again", Toast.LENGTH_LONG).show();


            }
        });
    }

    /*public void generateData(List<Pokemon_POJO> pokemonList){

        ArrayList<Pokemon_POJO> pokemonArrayList = (ArrayList<Pokemon_POJO>) pokemonList;

        recyclerAdapt = new RecyclerAdapt(pokemonArrayList, getApplicationContext());

        @SuppressLint("WrongConstant") LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,false);
        recycleView = findViewById(R.id.recycleView);
        recycleView.setLayoutManager(linearLayoutManager);
        recycleView.setAdapter(recyclerAdapt);
    }*/

    public void generateData2(ArrayList<Pokemon_POJO> pokemonList){

        recyclerAdapt = new RecyclerAdapt(pokemonList, getApplicationContext());

        @SuppressLint("WrongConstant") LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,false);
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerAdapt);
    }
}
