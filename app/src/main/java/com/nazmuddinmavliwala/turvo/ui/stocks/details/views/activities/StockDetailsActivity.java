package com.nazmuddinmavliwala.turvo.ui.stocks.details.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.nazmuddinmavliwala.turvo.R;
import com.nazmuddinmavliwala.turvo.base.views.BaseActivity;
import com.nazmuddinmavliwala.turvo.base.views.ViewManager;
import com.nazmuddinmavliwala.turvo.ui.stocks.details.di.SockDetailsModule;
import com.nazmuddinmavliwala.turvo.ui.stocks.details.presenters.StockDetailsPresenter;
import com.nazmuddinmavliwala.turvo.ui.stocks.details.views.viewdelgates.StockDetailsViewDelegate;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.models.StockVO;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.views.viewdelegates.ErrorViewDelegate;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.views.viewdelegates.LoaderViewDelegate;

import javax.inject.Inject;

/**
 * Created by nazmuddinmavliwala on 29/10/2017.
 */

public class StockDetailsActivity extends BaseActivity implements StockDetailsView {

    public static final String STOCK_ID = "stockId";

    @Inject
    ViewManager<StockVO> viewManager;

    @Inject
    StockDetailsPresenter presenter;
    private long stockId;


    @Override
    protected int getLayout() {
        return R.layout.activity_stock_details;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().provideStockDetailComponent(new SockDetailsModule(this))
                .inject(this);
        viewManager.showExplicit(StockDetailsViewDelegate.class);
        viewManager.onCreate();
        stockId = getIntent().getLongExtra(STOCK_ID, 0);
        this.presenter.fetchStockDetails(stockId);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_stock_details,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_toggle) {
            this.presenter.toggleValueOfStock(this.stockId);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.viewManager.onActivityResult(requestCode, resultCode, data);
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
        this.viewManager.showExplicit(StockDetailsViewDelegate.class);
    }

    @Override
    public void bind(StockVO stockVO) {
        StockDetailsViewDelegate viewDelegate = this.viewManager.getViewDelegate(StockDetailsViewDelegate.class);
        viewDelegate.bind(stockVO);
    }

    @Override
    public void updateStocks(StockVO stock) {
        StockDetailsViewDelegate viewDelegate = this.viewManager.getViewDelegate(StockDetailsViewDelegate.class);
        viewDelegate.updateStocks(stock);
    }
}
