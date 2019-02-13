package com.example.nihal.retro;

import com.example.nihal.retro.pojo.MainJsonResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/ub-android-app/v1.9/services.php?act=gettournaments")
    Call<MainJsonResponse>getMainJsonResponse();
}
