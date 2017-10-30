package com.nazmuddinmavliwala.turvo.base.views.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by nazmuddinmavliwala on 26/12/15.
 */
public interface AdapterDelegate<T> {

    int getItemViewType();

    boolean isForViewType(@NonNull T items, int position);

    @NonNull
    RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent);

    void onBindViewHolder(@NonNull T items, int position, @NonNull RecyclerView.ViewHolder holder);
}
