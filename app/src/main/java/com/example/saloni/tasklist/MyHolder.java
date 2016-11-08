package com.example.saloni.tasklist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by saloni on 3/11/16.
 * https://www.youtube.com/watch?v=IPD02owD1dg
 */
public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    TextView titleTxt;
    TextView descTxt;
    ItemClickListener itemClickListener;
    public MyHolder(View itemView) {
        super(itemView);

        titleTxt =(TextView) itemView.findViewById(R.id.titleTextView);
        //descTxt = (TextView) itemView.findViewById(R.id.descTextView);
        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener)
    {
        this.itemClickListener=itemClickListener;
    }

    @Override
    public void onClick(View view) {
        this.itemClickListener.onItemClick(getLayoutPosition());
    }
}
