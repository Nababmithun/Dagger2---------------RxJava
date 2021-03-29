package com.example.dagger2____app.MyApp;

import android.app.Application;

import com.example.dagger2____app.Helper;
import com.example.dagger2____app.dagger2.NetworkComponent;
import com.example.dagger2____app.dagger2.NetworksModule;

public class CustomApplication extends Application {
    private NetworkComponent networkComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        networkComponent = DaggerNetworkComponent.builder()
                .networksModule(new NetworksModule(Helper.URL))
                .build();
    }
    public NetworkComponent getNetworkComponent(){
        return networkComponent;
    }
}
