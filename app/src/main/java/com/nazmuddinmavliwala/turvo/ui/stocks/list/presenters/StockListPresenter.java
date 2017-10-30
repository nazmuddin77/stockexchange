package com.nazmuddinmavliwala.turvo.ui.stocks.list.presenters;

import com.nazmuddin.domain.stocks.StockListUseCase;
import com.nazmuddin.domain.stocks.models.Stock;
import com.nazmuddinmavliwala.turvo.base.presenters.BasePresenter;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.models.StockVO;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.views.activities.StockListView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Created by nazmuddinmavliwala on 28/10/2017.
 */

public class StockListPresenter extends BasePresenter<StockListView> {

    private StockListUseCase useCase;
    private StockDomainToVOConverter converter;

    @Inject
    public StockListPresenter(StockListView view,
                              StockListUseCase useCase,
                              StockDomainToVOConverter converter) {
        super(view);
        this.useCase = useCase;
        this.converter = converter;
    }

    public void fetchStockList() {
        this.view.showLoading();
        this.useCase.fetchStocks(new Subscriber<List<Stock>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                view.hideLoading();
                view.showErrorView();

            }

            @Override
            public void onNext(List<Stock> stocks) {
                view.hideLoading();
                view.showDataView();
                List<StockVO> stockVOS = new ArrayList<>();
                for (Stock stock :stocks) {
                    stockVOS.add(converter.convert(stock));
                }
                view.bind(stockVOS);
            }
        });
    }
}


