package com.nazmuddinmavliwala.turvo.ui.stocks.details.views.adapterdelegates;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.nazmuddinmavliwala.turvo.R;
import com.nazmuddinmavliwala.turvo.base.views.recyclerview.AbstractAdapterDelegate;
import com.nazmuddinmavliwala.turvo.base.views.recyclerview.AdapterDelegate;
import com.nazmuddinmavliwala.turvo.ui.stocks.details.models.TradingVO;
import com.nazmuddinmavliwala.turvo.ui.stocks.details.views.viewholders.TradingViewHolder;

import java.util.List;

/**
 * Created by nazmuddinmavliwala on 30/10/2017.
 */

public class TradingDelegate extends AbstractAdapterDelegate<List<Object>> {

    public TradingDelegate(int viewType, Context context) {
        super(viewType, context);
    }

    @Override
    public boolean isForViewType(@NonNull List<Object> items, int position) {
        return items.get(position) instanceof TradingVO;
    }

    @Override
    public void onBindViewHolder(@NonNull List<Object> items, int position, @NonNull RecyclerView.ViewHolder holder) {
        ((TradingViewHolder)holder).bind((TradingVO) items.get(position));
    }

    @Override
    protected RecyclerView.ViewHolder getViewHolder(View itemView) {
        return new TradingViewHolder(this.context,itemView);
    }

    @Override
    protected int getViewHolderLayout() {
        return R.layout.trading_row;
    }
}
