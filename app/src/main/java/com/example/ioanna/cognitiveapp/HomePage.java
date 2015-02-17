package com.example.ioanna.cognitiveapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import java.util.ArrayList;
import java.util.List;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.CardThumbnail;
import it.gmariotti.cardslib.library.view.CardListView;


public class HomePage extends ActionBarActivity {

    static List<Card> cards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        setContentView(R.layout.activity_home_page);
        startActivity(new Intent(HomePage.this, FourShapes.class));
        ItemData itemsData[] = {new ItemData("Help", R.drawable.orange_rect),
                new ItemData("Delete", R.drawable.green_star),
                new ItemData("Cloud", R.drawable.green_triangle),
                new ItemData("Favorite", R.drawable.pink_star),
                new ItemData("Like", R.drawable.pink_star),
                new ItemData("Rating", R.drawable.pink_circle)};

        cards = new ArrayList<Card>();

        for (ItemData itemData : itemsData) {
            // Create a Card
            Card card = new CustomCard(this);
            // Create a CardHeader
            CardHeader header = new CardHeader(this);
            // Add Header to card
            header.setTitle(itemData.getTitle());
            card.setTitle(itemData.getTitle());
            card.addCardHeader(header);

            CardThumbnail thumb = new CardThumbnail(this);
            thumb.setDrawableResource(itemData.getImageUrl());
            card.addCardThumbnail(thumb);
            card.setSwipeable(true);
            cards.add(card);

            card.setOnSwipeListener(new Card.OnSwipeListener() {
                @Override
                public void onSwipe(Card card) {
                    cards.remove(card);
                }
            });
        }

        CardArrayAdapter mCardArrayAdapter = new CardArrayAdapter(this, cards);

        CardListView listView = (CardListView) this.findViewById(R.id.myList);
        if (listView != null) {
            listView.setAdapter(mCardArrayAdapter);
        }
    }
}

