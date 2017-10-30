package com.example.data.stocks.converters;

import android.content.Loader;

import com.example.data.database.entities.DaoSession;
import com.example.data.database.entities.StockEntity;
import com.example.data.database.entities.StockPriceEntity;
import com.example.data.database.entities.StockPriceEntityDao;
import com.example.data.network.models.StockDO;
import com.nazmuddin.domain.Converter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by nazmuddinmavliwala on 29/10/2017.
 */

public class StockDOToEntityConverter implements Converter<StockDO,StockEntity> {

    private DaoSession daoSession;

    @Inject
    public StockDOToEntityConverter(DaoSession daoSession) {
        this.daoSession = daoSession;
    }

    @Override
    public StockEntity convert(StockDO data) {
        if (data == null) throw new IllegalArgumentException("data from network cannot be null");
        StockEntity stockEntity = new StockEntity();
        stockEntity.setId(data.getId());
        stockEntity.setName(data.getName());
        stockEntity.setTickrName(data.getTickr());

        // one to many stock price
        List<Long> prices = data.getPriceList();
        StockPriceEntityDao priceDao = this.daoSession.getStockPriceEntityDao();
        for (Long price : prices) {
            StockPriceEntity stockPriceEntity = new StockPriceEntity();
            stockPriceEntity.setStockId(data.getId());
            stockPriceEntity.setValue(price);
            priceDao.insertOrReplace(stockPriceEntity);
        }
        return stockEntity;
    }
}
