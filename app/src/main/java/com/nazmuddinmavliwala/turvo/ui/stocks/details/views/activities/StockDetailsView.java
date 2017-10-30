package com.nazmuddinmavliwala.turvo.ui.stocks.details.views.activities;

import com.nazmuddin.domain.stocks.models.Stock;
import com.nazmuddinmavliwala.turvo.base.presenters.BaseView;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.models.StockVO;

/**
 * Created by nazmuddinmavliwala on 30/10/2017.
 */

public interface StockDetailsView extends BaseView {
    void showErrorView();

    void showDataView();

    void bind(StockVO stockVO);

    void updateStocks(StockVO stock);
}
