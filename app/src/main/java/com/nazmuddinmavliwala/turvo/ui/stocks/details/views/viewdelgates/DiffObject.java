package com.nazmuddinmavliwala.turvo.ui.stocks.details.views.viewdelgates;

import android.support.annotation.NonNull;

import java.util.Comparator;

/**
 * Created by nazmuddinmavliwala on 30/10/2017.
 */

public class DiffObject implements Comparable<DiffObject> {

    private final long diff;
    private final long purchase;
    private final long sell;

    public DiffObject(long diff, long purchase, long sell) {
        this.diff = diff;
        this.purchase = purchase;
        this.sell = sell;
    }

    public long getDiff() {
        return diff;
    }

    public long getPurchase() {
        return purchase;
    }

    public long getSell() {
        return sell;
    }


    @Override
    public int compareTo(@NonNull DiffObject diffObject) {
        return (int) (diffObject.getDiff() - this.diff);
    }
}
