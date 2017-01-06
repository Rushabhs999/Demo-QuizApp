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

    public float[] yData = {21f, 2f, 2f};
    //public float[] yData ;
    public String[] xData = {"High Risk", "Contradiction", "Acceptable"};
    public int value1=0;
    public int value2=0;
    public int value3=0;
    PieChart mChart;
     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_result);

         Intent intent= getIntent();
         value1=0;
         value2=0;
         value3=0;
         value1=intent.getIntExtra("Option 1",1);
         value2=intent.getIntExtra("Option 2",2);
         value3=intent.getIntExtra("Option 3",3);

         for(int i=0;i<yData.length;i++)
         {
             yData[0]=value1;
             yData[1]=value2;
             yData[2]=value3;
         }

         Log.d(TAG,"onCreate:Startting to create pie chart");
         Log.d(TAG, "value1  "+value1);
         Log.d(TAG, "value2  "+value2);
         Log.d(TAG, "value3  "+value3);
         Log.d(TAG, "X Data.length"+xData.length);
         Log.d(TAG, "Y Data.length"+yData.length);
         mChart = (PieChart)findViewById(R.id.chart1);
         mChart.setRotationEnabled(true);
         mChart.setHoleRadius(50f);
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














