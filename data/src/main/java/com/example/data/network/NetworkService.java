package com.example.data.network;

import com.example.data.network.models.StockListDO;

import rx.Observable;


/**
 * Created by nazmuddinmavliwala on 29/10/2017.
 */

public interface NetworkService {

    Observable<StockListDO> getStocks();
}
