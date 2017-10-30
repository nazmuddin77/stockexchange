package com.example.data.stocks;

import com.example.data.database.entities.DaoSession;
import com.example.data.database.entities.StockEntity;
import com.example.data.database.entities.StockPriceEntity;
import com.example.data.network.NetworkService;
import com.example.data.network.models.StockDO;
import com.example.data.network.models.StockListDO;
import com.example.data.stocks.converters.StockDOToEntityConverter;
import com.example.data.stocks.converters.StockEntityToDomainConverter;
import com.example.data.utils.RandomPriceUtil;
import com.nazmuddin.domain.stocks.StocksRepository;
import com.nazmuddin.domain.stocks.models.Stock;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by nazmuddinmavliwala on 29/10/2017.
 */

public class StockDataRepository implements StocksRepository {

    private DaoSession daoSession;
    private NetworkService service;
    private final StockEntityToDomainConverter entityToDomainConverter;
    private final StockDOToEntityConverter doToEntityConverter;

    @Inject
    public StockDataRepository(DaoSession daoSession,
                               NetworkService service,
                               StockEntityToDomainConverter entityToDomainConverter,
                               StockDOToEntityConverter doToEntityConverter) {
        this.daoSession = daoSession;
        this.service = service;
        this.entityToDomainConverter = entityToDomainConverter;
        this.doToEntityConverter = doToEntityConverter;
    }

    @Override
    public Observable<List<Stock>> fetchStocks() {
        long count = this.daoSession.getStockEntityDao().count();
        if (count == 0) {
            //prepare data set
            return this.service.getStocks() //get from mock network
                    .doOnNext(this::insert) //cache
                    .switchMap(ignored -> this.daoSession.getStockEntityDao().rx()
                            .loadAll()
                            .map(stockEntities -> {
                                List<Stock> stocks = new ArrayList<>();
                                for (StockEntity stockEntity : stockEntities) {
                                    stocks.add(this.entityToDomainConverter.convert(stockEntity));
                                }
                                return stocks;
                            })
                    );
        }
        return this.daoSession.getStockEntityDao().rx()
                .loadAll()
                .map(stockEntities -> {
                    List<Stock> stocks = new ArrayList<>();
                    for (StockEntity stockEntity : stockEntities) {
                        stocks.add(this.entityToDomainConverter.convert(stockEntity));
                    }
                    return stocks;
                });
    }

    @Override
    public Observable<Stock> fetchStockWithId(long stockId) {
        return this.daoSession.getStockEntityDao().rx()
                .load(stockId)
                .map(this.entityToDomainConverter::convert);
    }

    @Override
    public Observable<Stock> toggleValuesOfStock(long stockId) {
        StockEntity stock = this.daoSession.getStockEntityDao().load(stockId);
        List<StockPriceEntity> prices = stock.getStockPrices();
        for (StockPriceEntity stockPriceEntity : prices) {
            stockPriceEntity.setValue(RandomPriceUtil.getRandomPrice());
            this.daoSession.getStockPriceEntityDao().update(stockPriceEntity);
        }
        return this.daoSession.getStockEntityDao().rx()
                .load(stockId)
                .map(this.entityToDomainConverter::convert);
    }

    private void insert(StockListDO data) {
        List<StockDO> stocks = data.getStockDOS();
        for (StockDO stockDO : stocks) {
            StockEntity stockEntity = this.doToEntityConverter.convert(stockDO);
            this.daoSession.getStockEntityDao().insertOrReplace(stockEntity);
        }
    }
}
