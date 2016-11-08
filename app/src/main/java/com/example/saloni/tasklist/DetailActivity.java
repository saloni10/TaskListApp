package com.example.saloni.tasklist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {


    TextView titletxt,desctxt;
    String title,desc;
    int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Log.d("passed intent","to detail");
        titletxt= (TextView)findViewById(R.id.titleTxtDetail);
        desctxt= (TextView)findViewById(R.id.descTxtDetail);

        Intent i =this.getIntent();
        title =i.getStringExtra("TITLE_KEY");
        desc = i.getExtras().getString("DESC_KEY");
        pos=i.getExtras().getInt("POS_KEY");

         titletxt.setText(title);
        desctxt.setText(desc);
    }
}
