package com.nazmuddinmavliwala.turvo.base.di;

import android.content.Context;

import com.example.data.database.entities.DaoSession;
import com.example.data.network.NetworkService;
import com.example.data.stocks.converters.StockDOToEntityConverter;
import com.example.data.stocks.converters.StockEntityToDomainConverter;
import com.nazmuddin.domain.executers.ExecutionThread;
import com.nazmuddin.domain.executers.PostExecutionThread;
import com.nazmuddinmavliwala.turvo.app.di.ApplicationComponent;
import com.nazmuddinmavliwala.turvo.app.di.identifiers.ScopedActivity;
import com.nazmuddinmavliwala.turvo.base.views.BaseActivity;
import com.nazmuddinmavliwala.turvo.ui.stocks.details.di.SockDetailsModule;
import com.nazmuddinmavliwala.turvo.ui.stocks.details.di.StockConverterModule;
import com.nazmuddinmavliwala.turvo.ui.stocks.details.di.StockDetailComponent;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.di.StockListComponent;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.di.StockListModule;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.presenters.StockDomainToVOConverter;

import javax.inject.Named;

import dagger.Component;

/**
 * Created by nazmuddinmavliwala on 27/10/2017.
 */

@ScopedActivity
@Component(
        dependencies = ApplicationComponent.class,
        modules = {
                BaseActivityModule.class,
                RxModule.class,
                StockConverterModule.class
        }
)
public interface BaseActivityComponent {

    @Named("Activity")
    Context provideActivityContext();

    NetworkService provideNetworkService();

    DaoSession provideDaoSession();

    ExecutionThread provideExecutionThread();

    PostExecutionThread providePostExecutionThread();

    StockDOToEntityConverter provideDOToEntityConverter();

    StockEntityToDomainConverter provideEntityToDomainConverter();

    StockDomainToVOConverter provideDomainToVOConverter();

    void inject(BaseActivity activity);

    StockListComponent provideStockListComponent(StockListModule module);

    StockDetailComponent provideStockDetailComponent(SockDetailsModule module);

}
