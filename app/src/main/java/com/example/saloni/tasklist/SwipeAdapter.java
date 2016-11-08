package com.example.saloni.tasklist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by saloni on 5/11/16.
 */
public class SwipeAdapter extends FragmentStatePagerAdapter {


    public SwipeAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = new PageFragment();
        Bundle bundle = new Bundle();
        //Task t = new Task();
        //t=TaskCollection.getTasks().get(position);
        bundle.putString("co",TaskCollection.getTasks().get(position).getDescription());
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return TaskCollection.getTasks().size();
    }
}
