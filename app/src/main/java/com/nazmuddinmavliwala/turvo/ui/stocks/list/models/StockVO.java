package com.nazmuddinmavliwala.turvo.ui.stocks.list.models;

import java.util.List;

/**
 * Created by nazmuddinmavliwala on 28/10/2017.
 */

public class StockVO {

    private final long id;
    private final String name;
    private final String tckrName;
    private final List<Long> prices;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTckrName() {
        return tckrName;
    }

    public List<Long> getPrices() {
        return prices;
    }

    public StockVO(long id, String name, String tckrName, List<Long> prices) {
        this.id = id;
        this.name = name;
        this.tckrName = tckrName;
        this.prices = prices;
    }

    public static class StockVOBuilder {

        private long id;
        private String name;
        private String tckrName;
        private List<Long> prices;

        public StockVOBuilder setId(long id) {
            this.id = id;
            return this;
        }

        public StockVOBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StockVOBuilder setTckrName(String tckrName) {
            this.tckrName = tckrName;
            return this;
        }

        public StockVOBuilder setPrices(List<Long> prices) {
            this.prices = prices;
            return this;
        }

        public StockVO createStockVO() {
            return new StockVO(id, name, tckrName, prices);
        }
    }
}
