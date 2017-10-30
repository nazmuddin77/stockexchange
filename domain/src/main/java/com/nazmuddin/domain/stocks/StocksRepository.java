package com.nazmuddin.domain.stocks;

import com.nazmuddin.domain.base.Repository;
import com.nazmuddin.domain.stocks.models.Stock;

import java.util.List;

import rx.Observable;

/**
 * Created by nazmuddinmavliwala on 29/10/2017.
 */

public interface StocksRepository extends Repository {

    Observable<List<Stock>> fetchStocks();

    Observable<Stock> fetchStockWithId(long stockId);

    Observable<Stock> toggleValuesOfStock(long stockId);
}
