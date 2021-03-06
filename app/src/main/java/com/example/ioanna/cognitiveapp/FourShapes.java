package com.example.ioanna.cognitiveapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class FourShapes extends ActionBarActivity {

    Button timerButton;
    TextView timer;
    ImageView imageView;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ProgressBar progressBar;
    RandomShapes mRandomShapes;
    List<ImageView> imageViewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        setContentView(R.layout.activity_four_shapes);
        mRandomShapes = new RandomShapes();
        timerButton = (Button) findViewById(R.id.timerButton);

        setButtonOnClickListeners();

        timer = (TextView) findViewById(R.id.timer);
        imageViewList = new ArrayList<>();
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageViewList.add(imageView);
        imageViewList.add(imageView2);
        imageViewList.add(imageView3);
        imageViewList.add(imageView4);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

    }

    private void setButtonOnClickListeners() {
        timerButton.setOnClickListener(new View.OnClickListener() {

            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                int i = 0;
                int[] randNo = mRandomShapes.uniqueRandom();
                for (ImageView iv : imageViewList) {

                    mRandomShapes.getRandomShape(iv, randNo[i]);
                    i++;
                }

                CheckAnswers.getInstance().setImageViewList(imageViewList);
                Log.i("MainActivity imageview list", Integer.toString(imageViewList.size()));

                timerButton.setEnabled(false);
                CountDownTimer Count = new CountDownTimer(10000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        int seconds = (int) ((millisUntilFinished / 1000));

                        timer.setText(seconds + "  seconds ");

                        progressBar.setProgress((int) Math.round(millisUntilFinished / 1000.0));


                    }

                    public void onFinish() {
                        //jump to next activity using intent
                        // Next = 1;
                        Intent intent = new Intent(FourShapes.this, SecondPhase.class);
                        startActivity(intent);
                        FourShapes.this.finish();
                        //System.exit(0);

                    }
                };

                Count.start();
            }
        });

    }
}