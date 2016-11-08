package com.example.saloni.tasklist;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailPagerActivity extends FragmentActivity {

    String title,desc;
    int pos;

    ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pager);
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
