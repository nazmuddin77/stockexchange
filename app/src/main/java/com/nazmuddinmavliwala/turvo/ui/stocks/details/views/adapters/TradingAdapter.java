package com.nazmuddinmavliwala.turvo.ui.stocks.details.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.nazmuddinmavliwala.turvo.base.views.recyclerview.AdapterDelegate;
import com.nazmuddinmavliwala.turvo.base.views.recyclerview.ReactiveRecyclerAdapter;
import com.nazmuddinmavliwala.turvo.ui.stocks.details.views.adapterdelegates.TradingDelegate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nazmuddinmavliwala on 30/10/2017.
 */

public class TradingAdapter extends ReactiveRecyclerAdapter {

    private static final int TRADING = 1;

    public TradingAdapter(Context context) {
        super(context);
    }

    @Override
    protected List<AdapterDelegate> initAdapterDelegates() {
        List<AdapterDelegate> adapterDelegates = new ArrayList<>();
        adapterDelegates.add(new TradingDelegate(TRADING,this.context));
        return adapterDelegates;
    }

    @Override
    public void append(List<Object> items) {
        this.items.clear();
        super.append(items);
    }
}
