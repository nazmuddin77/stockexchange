package com.example.data.network.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by nazmuddinmavliwala on 29/10/2017.
 */

public class StockDO {

    @SerializedName("id")
    private long id;

    @SerializedName("name")
    private String name;

    @SerializedName("tickr")
    private String tickr;

    @SerializedName("price")
    private List<Long> priceList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTickr() {
        return tickr;
    }

    public void setTickr(String tickr) {
        this.tickr = tickr;
    }

    public List<Long> getPriceList() {
        return priceList;
    }

    public void setPriceList(List<Long> priceList) {
        this.priceList = priceList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
