package com.nazmuddinmavliwala.turvo.ui.stocks.list.views.viewdelegates;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hendraanggrian.rx.activity.ActivityResult;
import com.hendraanggrian.rx.activity.RxActivity;
import com.nazmuddinmavliwala.turvo.R;
import com.nazmuddinmavliwala.turvo.base.views.BaseViewDelegate;
import com.nazmuddinmavliwala.turvo.ui.stocks.details.views.activities.StockDetailsActivity;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.models.StockVO;
import com.nazmuddinmavliwala.turvo.ui.stocks.list.views.adapters.StockListAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import rx.Observable;
import rx.functions.Func1;

import static com.nazmuddinmavliwala.turvo.ui.stocks.details.views.activities.StockDetailsActivity.STOCK_ID;

/**
 * Created by nazmuddinmavliwala on 29/10/2017.
 */

public class StockListViewDelegate extends BaseViewDelegate<List<StockVO>> {

    @BindView(R.id.rv_data)
    RecyclerView rvData;

    @Inject
    public StockListViewDelegate(@NonNull @Named("Activity") Context context,
                                 @NonNull @Named("StockList") View view) {
        super(context, view);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this.context);
        rvData.setLayoutManager(manager);
        StockListAdapter adapter = new StockListAdapter(this.context);
        adapter.getReactiveViewClickObservable()
                .map(o -> (StockVO)o)
                .map(stockVO -> {
                    Intent intent = new Intent(context, StockDetailsActivity.class);
                    intent.putExtra(STOCK_ID,stockVO.getId());
                    return intent;
                })
                .switchMap(intent -> RxActivity.startForResult((Activity)context,intent))
                .subscribe();
        rvData.setAdapter(adapter);
    }

    @Override
    public void bind(List<StockVO> data) {
        List<Object> objects = new ArrayList<>();
        objects.addAll(data);
        ((StockListAdapter)rvData.getAdapter()).append(objects);
    }
}
