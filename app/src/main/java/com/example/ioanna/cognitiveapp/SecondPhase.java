package com.example.ioanna.cognitiveapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class SecondPhase extends ActionBarActivity {
    CheckBox firstCheckBox, secCheckBox, thirdCheckBox, fourthCheckBox;
    Button selectButton;
    int correctAnswers = 0;
    int wrongAnswers = 0;
    List<CheckBox> checkBoxList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_phase);
        checkBoxList = new ArrayList<>();
        firstCheckBox = (CheckBox) findViewById(R.id.firstCB);

        selectButton = (Button) findViewById(R.id.selectBtn);

        checkBoxList.add(firstCheckBox);
    }

    @Override
    protected void onResume() {
        super.onResume();
        selectButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                randomShape();
                score(correctAnswers - wrongAnswers);
            }
        });
        randomShape();
    }

    private void randomShape() {
        for (CheckBox cb : checkBoxList) {
            Random x = new Random();
            int y = x.nextInt(16) + 1;

            switch (y) {
                case 1:
                    cb.setBackgroundResource(R.drawable.blue_circle);
                    break;
                case 2:
                    cb.setBackgroundResource(R.drawable.blue_rect);
                    break;
                case 3:
                    cb.setBackgroundResource(R.drawable.blue_star);
                    break;
                case 4:
                    cb.setBackgroundResource(R.drawable.blue_triangle);
                    break;
                case 5:
                    cb.setBackgroundResource(R.drawable.green_circle);
                    break;
                case 6:
                    cb.setBackgroundResource(R.drawable.green_rect);
                    break;
                case 7:
                    cb.setBackgroundResource(R.drawable.green_star);
                    break;
                case 8:
                    cb.setBackgroundResource(R.drawable.green_triangle);
                    break;
                case 9:
                    cb.setBackgroundResource(R.drawable.pink_circle);
                    break;
                case 10:
                    cb.setBackgroundResource(R.drawable.pink_rect);
                    break;
                case 11:
                    cb.setBackgroundResource(R.drawable.pink_star);
                    break;
                case 12:
                    cb.setBackgroundResource(R.drawable.pink_triangle);
                    break;
                case 13:
                    cb.setBackgroundResource(R.drawable.orange_circle);
                    break;
                case 14:
                    cb.setBackgroundResource(R.drawable.orange_rect);
                    break;
                case 15:
                    cb.setBackgroundResource(R.drawable.orange_star);
                    break;
                case 16:
                    cb.setBackgroundResource(R.drawable.orange_triangle);
                    break;
            }
        }
    }

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
