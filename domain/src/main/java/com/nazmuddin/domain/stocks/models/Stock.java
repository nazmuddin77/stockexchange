package com.nazmuddin.domain.stocks.models;

import java.util.List;

/**
 * Created by nazmuddinmavliwala on 29/10/2017.
 */

public class Stock {

    private final long id;
    private final String name;
    private final String tckr;
    private final List<Long> prices;

    public Stock(long id, String name, String tckr, List<Long> prices) {
        this.id = id;
        this.name = name;
        this.tckr = tckr;
        this.prices = prices;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTckr() {
        return tckr;
    }

    public List<Long> getPrices() {
        return prices;
    }

    public static class StockBuilder {

        private long id;
        private String name;
        private String tckr;
        private List<Long> prices;

        public StockBuilder setId(long id) {
            this.id = id;
            return this;
        }

        public StockBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StockBuilder setTckr(String tckr) {
            this.tckr = tckr;
            return this;
        }

        public StockBuilder setPrices(List<Long> prices) {
            this.prices = prices;
            return this;
        }

        public Stock createStock() {
            return new Stock(id, name, tckr, prices);
        }
    }
}
