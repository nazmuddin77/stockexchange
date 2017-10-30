package com.nazmuddinmavliwala.turvo.ui.stocks.details.di;

import android.view.View;

import com.example.data.stocks.StockDataRepository;
import com.nazmuddin.domain.stocks.StocksRepository;
import com.nazmuddinmavliwala.turvo.R;
import com.nazmuddinmavliwala.turvo.app.di.identifiers.ChildActivity;
import com.nazmuddinmavliwala.turvo.base.views.ViewDelegate;
import com.nazmuddinmavliwala.turvo.base.views.ViewManager;
import com.nazmuddinmavliwala.turvo.ui.stocks.details.views.activities.StockDetailsActivity;
import com.nazmuddinmavliwala.turvo.ui.stocks.details.views.activities.StockDetailsView;
import com.nazmuddinmavliwala.turvo.ui.stocks.details.views.viewdelgates.StockDetailsViewDelegate;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.models.StockVO;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.views.viewdelegates.ErrorViewDelegate;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.views.viewdelegates.LoaderViewDelegate;

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
public class SockDetailsModule {

    private StockDetailsActivity activity;

    public SockDetailsModule(StockDetailsActivity activity) {
        this.activity = activity;
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
    @Named("StockDetails")
    public View provideDataView() {
        return this.activity.findViewById(R.id.v_data);
    }

    @SuppressWarnings("unchecked")
    @ChildActivity
    @Provides
    public ViewManager<StockVO> provideViewManager(ErrorViewDelegate errorViewDelegate,
                                                         LoaderViewDelegate loaderViewDelegate,
                                                         StockDetailsViewDelegate stockDetailsViewDelegate) {
        List<ViewDelegate<StockVO>> viewDelegates = new ArrayList<>();
        viewDelegates.add(loaderViewDelegate);
        viewDelegates.add(errorViewDelegate);
        viewDelegates.add(stockDetailsViewDelegate);
        return new ViewManager<>(viewDelegates);
    }

    @ChildActivity
    @Provides
    public StockDetailsView provideView() {
        return this.activity;
    }

    @ChildActivity
    @Provides
    public StocksRepository provideRepo(StockDataRepository stockDataRepository) {
        return stockDataRepository;
    }

}
