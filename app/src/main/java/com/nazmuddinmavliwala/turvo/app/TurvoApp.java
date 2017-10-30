package com.nazmuddinmavliwala.turvo.app;

import android.app.Application;

import com.nazmuddinmavliwala.turvo.app.di.ApplicationComponent;
import com.nazmuddinmavliwala.turvo.app.di.ApplicationModule;
import com.nazmuddinmavliwala.turvo.app.di.DaggerApplicationComponent;
import com.nazmuddinmavliwala.turvo.app.di.DataModule;

/**
 * Created by nazmuddinmavliwala on 27/10/2017.
 */

public class TurvoApp extends Application {

    private static ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .dataModule(new DataModule())
                .build();
        component.inject(this);
    }

    public static ApplicationComponent getComponent() {
        return component;
    }
}
