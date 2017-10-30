package com.nazmuddin.domain.stocks;

import com.nazmuddin.domain.base.UseCase;
import com.nazmuddin.domain.executers.ExecutionThread;
import com.nazmuddin.domain.executers.PostExecutionThread;
import com.nazmuddin.domain.stocks.models.Stock;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Subscriber;
import rx.functions.Action1;

/**
 * Created by nazmuddinmavliwala on 30/10/2017.
 */

public class StockDetailsUseCase extends UseCase<StocksRepository> {

    @Inject
    public StockDetailsUseCase(ExecutionThread executionThread,
                               PostExecutionThread postExecutionThread,
                               StocksRepository repository) {
        super(executionThread, postExecutionThread, repository);
    }

    public void fetchStockDetails(Long stockId, Subscriber<Stock> subscriber) {
        this.repository.fetchStockWithId(stockId)
                .delay(2, TimeUnit.SECONDS)
                .compose(applySchedulers())
                .subscribe(subscriber);
    }

    public void toggleValuesOfStock(long stockId, Action1<Stock> subscriber) {
        this.repository.toggleValuesOfStock(stockId)
                .compose(applySchedulers())
                .subscribe(subscriber);
    }
}
