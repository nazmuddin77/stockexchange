package com.nazmuddinmavliwala.turvo.ui.stocks.list.views.adapterdelegates;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.nazmuddinmavliwala.turvo.R;
import com.nazmuddinmavliwala.turvo.base.views.recyclerview.AbstractAdapterDelegate;
import com.nazmuddinmavliwala.turvo.base.views.recyclerview.AdapterDelegate;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.models.StockVO;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.views.viewholders.StocksViewHolder;

import java.util.List;

/**
 * Created by nazmuddinmavliwala on 29/10/2017.
 */

public class StockDelegate extends AbstractAdapterDelegate<List<Object>> {

    public StockDelegate(int viewType, Context context) {
        super(viewType, context);
    }

    @Override
    public boolean isForViewType(@NonNull List<Object> items, int position) {
        return items.get(position) instanceof StockVO;
    }

    @Override
    public void onBindViewHolder(@NonNull List<Object> items, int position, @NonNull RecyclerView.ViewHolder holder) {
        ((StocksViewHolder)holder).bind((StockVO) items.get(position));
    }

    @Override
    protected RecyclerView.ViewHolder getViewHolder(View itemView) {
        return new StocksViewHolder(this.context,itemView);
    }

    @Override
    protected int getViewHolderLayout() {
        return R.layout.stocks_row;
    }
}
