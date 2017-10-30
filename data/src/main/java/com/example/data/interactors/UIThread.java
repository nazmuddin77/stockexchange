package com.example.data.interactors;

import com.nazmuddin.domain.executers.ExecutionThread;
import com.nazmuddin.domain.executers.PostExecutionThread;

import javax.inject.Inject;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by nazmuddinmavliwala on 28/10/2017.
 */

public class UIThread implements PostExecutionThread {

    @Inject
    public UIThread() {
    }

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
