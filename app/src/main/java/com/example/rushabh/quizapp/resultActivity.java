package com.example.rushabh.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class resultActivity extends AppCompatActivity {

    private static String TAG="resultActivity";

    //Intent intent = getIntent().getExtras();
    //private int op1;
     /*float v1=intent.getIntExtra("Option 1",op1);
    //float value1 = intent.getIntExtra("Option 1",op1);
    private int op2;
    float value2 = intent.getIntExtra("Option 2",op2);
    private int op3;
    float value3 = intent.getIntExtra("Option 3",op3);*/

    //Intent intent= getIntent();
    //public int value1=intent.getIntExtra("Option 1",op1);
    //extras.getInt("Option 1",op1);


    //private float[] yData = {value1,value2,value3};
    //private int [] yData = {21, 2, 2};
    private float[] yData = {21f, 2f, 2f};
    private String[] xData = {"High Risk", "Contradiction", "Acceptable"};

    PieChart mChart;
     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_result);



         Log.d(TAG,"onCreate:Startting to create pie chart");
         Log.d(TAG, "X Data.length"+xData.length);
         Log.d(TAG, "Y Data.length"+yData.length);
         mChart = (PieChart)findViewById(R.id.chart1);
         mChart.setRotationEnabled(true);
         mChart.setHoleRadius(25f);
         mChart.setCenterText("Results");
         mChart.setCenterTextColor(Color.rgb(0,94,156));
         mChart.setCenterTextSize(10);
         mChart.setTransparentCircleAlpha(5);
         //mChart.setDrawEntryLabels(true);
         addDataSet();
         mChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
             @Override
             public void onValueSelected(Entry entry, int i, Highlight highlight) {
                 Log.d(TAG, "onValueSelected: value selected from chart");
                 Log.d(TAG, "onValueSelected: "+ entry.toString());
                 Log.d(TAG, "onValueSelected: "+ highlight.toString());
             }

             @Override
             public void onNothingSelected() {

             }
         });
     }

    private void addDataSet() {
        Log.d(TAG,"Add DataSet Started");
        ArrayList<Entry> yEntrys=new ArrayList<>();
        ArrayList<String> xEntrys=new ArrayList<>();
        for (int i=0;i<yData.length;i++)
        {
            yEntrys.add(new Entry(yData[i],i));
        }
        for(int i=0;i<xData.length;i++)
        {
            xEntrys.add(xData[i]);
        }

        Log.d(TAG,"yEntrys "+yEntrys);
        Log.d(TAG,"xEntrys "+xEntrys);

        //Create Dataset
        PieDataSet pieDataSet = new PieDataSet(yEntrys,"");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(30);

        //Add colors to Dataset
        ArrayList<Integer> colors=new ArrayList<>();
        final int[] MY_COLORS = {Color.rgb(8,65,115), Color.rgb(255,0,0), Color.rgb(27,160,1)};
        for(int c: MY_COLORS) colors.add(c);


        pieDataSet.setColors(colors);

        //Add legend to chart
        Legend legend=mChart.getLegend();
        legend.setForm(Legend.LegendForm.SQUARE);
        legend.setPosition(Legend.LegendPosition.BELOW_CHART_CENTER);

        //Create pie Data Object
        //PieData pieData = new PieData(pieDataSet);
        //PieData pieData = new PieData(xData);
        //mChart.setData(pieData);
        PieDataSet dataSet = new PieDataSet(yEntrys,"");
        PieData data = new PieData(xEntrys, dataSet);
        dataSet.setColors(colors);
        mChart.setData(data);
        mChart.invalidate();

    }
}














