package com.nazmuddinmavliwala.turvo.base.di;

import com.example.data.interactors.BackgroundThread;
import com.example.data.interactors.UIThread;
import com.nazmuddin.domain.executers.ExecutionThread;
import com.nazmuddin.domain.executers.PostExecutionThread;
import com.nazmuddinmavliwala.turvo.app.di.identifiers.ScopedActivity;

import javax.inject.Scope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nazmuddinmavliwala on 29/10/2017.
 */

@ScopedActivity
@Module
public class RxModule {

    @ScopedActivity
    @Provides
    public ExecutionThread provideExecutionThread(BackgroundThread thread) {
        return thread;
    }

    @ScopedActivity
    @Provides
    public PostExecutionThread providePostExecutionThread(UIThread thread) {
        return thread;
    }
}
