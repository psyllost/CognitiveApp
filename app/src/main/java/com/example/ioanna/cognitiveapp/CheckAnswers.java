package com.example.ioanna.cognitiveapp;

import android.widget.CheckBox;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


public class CheckAnswers {
    private static CheckAnswers mCheckAnswers = new CheckAnswers();
    List<ImageView> ivList = new ArrayList<>();
    List<CheckBox> cbList = new ArrayList<>();

    public CheckAnswers() {

    }

    /**
     * @return mCheckAnswers returns the singleton instance of Scheduler
     */
    public static CheckAnswers getInstance() {
        return mCheckAnswers;
    }

    public void setImageViewList(List<ImageView> imageViewList) {
        this.ivList = imageViewList;
    }

    public void setCheckBoxList(List<CheckBox> checkBoxList) {
        this.cbList = checkBoxList;
    }

    private List<ImageView> getImageViewList() {
        return this.ivList;
    }

    private List<CheckBox> getCheckBoxList() {
        return this.cbList;
    }

    public int correctAnswers() {
        int score = 0;

        for (ImageView iv : getImageViewList()) {
            for (CheckBox cb : getCheckBoxList()) {
                if (String.valueOf(cb.getTag()).equals(String.valueOf(iv.getTag()))) {
                    score++;
                }
            }
        }
        if (getCheckBoxList().size() > score) {
            score = score - getCheckBoxList().size();
        }
        return score;
    }
}



