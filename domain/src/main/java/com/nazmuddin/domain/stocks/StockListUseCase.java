package com.nazmuddin.domain.stocks;

import com.nazmuddin.domain.base.UseCase;
import com.nazmuddin.domain.executers.ExecutionThread;
import com.nazmuddin.domain.executers.PostExecutionThread;
import com.nazmuddin.domain.stocks.models.Stock;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Created by nazmuddinmavliwala on 29/10/2017.
 */

public class StockListUseCase extends UseCase<StocksRepository> {

    @Inject
    public StockListUseCase(ExecutionThread executionThread,
                            PostExecutionThread postExecutionThread,
                            StocksRepository repository) {
        super(executionThread, postExecutionThread, repository);
    }

    public void fetchStocks(Subscriber<List<Stock>> subscriber) {
        this.repository.fetchStocks()
                .delay(2, TimeUnit.SECONDS)
                .compose(applySchedulers())
                .subscribe(subscriber);
    }
}
