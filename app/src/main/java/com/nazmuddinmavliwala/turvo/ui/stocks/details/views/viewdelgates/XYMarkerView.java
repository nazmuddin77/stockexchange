package com.nazmuddinmavliwala.turvo.ui.stocks.details.views.viewdelgates;

import android.content.Context;
import android.widget.TextView;

import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;
import com.nazmuddinmavliwala.turvo.R;

import java.text.DecimalFormat;

/**
 * Created by nazmuddinmavliwala on 29/10/2017.
 */

public class XYMarkerView extends MarkerView {

    private TextView tvContent;
    private IAxisValueFormatter xAxisValueFormatter;

    private DecimalFormat format;

    public XYMarkerView(Context context, IAxisValueFormatter xAxisValueFormatter) {
        super(context, R.layout.custom_marker_view);

        this.xAxisValueFormatter = xAxisValueFormatter;
        tvContent = (TextView) findViewById(R.id.tvContent);
        format = new DecimalFormat("###.0");
    }

    // callbacks everytime the MarkerView is redrawn, can be used to update the
    // content (user-interface)
    @Override
    public void refreshContent(Entry e, Highlight highlight) {

        tvContent.setText("x: " + xAxisValueFormatter.getFormattedValue(e.getX(), null) + ", y: " + format.format(e.getY()));

        super.refreshContent(e, highlight);
    }

    @Override
    public MPPointF getOffset() {
        return new MPPointF(-(getWidth() / 2), -getHeight());
    }
}
