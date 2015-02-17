package com.example.ioanna.cognitiveapp;

import android.app.Activity;
import android.graphics.*;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import com.androidplot.pie.PieChart;
import com.androidplot.pie.PieRenderer;
import com.androidplot.pie.Segment;
import com.androidplot.pie.SegmentFormatter;

/**
 * The simplest possible example of using AndroidPlot to plot some data.
 */
public class PieChartActivity extends Activity
{

    private TextView donutSizeTextView;
    private SeekBar donutSizeSeekBar;

    private PieChart pie;

    private Segment s1;
    private Segment s2;
    private Segment s3;
    private Segment s4;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        // initialize our XYPlot reference:
        pie = (PieChart) findViewById(R.id.mySimplePieChart);


        //  donutSizeSeekBar = (SeekBar) findViewById(R.id.donutSizeSeekBar);

        //donutSizeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {}
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {}
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//                pie.getRenderer(PieRenderer.class).setDonutSize(seekBar.getProgress()/10f,
//                        PieRenderer.DonutMode.PERCENT);
//                pie.redraw();
//                updateDonutText();
//            }
//        });

        // donutSizeTextView = (TextView) findViewById(R.id.donutSizeTextView);
        // updateDonutText();

        s1 = new Segment("Attention\n 20%", 20);
        s2 = new Segment("Memory\n 40%", 40);
        s3 = new Segment("Speed\n 20%", 20);
        s4 = new Segment("Fluency\n 30%", 30);

        EmbossMaskFilter emf = new EmbossMaskFilter(
                new float[]{1, 1, 1}, 1.2f, 5, 8.2f);

        SegmentFormatter sf1 = new SegmentFormatter();
        sf1.configure(getApplicationContext(), R.xml.pie_segment_formatter1);

        //sf1.getFillPaint().setMaskFilter(emf);

        SegmentFormatter sf2 = new SegmentFormatter();
        sf2.configure(getApplicationContext(), R.xml.pie_segment_formatter2);

        //sf2.getFillPaint().setMaskFilter(emf);

        SegmentFormatter sf3 = new SegmentFormatter();
        sf3.configure(getApplicationContext(), R.xml.pie_segment_formatter3);

        //sf3.getFillPaint().setMaskFilter(emf);

        SegmentFormatter sf4 = new SegmentFormatter();
        sf4.configure(getApplicationContext(), R.xml.pie_segment_formatter4);

        //sf4.getFillPaint().setMaskFilter(emf);

        pie.addSeries(s1, sf1);
        pie.addSeries(s2, sf2);
        pie.addSeries(s3, sf3);
        pie.addSeries(s4, sf4);

        pie.getBorderPaint().setColor(Color.TRANSPARENT);
        pie.getBackgroundPaint().setColor(Color.TRANSPARENT);
    }


}