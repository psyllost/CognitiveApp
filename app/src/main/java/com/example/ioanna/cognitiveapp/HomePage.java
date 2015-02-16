package com.example.ioanna.cognitiveapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class HomePage extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        startActivity(new Intent(HomePage.this,FourShapes.class));
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);


        ItemData itemsData[] = { new ItemData("Help",R.drawable.orange_rect),
                new ItemData("Delete",R.drawable.green_star),
                new ItemData("Cloud",R.drawable.green_triangle),
                new ItemData("Favorite",R.drawable.pink_star),
                new ItemData("Like",R.drawable.pink_star),
                new ItemData("Rating",R.drawable.pink_circle)};


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyAdapter mAdapter = new MyAdapter(itemsData);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_page, menu);
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

