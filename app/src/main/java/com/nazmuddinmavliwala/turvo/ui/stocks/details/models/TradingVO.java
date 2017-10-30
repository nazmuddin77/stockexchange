package com.nazmuddinmavliwala.turvo.ui.stocks.details.models;

import android.support.annotation.NonNull;

/**
 * Created by nazmuddinmavliwala on 30/10/2017.
 */

public class TradingVO implements Comparable<TradingVO> {

    private Long diff;
    private final Long purchase;
    private final Long sell;

    public TradingVO(Long diff, Long purchase, Long sell) {
        this.diff = diff;
        this.purchase = purchase;
        this.sell = sell;
    }

    public Long getPurchase() {
        return purchase;
    }

    public Long getDiff() {
        return diff;
    }

    public void setDiff(Long diff) {
        this.diff = diff;
    }

    public Long getSell() {
        return sell;
    }

    @Override
    public int compareTo(@NonNull TradingVO tradingVO) {
        return (int) (tradingVO.getDiff() - diff);
    }
}
