package com.nazmuddinmavliwala.turvo.ui.stocks.list.views.adapters;

import android.content.Context;

import com.nazmuddinmavliwala.turvo.base.views.recyclerview.AdapterDelegate;
import com.nazmuddinmavliwala.turvo.base.views.recyclerview.ReactiveRecyclerAdapter;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.views.adapterdelegates.StockDelegate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nazmuddinmavliwala on 29/10/2017.
 */

public class StockListAdapter extends ReactiveRecyclerAdapter {

    private static final int STOCKS = 1;

    public StockListAdapter(Context context) {
        super(context);
    }

    @Override
    protected List<AdapterDelegate> initAdapterDelegates() {
        List<AdapterDelegate> adapterDelegates = new ArrayList<>();
        adapterDelegates.add(new StockDelegate(STOCKS,this.context));
        return adapterDelegates;
    }
}
