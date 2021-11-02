package com.neo.daggerretrofit;

import android.app.Application;

import com.neo.daggerretrofit.di.DaggerRetroComponent;
import com.neo.daggerretrofit.di.RetroComponent;
import com.neo.daggerretrofit.di.RetroModule;

public class MyApplication extends Application {

    private RetroComponent mRetroComponent;

    @Override
    public void onCreate() {
        super.onCreate();

//        mRetroComponent = DaggerRetroComponent.builder()
//                .retroModule(new RetroModule())
//                .build();

        mRetroComponent = DaggerRetroComponent.create();
    }

    public RetroComponent getRetroComponent(){
        return mRetroComponent;
    }
}
