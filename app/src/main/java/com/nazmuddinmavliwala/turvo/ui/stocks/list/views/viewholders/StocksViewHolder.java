package com.nazmuddinmavliwala.turvo.ui.stocks.list.views.viewholders;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.nazmuddinmavliwala.turvo.R;
import com.nazmuddinmavliwala.turvo.base.views.recyclerview.ReactiveViewHolder;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.models.StockVO;

import java.util.List;

import butterknife.BindColor;
import butterknife.BindDrawable;
import butterknife.BindInt;
import butterknife.BindViews;

/**
 * Created by nazmuddinmavliwala on 29/10/2017.
 */

public class StocksViewHolder extends ReactiveViewHolder<StockVO> {

    @BindViews({
            R.id.tv_name,
            R.id.tv_tckr_name,
            R.id.tv_value
    })
    List<TextView> textViews;

    @BindDrawable(R.drawable.ic_chevron_top)
    Drawable top;

    @BindDrawable(R.drawable.ic_chevron_bottom)
    Drawable bottom;

    @BindColor(R.color.redDark)
    int red;

    @BindColor(R.color.oliveGreenDark)
    int green;



    public StocksViewHolder(Context context, View itemView) {
        super(context, itemView);
    }

    @Override
    protected void bindData(StockVO data) {
        TextView tvName = findViewById(R.id.tv_name);
        tvName.setText(data.getName());

        TextView tvTckrName = findViewById(R.id.tv_tckr_name);
        tvTckrName.setText(data.getTckrName());

        TextView tvValue = findViewById(R.id.tv_value);
        List<Long> prices = data.getPrices();
        long yestPrice = prices.get(0);
        long todayPrice = prices.get(1);
        tvValue.setText(String.valueOf(todayPrice));
        if (todayPrice > yestPrice) {
            tvValue.setTextColor(green);
            tvValue.setCompoundDrawablesWithIntrinsicBounds(null,null,top,null);
        }
        else {
            tvValue.setTextColor(red);
            tvValue.setCompoundDrawablesWithIntrinsicBounds(null,null,bottom,null);
        }


    }
}
