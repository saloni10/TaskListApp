package com.example.saloni.tasklist;

import android.app.Dialog;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    MyAdapter adapter;
    CRUD crud;
    EditText titleEditText, descEditText;
    Button saveButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv= (RecyclerView) findViewById(R.id.recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());
        crud = new CRUD(TaskCollection.getTasks());
        adapter = new MyAdapter(this,crud.getTasks());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_add_task,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_task:
                displayDialog();
                Log.d("MainActivity", "Add a new task");
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void displayDialog()
    {
        Dialog d = new Dialog(this);
        d.setTitle("Add data");
        d.setContentView(R.layout.dialog_layout);
        titleEditText=(EditText) d.findViewById(R.id.titleEditText);
        descEditText=(EditText) d.findViewById(R.id.descEditText);
        saveButton= (Button) d.findViewById(R.id.saveBtn) ;

        saveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Task t = new Task();
                if(titleEditText.getText().toString().isEmpty()||descEditText.getText().toString().isEmpty())
                {    Toast.makeText(getApplicationContext(),"Enter Some value", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    t.setTitle(titleEditText.getText().toString());

                t.setDescription(descEditText.getText().toString());

                if(crud.addNew(t))
                {
                    Toast.makeText(getApplicationContext(),"Your Task has been Saved", Toast.LENGTH_SHORT).show();
                    titleEditText.setText("");
                    descEditText.setText("");
                    rv.setAdapter(adapter);
                }
            }
            }
        });


        d.show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        rv.setAdapter(adapter);
    }
}
