package codeclan.com.todoapp.controllers;

import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import codeclan.com.todoapp.R;
import codeclan.com.todoapp.models.Task;
import codeclan.com.todoapp.models.TaskList;
import codeclan.com.todoapp.models.TasksAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TaskList taskList = new TaskList();

        ArrayList<Task> tasks = taskList.getTasksList();

        TasksAdapter tasksAdapter = new TasksAdapter(this, tasks);

        // get the list view back finding it by id:
        ListView listView = findViewById(R.id.list);
        // connect the list view to the adapter:
        listView.setAdapter(tasksAdapter);
    }
}
