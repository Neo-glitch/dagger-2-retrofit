package com.neo.daggerretrofit.di;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * ret the retrofit instance, a way of getting instance
 * of class we don't own
 */
@Module
public class RetroModule {

    private String baseUrl = "https://api.github.com/search/"; //repositories?q=newyork"

    @Singleton
    @Provides
    public Retrofit getRetrofitInstance(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return  retrofit;
    }

    /*
    return retrofitServiceInstance
     */
    @Provides
    @Singleton
    public RetroServiceInterface getRetroServiceInstance(Retrofit retrofit){
        return retrofit.create(RetroServiceInterface.class);
    }
}
