package com.example.dagger2____app.Network;

import com.example.dagger2____app.Model.Songs;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitNetworkInterface {

    @GET("/dagger")
    Call<List<Songs>> allSongs();
}
