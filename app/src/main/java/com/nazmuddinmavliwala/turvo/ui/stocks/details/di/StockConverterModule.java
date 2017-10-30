package com.nazmuddinmavliwala.turvo.ui.stocks.details.di;

import com.example.data.database.entities.DaoSession;
import com.example.data.stocks.converters.StockDOToEntityConverter;
import com.example.data.stocks.converters.StockEntityToDomainConverter;
import com.nazmuddinmavliwala.turvo.app.di.identifiers.ScopedActivity;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.presenters.StockDomainToVOConverter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nazmuddinmavliwala on 30/10/2017.
 */


@ScopedActivity
@Module
public class StockConverterModule {

    @ScopedActivity
    @Provides
    public StockDOToEntityConverter provideDOToEntityConverter(DaoSession daoSession) {
        return new StockDOToEntityConverter(daoSession);
    }

    @ScopedActivity
    @Provides
    public StockEntityToDomainConverter provideEntityToDomainConverter() {
        return new StockEntityToDomainConverter();
    }

    @ScopedActivity
    @Provides
    public StockDomainToVOConverter provideDomainToVOConverter() {
        return new StockDomainToVOConverter();
    }
}
