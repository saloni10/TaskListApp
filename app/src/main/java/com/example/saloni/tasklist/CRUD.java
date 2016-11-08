package com.example.saloni.tasklist;

import java.util.ArrayList;

/**
 * Created by saloni on 3/11/16.
 * Referemces https://www.youtube.com/watch?v=IPD02owD1dg
 */
public class CRUD {

    ArrayList<Task> tasks;

    public CRUD(ArrayList<Task> tasks){
        this.tasks=tasks;
    }

    public boolean addNew(Task task)
    {
        tasks.add(task);
        return true;
    }


    public ArrayList<Task> getTasks()
    {
        return tasks;
    }

    public boolean  update(int position,Task newTask )
    {
        tasks.remove(position);
        tasks.add(position,newTask);
        return true;
    }
}
