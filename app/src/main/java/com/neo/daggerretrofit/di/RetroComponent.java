package com.neo.daggerretrofit.di;


import com.neo.daggerretrofit.MainActivity;
import com.neo.daggerretrofit.model.MainActivityViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {RetroModule.class})
public interface RetroComponent {

    // to inject in that area, could be activity or fragment
    public void inject(MainActivityViewModel mainActivityViewModel);

}
