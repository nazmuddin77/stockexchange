package com.nazmuddinmavliwala.turvo.ui.stocks.details.presenters;

import com.nazmuddin.domain.stocks.StockDetailsUseCase;
import com.nazmuddin.domain.stocks.models.Stock;
import com.nazmuddinmavliwala.turvo.base.presenters.BasePresenter;
import com.nazmuddinmavliwala.turvo.ui.stocks.details.views.activities.StockDetailsView;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.models.StockVO;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.presenters.StockDomainToVOConverter;

import javax.inject.Inject;

import rx.Subscriber;
import rx.functions.Action1;

/**
 * Created by nazmuddinmavliwala on 30/10/2017.
 */

public class StockDetailsPresenter extends BasePresenter<StockDetailsView> {

    private final StockDetailsUseCase useCase;
    private final StockDomainToVOConverter converter;

    @Inject
    public StockDetailsPresenter(StockDetailsView view,
                                 StockDetailsUseCase useCase,
                                 StockDomainToVOConverter converter) {
        super(view);
        this.useCase = useCase;
        this.converter = converter;
    }

    public void fetchStockDetails(Long stockId) {
        this.view.showLoading();
        this.useCase.fetchStockDetails(stockId, new Subscriber<Stock>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                view.hideLoading();
                view.showErrorView();
            }

            @Override
            public void onNext(Stock stock) {
                view.hideLoading();
                view.showDataView();
                StockVO stockVO = converter.convert(stock);
                view.bind(stockVO);
            }
        });
    }

    public void toggleValueOfStock(long stockId) {
        this.useCase.toggleValuesOfStock(stockId, stock -> {
            StockVO stockVO = this.converter.convert(stock);
                view.updateStocks(stockVO);
        });
    }
}
