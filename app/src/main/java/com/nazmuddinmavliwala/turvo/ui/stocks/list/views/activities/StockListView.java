package com.nazmuddinmavliwala.turvo.ui.stocks.list.views.activities;

import com.nazmuddinmavliwala.turvo.base.presenters.BaseView;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.models.StockVO;

import java.util.List;

/**
 * Created by nazmuddinmavliwala on 28/10/2017.
 */

public interface StockListView extends BaseView {
    void showErrorView();

    void showDataView();

    void bind(List<StockVO> stockVOS);
}
