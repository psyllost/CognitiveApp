package com.example.ioanna.cognitiveapp;

import android.widget.CheckBox;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class RandomShapes {

    public RandomShapes() {

    }

    public int[] uniqueRandom() {
        int rnd;
        Random rand = new Random();
        int[] randNo = new int[4];
        ArrayList numbers = new ArrayList();
        for (int k = 0; k < 4; k++) {
            rnd = rand.nextInt(16) + 1;
            if (k == 0) {
                randNo[0] = rnd;
                numbers.add(randNo[0]);
            } else {
                while (numbers.contains(new Integer(rnd))) {
                    rnd = rand.nextInt(16) + 1;
                }
                randNo[k] = rnd;
                numbers.add(randNo[k]);
            }
        }
        return randNo;
    }

    /**
     * Method to generate random shapes for each round of the game
     */
    public ImageView getRandomShape(ImageView iv, int random) {
        switch (random) {
            case 1:
                iv.setBackgroundResource(R.drawable.blue_circle);
                iv.setTag(R.drawable.blue_circle);
                break;
            case 2:
                iv.setBackgroundResource(R.drawable.blue_rect);
                iv.setTag(R.drawable.blue_rect);
                break;
            case 3:
                iv.setBackgroundResource(R.drawable.blue_star);
                iv.setTag(R.drawable.blue_star);
                break;
            case 4:
                iv.setBackgroundResource(R.drawable.blue_triangle);
                iv.setTag(R.drawable.blue_triangle);
                break;
            case 5:
                iv.setBackgroundResource(R.drawable.green_circle);
                iv.setTag(R.drawable.green_circle);
                break;
            case 6:
                iv.setBackgroundResource(R.drawable.green_rect);
                iv.setTag(R.drawable.green_rect);
                break;
            case 7:
                iv.setBackgroundResource(R.drawable.green_star);
                iv.setTag(R.drawable.green_star);
                break;
            case 8:
                iv.setBackgroundResource(R.drawable.green_triangle);
                iv.setTag(R.drawable.green_triangle);
                break;
            case 9:
                iv.setBackgroundResource(R.drawable.pink_circle);
                iv.setTag(R.drawable.pink_circle);
                break;
            case 10:
                iv.setBackgroundResource(R.drawable.pink_rect);
                iv.setTag(R.drawable.pink_rect);
                break;
            case 11:
                iv.setBackgroundResource(R.drawable.pink_star);
                iv.setTag(R.drawable.pink_star);
                break;
            case 12:
                iv.setBackgroundResource(R.drawable.pink_triangle);
                iv.setTag(R.drawable.pink_triangle);
                break;
            case 13:
                iv.setBackgroundResource(R.drawable.orange_circle);
                iv.setTag(R.drawable.orange_circle);
                break;
            case 14:
                iv.setBackgroundResource(R.drawable.orange_rect);
                iv.setTag(R.drawable.orange_rect);
                break;
            case 15:
                iv.setBackgroundResource(R.drawable.orange_star);
                iv.setTag(R.drawable.orange_star);
                break;
            case 16:
                iv.setBackgroundResource(R.drawable.orange_triangle);
                iv.setTag(R.drawable.orange_triangle);
                break;
        }
        return iv;
    }


    /**
     * Method to generate random shapes for each round of the game
     */
    public CheckBox getRandomShapeCheckbox(CheckBox cb, int random) {

        switch (random) {
            case 1:
                cb.setBackgroundResource(R.drawable.blue_circle);
                cb.setTag(R.drawable.blue_circle);
                break;
            case 2:
                cb.setBackgroundResource(R.drawable.blue_rect);
                cb.setTag(R.drawable.blue_rect);
                break;
            case 3:
                cb.setBackgroundResource(R.drawable.blue_star);
                cb.setTag(R.drawable.blue_star);
                break;
            case 4:
                cb.setBackgroundResource(R.drawable.blue_triangle);
                cb.setTag(R.drawable.blue_triangle);
                break;
            case 5:
                cb.setBackgroundResource(R.drawable.green_circle);
                cb.setTag(R.drawable.green_circle);
                break;
            case 6:
                cb.setBackgroundResource(R.drawable.green_rect);
                cb.setTag(R.drawable.green_rect);
                break;
            case 7:
                cb.setBackgroundResource(R.drawable.green_star);
                cb.setTag(R.drawable.green_star);
                break;
            case 8:
                cb.setBackgroundResource(R.drawable.green_triangle);
                cb.setTag(R.drawable.green_triangle);
                break;
            case 9:
                cb.setBackgroundResource(R.drawable.pink_circle);
                cb.setTag(R.drawable.pink_circle);
                break;
            case 10:
                cb.setBackgroundResource(R.drawable.pink_rect);
                cb.setTag(R.drawable.pink_rect);
                break;
            case 11:
                cb.setBackgroundResource(R.drawable.pink_star);
                cb.setTag(R.drawable.pink_star);
                break;
            case 12:
                cb.setBackgroundResource(R.drawable.pink_triangle);
                cb.setTag(R.drawable.pink_triangle);
                break;
            case 13:
                cb.setBackgroundResource(R.drawable.orange_circle);
                cb.setTag(R.drawable.orange_circle);
                break;
            case 14:
                cb.setBackgroundResource(R.drawable.orange_rect);
                cb.setTag(R.drawable.orange_rect);
                break;
            case 15:
                cb.setBackgroundResource(R.drawable.orange_star);
                cb.setTag(R.drawable.orange_star);
                break;
            case 16:
                cb.setBackgroundResource(R.drawable.orange_triangle);
                cb.setTag(R.drawable.orange_triangle);
                break;
        }
        return cb;


    }
}

