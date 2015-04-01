package com.example.ioanna.cognitiveapp;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import it.gmariotti.cardslib.library.internal.Card;

public class CustomCard extends Card {

    protected TextView mTitle;
    protected TextView mSecondaryTitle;
    protected ProgressBar mProgressBar;

    /**
     * Constructor with a custom inner layout
     *
     * @param context
     */
    public CustomCard(Context context) {
        this(context, R.layout.card_inner_content);
    }

    /**
     * @param context
     * @param innerLayout
     */
    public CustomCard(Context context, int innerLayout) {
        super(context, innerLayout);
        init();
    }

    /**
     * Init
     */
    private void init() {

        //No Header

        //Set a OnClickListener listener
        setOnClickListener(new OnCardClickListener() {
            @Override
            public void onClick(Card card, View view) {
                Toast.makeText(getContext(), "Click Listener card=", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void setupInnerViewElements(ViewGroup parent, View view) {

        //Retrieve elements
//        mTitle = (TextView) parent.findViewById(R.id.carddemo_myapps_main_inner_title);
//        mSecondaryTitle = (TextView) parent.findViewById(R.id.carddemo_myapps_main_inner_secondaryTitle);
//        mProgressBar = (ProgressBar) parent.findViewById(R.id.progressBarOverall);
//
//
//        if (mTitle != null)
//            mTitle.setText("oH YEAH");
//
//        if (mSecondaryTitle != null)
//            mSecondaryTitle.setText("NAILED IT");
//
//        if (mProgressBar != null) {
////            mProgressBar.setScaleX(3);
////            mProgressBar.setScaleY(3);
//            mProgressBar.setMax(5);
//            mProgressBar.setProgress(3);
//        }
    }
}