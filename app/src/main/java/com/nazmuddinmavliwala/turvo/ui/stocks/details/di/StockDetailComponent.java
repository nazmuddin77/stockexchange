package com.nazmuddinmavliwala.turvo.ui.stocks.details.di;

import com.nazmuddinmavliwala.turvo.app.di.identifiers.ChildActivity;
import com.nazmuddinmavliwala.turvo.ui.stocks.details.views.activities.StockDetailsActivity;

import dagger.Subcomponent;

/**
 * Created by nazmuddinmavliwala on 29/10/2017.
 */


@ChildActivity
@Subcomponent(modules = SockDetailsModule.class)
public interface StockDetailComponent {
    void inject(StockDetailsActivity activity);
}
