package com.example.data.stocks.converters;

import com.example.data.database.entities.StockEntity;
import com.example.data.database.entities.StockPriceEntity;
import com.nazmuddin.domain.Converter;
import com.nazmuddin.domain.stocks.models.Stock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nazmuddinmavliwala on 29/10/2017.
 */

public class StockEntityToDomainConverter implements Converter<StockEntity, Stock> {

    @Override
    public Stock convert(StockEntity data) {
        List<StockPriceEntity> stockPriceEntities = data.getStockPrices();
        List<Long> prices = new ArrayList<>();
        for (StockPriceEntity stockPriceEntity : stockPriceEntities) {
            prices.add(stockPriceEntity.getValue());
        }
        return new Stock.StockBuilder()
                .setId(data.getId())
                .setName(data.getName())
                .setTckr(data.getTickrName())
                .setPrices(prices)
                .createStock();
    }
}
