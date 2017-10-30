package com.nazmuddinmavliwala.turvo.app.di;

import android.content.Context;

import com.example.data.database.DatabaseManager;
import com.example.data.database.entities.DaoSession;
import com.example.data.network.NetworkService;
import com.nazmuddinmavliwala.turvo.app.TurvoApp;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;


/**
 * Created by nazmuddinmavliwala on 27/10/2017.
 */


@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                DataModule.class
        }
)
public interface ApplicationComponent {

    @Named("Application")
    Context provideApplicationContext();

    NetworkService provideNetworkService();

    DaoSession provideDaoSession();

    void inject(TurvoApp app);
}
