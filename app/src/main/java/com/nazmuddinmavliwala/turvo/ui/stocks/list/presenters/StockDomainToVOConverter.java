package com.nazmuddinmavliwala.turvo.ui.stocks.list.presenters;

import com.nazmuddin.domain.stocks.models.Stock;
import com.nazmuddin.domain.Converter;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.models.StockVO;

import java.util.List;

/**
 * Created by nazmuddinmavliwala on 29/10/2017.
 */

public class StockDomainToVOConverter implements Converter<Stock,StockVO> {

    @Override
    public StockVO convert(Stock data) {
        return new StockVO.StockVOBuilder()
                .setId(data.getId())
                .setName(data.getName())
                .setTckrName(data.getTckr())
                .setPrices(data.getPrices())
                .createStockVO();
    }
}
