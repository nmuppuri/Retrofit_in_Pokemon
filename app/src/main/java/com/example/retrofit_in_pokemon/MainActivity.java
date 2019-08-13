package com.example.retrofit_in_pokemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerAdapt recyclerAdapt;
    RecyclerView recycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        GetDataService_Interface service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService_Interface.class);

        //Call<List<Repo>> repos = service.listRepos("octocat");
        Call <List<Pokemon_POJO>> pokes = service.getPokemons();

        pokes.enqueue(new Callback<List<Pokemon_POJO>>() {
            @Override
            public void onResponse(Call<List<Pokemon_POJO>> call, Response<List<Pokemon_POJO>> response) {

                generateData(response.body());

            }

            @Override
            public void onFailure(Call<List<Pokemon_POJO>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "Try Again", Toast.LENGTH_LONG).show();

            }
        });
    }

    public void generateData(List<Pokemon_POJO> pokemonList){

        ArrayList<Pokemon_POJO> pokemonArrayList = (ArrayList<Pokemon_POJO>) pokemonList;

        recyclerAdapt = new RecyclerAdapt(pokemonArrayList, getApplicationContext());

        @SuppressLint("WrongConstant") LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,false);
        recycleView = findViewById(R.id.recycleView);
        recycleView.setLayoutManager(linearLayoutManager);
        recycleView.setAdapter(recyclerAdapt);
    }
}
