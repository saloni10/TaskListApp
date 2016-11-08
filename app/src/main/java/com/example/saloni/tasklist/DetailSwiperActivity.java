package com.example.saloni.tasklist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class DetailSwiperActivity extends AppCompatActivity {


    String title,desc;
    int pos;

    ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_swiper);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent i =this.getIntent();
        title =i.getStringExtra("TITLE_KEY");
        desc = i.getExtras().getString("DESC_KEY");
        pos=i.getExtras().getInt("POS_KEY");

        mViewPager = (ViewPager) findViewById(R.id.pager);
        SwipeAdapter swipeAdapter= new SwipeAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(swipeAdapter);
        mViewPager.setCurrentItem(pos);
    }

}
