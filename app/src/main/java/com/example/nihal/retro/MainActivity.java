package com.example.nihal.retro;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.nihal.retro.pojo.DataClass;
import com.example.nihal.retro.pojo.MainJsonResponse;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ArrayList<DataClass> dataClassArrayList;
    RecyclerView recyclerView;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.ultimatebattle.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call<MainJsonResponse> mainResult = apiInterface.getMainJsonResponse();


        mainResult.enqueue(new Callback<MainJsonResponse>() {
            @Override
            public void onResponse(Call<MainJsonResponse> call, Response<MainJsonResponse> response) {


                MainJsonResponse mainJsonResponse = response.body();

                dataClassArrayList = new ArrayList<>(Arrays.asList(mainJsonResponse.getData()));
                Log.e("TAG" , "Data set created"+dataClassArrayList.size());

                customAdapter = new CustomAdapter(MainActivity.this,dataClassArrayList);
                Log.e("TAG","Adater created");
                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(customAdapter);

            }

            @Override
            public void onFailure(Call<MainJsonResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Please try again", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
