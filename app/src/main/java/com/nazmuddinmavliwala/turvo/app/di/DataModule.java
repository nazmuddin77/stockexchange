package com.nazmuddinmavliwala.turvo.app.di;

import com.example.data.database.DatabaseManager;
import com.example.data.database.entities.DaoSession;
import com.example.data.network.NetworkManager;
import com.example.data.network.NetworkService;
import com.google.gson.Gson;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nazmuddinmavliwala on 27/10/2017.
 */


@Singleton
@Module
public class DataModule {

    @Singleton
    @Provides
    public Gson provideGson() {
        return new Gson();
    }

    @Singleton
    @Provides
    public NetworkService provideNetworkService(NetworkManager manager) {
        return manager;
    }

    @Singleton
    @Provides
    public DaoSession provideDaoSession(DatabaseManager manager) {
        return manager.getDaoSession();
    }
}
