package com.example.dagger2____app.dagger2;

import com.example.dagger2____app.View.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworksModule.class})
public interface NetworkComponent {
    public void inject(MainActivity activity);
}