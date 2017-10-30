package com.example.data.network.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by nazmuddinmavliwala on 29/10/2017.
 */

public class StockListDO {

    @SerializedName("stocks")
    private List<StockDO> stockDOS;

    public List<StockDO> getStockDOS() {
        return stockDOS;
    }

    public void setStockDOS(List<StockDO> stockDOS) {
        this.stockDOS = stockDOS;
    }
}
