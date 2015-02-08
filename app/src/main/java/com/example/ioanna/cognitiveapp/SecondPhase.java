package com.example.ioanna.cognitiveapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class SecondPhase extends ActionBarActivity {
    CheckBox firstCheckBox, secCheckBox, thirdCheckBox, fourthCheckBox;
    Button selectButton;
    TextView roundView;
    Chronometer mChronometer;
    static int round = 1;
    int correctAnswers = 0;
    int wrongAnswers = 0;
    List<CheckBox> checkBoxList;
    RandomShapes mRandomShapes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        setContentView(R.layout.activity_second_phase);

        checkBoxList = new ArrayList<>();
        mRandomShapes = new RandomShapes();
        firstCheckBox = (CheckBox) findViewById(R.id.firstCB);
        secCheckBox = (CheckBox) findViewById(R.id.secCB);
        thirdCheckBox = (CheckBox) findViewById(R.id.thirdCB);
        fourthCheckBox = (CheckBox) findViewById(R.id.fourthCB);
        selectButton = (Button) findViewById(R.id.selectBtn);
        roundView = (TextView) findViewById(R.id.round);
        checkBoxList.add(firstCheckBox);
        checkBoxList.add(secCheckBox);
        checkBoxList.add(thirdCheckBox);
        checkBoxList.add(fourthCheckBox);
        roundView = setRoundView(roundView);
        mChronometer = (Chronometer) findViewById(R.id.chronometer1);

        getRandomShapes();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mChronometer.start();
        checkChronometer();
        selectButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                getRandomShapes();
                uncheck();
                score(correctAnswers - wrongAnswers);
                round++;
                roundView = setRoundView(roundView);

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        startActivity(new Intent(SecondPhase.this,MainActivity.class));
    }

    /**
     * Method to check the chronometer and after 30 seconds have passed it kills the activity
     */
    private void checkChronometer() {
        mChronometer.setBase(SystemClock.elapsedRealtime());
        mChronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                long myElapsedMillis = SystemClock.elapsedRealtime() - mChronometer.getBase();
                if (myElapsedMillis > 30000) {
                    mChronometer.stop();
                    SecondPhase.this.finish();

                }
            }
        });
    }

    private TextView setRoundView(TextView roundView1) {
        roundView1.setText("Round : " + Integer.toString(round));
        return roundView1;
    }

    /**
     * Method to uncheck the checkboxes when refreshed
     */
    private void uncheck() {
        for (CheckBox cb : checkBoxList) {
            if (cb.isChecked()) {
                cb.setChecked(false);
            }
        }
    }

    private void getRandomShapes() {
        int i = 0;
        int[] randNo = mRandomShapes.uniqueRandom();
        for (CheckBox cv : checkBoxList) {

            mRandomShapes.getRandomShapeCheckbox(cv, randNo[i]);
            i++;
        }
    }

    /**
     * Method to keep track of the score during rounds
     *
     * @param answers correct-wrong answers
     * @return score after taking into consideration other parameters (time maybe etc)
     */
    private int score(int answers) {
        int score = 0;

        return score;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second_phase, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
