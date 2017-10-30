package com.nazmuddinmavliwala.turvo.ui.stocks.list.views.viewdelegates;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import com.nazmuddinmavliwala.turvo.base.presenters.BaseView;
import com.nazmuddinmavliwala.turvo.base.views.BaseViewDelegate;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by nazmuddinmavliwala on 29/10/2017.
 */

public class LoaderViewDelegate extends BaseViewDelegate {

    @Inject
    public LoaderViewDelegate(@NonNull @Named("Activity") Context context,
                              @NonNull @Named("Loader") View view) {
        super(context, view);
    }
}
