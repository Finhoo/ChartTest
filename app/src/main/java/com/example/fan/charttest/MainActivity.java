package com.example.fan.charttest;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LineChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mChart = findViewById(R.id.chart);
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            entries.add(new Entry(i, (float)(Math.random() * 100)));
        }
        LineDataSet dataSet = new LineDataSet(entries, "label");
        dataSet.setColor(Color.rgb(192,192,192));
        dataSet.setLineWidth(2f);
        dataSet.setCircleColor(Color.rgb(192,192,192));
        dataSet.setDrawCircleHole(false);
        dataSet.setCircleRadius(3f);
        LineData lineData = new LineData(dataSet);
        lineData.setValueTextColor(Color.rgb(153,153,153));
        lineData.setValueTextSize(9f);
        mChart.setData(lineData);

        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setLabelCount(30);
        xAxis.setTextColor(Color.rgb(153,153,153));


        YAxis yAxisLeft = mChart.getAxisLeft();
        yAxisLeft.setLabelCount(12);
        yAxisLeft.setAxisMinimum(0);
        yAxisLeft.setTextColor(Color.rgb(153,153,153));
        xAxis.setGridDashedLine(new DashPathEffect(new float[]{5, 10, 5, 10}, 0));
        yAxisLeft.setDrawGridLines(false);
        yAxisLeft.setDrawAxisLine(false);
        xAxis.setDrawAxisLine(false);
        YAxis yAxisRight = mChart.getAxisRight();
        yAxisRight.setEnabled(false);
        mChart.setScaleEnabled(false);
        Matrix m = new Matrix();
        m.postScale(20f, 1);
        mChart.getViewPortHandler().refresh(m, mChart, false);
        mChart.invalidate();
        mChart.moveViewToX(99);
        mChart.getDescription().setEnabled(false);
        Legend l = mChart.getLegend();
        l.setEnabled(false);
    }

    class Data {
        int x, y;
    }
}
