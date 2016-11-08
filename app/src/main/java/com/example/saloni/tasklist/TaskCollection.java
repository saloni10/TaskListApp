package com.example.saloni.tasklist;

import java.util.ArrayList;

/**
 * Created by saloni on 3/11/16.
 */
public class TaskCollection {

    static ArrayList<Task> tasks = new ArrayList<>();

    public static ArrayList<Task> getTasks()
    {
        return tasks;
    }
}
