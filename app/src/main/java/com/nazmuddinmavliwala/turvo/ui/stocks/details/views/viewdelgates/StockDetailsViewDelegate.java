package com.nazmuddinmavliwala.turvo.ui.stocks.details.views.viewdelgates;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.nazmuddinmavliwala.turvo.R;
import com.nazmuddinmavliwala.turvo.base.views.BaseViewDelegate;
import com.nazmuddinmavliwala.turvo.ui.stocks.details.models.TradingVO;
import com.nazmuddinmavliwala.turvo.ui.stocks.details.views.adapters.TradingAdapter;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.models.StockVO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;

import static com.github.mikephil.charting.utils.ColorTemplate.rgb;

/**
 * Created by nazmuddinmavliwala on 29/10/2017.
 */

public class StockDetailsViewDelegate extends BaseViewDelegate<StockVO> {

    @BindView(R.id.bar_chart)
    BarChart barChart;

    @BindView(R.id.tv_name)
    TextView tvName;

    @BindView(R.id.rv_trading)
    RecyclerView recyclerView;


    @Inject
    public StockDetailsViewDelegate(@NonNull @Named("Activity") Context context,
                                    @NonNull @Named("StockDetails") View view) {
        super(context, view);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this.context);
        recyclerView.setLayoutManager(manager);
        TradingAdapter adapter = new TradingAdapter(this.context);
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(false);

        barChart.setDrawBarShadow(false);
        barChart.setDrawValueAboveBar(true);
        barChart.getDescription().setEnabled(false);
        barChart.setMaxVisibleValueCount(10);
        barChart.setPinchZoom(false);
        barChart.setDrawGridBackground(false);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setLabelCount(7);


        YAxis leftAxis = barChart.getAxisLeft();
        leftAxis.setLabelCount(8, false);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setSpaceTop(15f);
        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)

        YAxis rightAxis = barChart.getAxisRight();
        rightAxis.setDrawGridLines(false);
        rightAxis.setLabelCount(8, false);
        rightAxis.setSpaceTop(15f);
        rightAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)

        Legend l = barChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setForm(Legend.LegendForm.SQUARE);
        l.setFormSize(9f);
        l.setTextSize(11f);
        l.setXEntrySpace(4f);

    }


    @Override
    public void bind(StockVO data) {
        tvName.setText(data.getName());
        //calculate max trading days
        calculate(data.getPrices());
        List<Long> prices = data.getPrices();
        List<BarEntry> yVals1 = new ArrayList<>();;
        for (int i = 0; i < prices.size() ; i++) {
            yVals1.add(new BarEntry(i, prices.get(i)));
        }
        BarDataSet set1;

        if (barChart.getData() != null &&
                barChart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) barChart.getData().getDataSetByIndex(0);
            set1.setValues(yVals1);
            barChart.getData().notifyDataChanged();
            barChart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(yVals1, "The year 2017");
            set1.setDrawIcons(false);

            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
            dataSets.add(set1);

            BarData barData = new BarData(dataSets);
            barData.setValueTextSize(10f);
            barData.setBarWidth(0.9f);

            barChart.setData(barData);
        }

    }

    private void calculate(List<Long> prices) {
        List<TradingVO> tradingVOS = getDiffArray(prices);
        List<Object> objects = new ArrayList<>();
        objects.addAll(tradingVOS.subList(0,2));
        ((TradingAdapter)recyclerView.getAdapter()).append(objects);
    }

    private List<TradingVO> getDiffArray(List<Long> prices) {
        List<TradingVO> diffObjects = new ArrayList<>();
        for (int i = 1; i < prices.size() ; i ++) {
            long purchase = prices.get(i-1);
            long sell = prices.get(i);
            long diff = purchase - sell;
            diffObjects.add(new TradingVO(diff,purchase,sell));
        }
        Collections.sort(diffObjects);
        return diffObjects;
    }

    public void updateStocks(StockVO stock) {
        calculate(stock.getPrices());
        barChart.clear();
        List<Long> prices = stock.getPrices();
        List<BarEntry> yVals1 = new ArrayList<>();;
        for (int i = 0; i < prices.size() ; i++) {
            yVals1.add(new BarEntry(i, prices.get(i)));
        }
        BarDataSet set1;

        set1 = new BarDataSet(yVals1, "The year 2017");
        set1.setDrawIcons(false);

        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
        dataSets.add(set1);

        BarData barData = new BarData(dataSets);
        barData.setValueTextSize(10f);
        barData.setBarWidth(0.9f);

        barChart.setData(barData);
    }
}
