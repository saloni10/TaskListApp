package com.example.saloni.tasklist;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by saloni on 3/11/16.
 */
public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context c;
    ArrayList<Task> tasks;
    static  int posi;

    public MyAdapter(Context c, ArrayList<Task> tasks) {
        this.c = c;
        this.tasks = tasks;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.model,parent,false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        final String title= tasks.get(position).getTitle();
        final String description= tasks.get(position).getDescription();

        //BIND
        holder.titleTxt.setText(title);
      //  holder.descTxt.setText(description);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                 Log.d("PASS", "passed");
                   openDetailActivity(title,description,pos);
                posi=pos;

            }
        });


    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    private void openDetailActivity(String title,String desc, int pos)
    {
        Intent i = new Intent(c,DetailSwiperActivity.class);
        Log.d("passing intent","to detail");
        i.putExtra("TITLE_KEY",title);
        i.putExtra("DESC_KEY",desc);
        i.putExtra("POS_KEY",pos);

        c.startActivity(i);
    }
}
