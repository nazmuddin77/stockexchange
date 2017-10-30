package com.nazmuddinmavliwala.turvo.ui.stocks.details.views.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.nazmuddinmavliwala.turvo.R;
import com.nazmuddinmavliwala.turvo.base.views.recyclerview.ReactiveViewHolder;
import com.nazmuddinmavliwala.turvo.ui.stocks.details.models.TradingVO;

import java.util.List;

import butterknife.BindViews;

/**
 * Created by nazmuddinmavliwala on 30/10/2017.
 */

public class TradingViewHolder extends ReactiveViewHolder<TradingVO> {

    @BindViews({
            R.id.tv_sell,
            R.id.tv_buy,
            R.id.tv_diff
    })
    List<TextView> textViews;


    public TradingViewHolder(Context context, View itemView) {
        super(context, itemView);
    }

    @Override
    protected void bindData(TradingVO data) {
        TextView tvBuy = findViewById(R.id.tv_buy);
        tvBuy.setText("buy at " + data.getPurchase());
        TextView tvSell = findViewById(R.id.tv_sell);
        tvSell.setText("sell at " + data.getSell());
        TextView tvDiff = findViewById(R.id.tv_diff);
        tvDiff.setText("profit " + data.getDiff());

    }
}
