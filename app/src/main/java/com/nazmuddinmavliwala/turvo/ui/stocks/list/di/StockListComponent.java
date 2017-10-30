package com.nazmuddinmavliwala.turvo.ui.stocks.list.di;

import com.nazmuddinmavliwala.turvo.app.di.identifiers.ChildActivity;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.views.activities.StockListActivity;

import dagger.Subcomponent;

/**
 * Created by nazmuddinmavliwala on 29/10/2017.
 */

@ChildActivity
@Subcomponent(modules = StockListModule.class)
public interface StockListComponent {
    void inject(StockListActivity activity);
}
