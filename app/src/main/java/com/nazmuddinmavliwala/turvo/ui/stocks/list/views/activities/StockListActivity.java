package com.nazmuddinmavliwala.turvo.ui.stocks.list.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.github.mikephil.charting.charts.BarChart;
import com.nazmuddinmavliwala.turvo.R;
import com.nazmuddinmavliwala.turvo.base.views.BaseActivity;
import com.nazmuddinmavliwala.turvo.base.views.ViewManager;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.di.StockListModule;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.models.StockVO;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.presenters.StockListPresenter;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.views.viewdelegates.ErrorViewDelegate;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.views.viewdelegates.LoaderViewDelegate;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.views.viewdelegates.StockListViewDelegate;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by nazmuddinmavliwala on 28/10/2017.
 */

public class StockListActivity extends BaseActivity implements StockListView {

    @Inject
    ViewManager<List<StockVO>> viewManager;

    @Inject
    StockListPresenter presenter;


    @Override
    protected int getLayout() {
        return R.layout.activity_stock_list;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().provideStockListComponent(new StockListModule(this))
                .inject(this);
        this.viewManager.onCreate();
        this.presenter.fetchStockList();
    }

    @Override
    public void showLoading() {
        this.viewManager.showExplicit(LoaderViewDelegate.class);
    }

    @Override
    public void hideLoading() {
        this.viewManager.hideSpecific(LoaderViewDelegate.class);

    }

    @Override
    public void showErrorView() {
        this.viewManager.showExplicit(ErrorViewDelegate.class);
    }

    @Override
    public void showDataView() {
        this.viewManager.showExplicit(StockListViewDelegate.class);
    }

    @Override
    public void bind(List<StockVO> stockVOS) {
        StockListViewDelegate viewDelegate = this.viewManager.getViewDelegate(StockListViewDelegate.class);
        viewDelegate.bind(stockVOS);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.viewManager.onActivityResult(requestCode, resultCode, data);
    }
}
