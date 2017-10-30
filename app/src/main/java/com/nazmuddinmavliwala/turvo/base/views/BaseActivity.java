package com.nazmuddinmavliwala.turvo.base.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hendraanggrian.rx.activity.RxActivity;
import com.nazmuddinmavliwala.turvo.app.TurvoApp;
import com.nazmuddinmavliwala.turvo.base.HasComponent;
import com.nazmuddinmavliwala.turvo.base.di.BaseActivityComponent;
import com.nazmuddinmavliwala.turvo.base.di.BaseActivityModule;
import com.nazmuddinmavliwala.turvo.base.di.DaggerBaseActivityComponent;
import com.nazmuddinmavliwala.turvo.base.di.RxModule;

/**
 * Created by nazmuddinmavliwala on 27/10/2017.
 */

public abstract class BaseActivity extends AppCompatActivity implements HasComponent<BaseActivityComponent> {

    private BaseActivityComponent component;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        this.component = DaggerBaseActivityComponent.builder()
                .applicationComponent(TurvoApp.getComponent())
                .baseActivityModule(new BaseActivityModule(this))
                .rxModule(new RxModule())
                .build();
        this.component.inject(this);
    }

    protected abstract int getLayout();

    @Override
    public BaseActivityComponent getComponent() {
        return this.component;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        RxActivity.onActivityResult(requestCode, resultCode, data);
    }
}
