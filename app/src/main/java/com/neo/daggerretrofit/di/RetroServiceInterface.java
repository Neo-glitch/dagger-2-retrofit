package com.neo.daggerretrofit.di;


import com.neo.daggerretrofit.model.RecyclerList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

// service for making requests
public interface RetroServiceInterface {

    @GET("repositories")
    Call<RecyclerList> getDataFromApi(@Query("q") String query);
}
