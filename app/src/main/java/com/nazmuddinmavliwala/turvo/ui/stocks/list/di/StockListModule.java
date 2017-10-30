package com.nazmuddinmavliwala.turvo.ui.stocks.list.di;

import android.view.View;

import com.example.data.database.entities.DaoSession;
import com.example.data.stocks.StockDataRepository;
import com.example.data.stocks.converters.StockDOToEntityConverter;
import com.example.data.stocks.converters.StockEntityToDomainConverter;
import com.nazmuddin.domain.stocks.StocksRepository;
import com.nazmuddinmavliwala.turvo.R;
import com.nazmuddinmavliwala.turvo.app.di.identifiers.ChildActivity;
import com.nazmuddinmavliwala.turvo.base.views.ViewDelegate;
import com.nazmuddinmavliwala.turvo.base.views.ViewManager;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.models.StockVO;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.presenters.StockDomainToVOConverter;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.views.activities.StockListActivity;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.views.activities.StockListView;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.views.viewdelegates.ErrorViewDelegate;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.views.viewdelegates.LoaderViewDelegate;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.views.viewdelegates.StockListViewDelegate;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nazmuddinmavliwala on 29/10/2017.
 */


@ChildActivity
@Module
public class StockListModule {

    private StockListActivity activity;

    public StockListModule(StockListActivity activity) {
        this.activity = activity;
    }


    @ChildActivity
    @Provides
    public StockListView provideView() {
        return this.activity;
    }


    @ChildActivity
    @Provides
    public StocksRepository provideRepo(StockDataRepository repository) {
        return repository;
    }

    @ChildActivity
    @Provides
    @Named("Error")
    public View provideErrorView() {
        return this.activity.findViewById(R.id.v_error);
    }

    @ChildActivity
    @Provides
    @Named("Loader")
    public View provideLoaderView() {
        return this.activity.findViewById(R.id.v_loader);
    }

    @ChildActivity
    @Provides
    @Named("StockList")
    public View provideDataView() {
        return this.activity.findViewById(R.id.v_data);
    }

    @SuppressWarnings("unchecked")
    @ChildActivity
    @Provides
    public ViewManager<List<StockVO>> provideViewManager(ErrorViewDelegate errorViewDelegate,
                                                         LoaderViewDelegate loaderViewDelegate,
                                                         StockListViewDelegate stockListViewDelegate) {
        List<ViewDelegate<List<StockVO>>> viewDelegates = new ArrayList<>();
        viewDelegates.add(loaderViewDelegate);
        viewDelegates.add(errorViewDelegate);
        viewDelegates.add(stockListViewDelegate);
        return new ViewManager<>(viewDelegates);
    }
}
