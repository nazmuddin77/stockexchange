package com.example.data.network;

import android.content.Context;

import com.example.data.network.models.StockDO;
import com.example.data.network.models.StockListDO;
import com.example.data.utils.FileUtils;
import com.example.data.utils.RandomPriceUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by nazmuddinmavliwala on 29/10/2017.
 */


@Singleton
public class NetworkManager implements NetworkService {

    private static final String FILE_NAME = "data.json";
    private Context context;
    private Gson gson;


    @Inject
    public NetworkManager(@Named("Application") Context context,
                          Gson gson) {
        this.context = context;
        this.gson = gson;
    }

    @Override
    public Observable<StockListDO> getStocks() {
        String file = FileUtils.loadJSONFromAsset(this.context, FILE_NAME);
        StockListDO data = this.gson.fromJson(file, StockListDO.class);
        List<StockDO> stocks = data.getStockDOS();
        for (StockDO stockDO : stocks) {
            List<Long> stockPrices = new ArrayList<>();
            for (int i = 0 ; i < 10 ; i ++) {
                stockPrices.add(RandomPriceUtil.getRandomPrice());
            }
            stockDO.setPriceList(stockPrices);
        }
        return Observable.just(data);
    }
}
