package com.nazmuddinmavliwala.turvo.app.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nazmuddinmavliwala on 27/10/2017.
 */


@Singleton
@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Named("Application")
    @Provides
    public Context getContext() {
        return this.application;
    }
}
