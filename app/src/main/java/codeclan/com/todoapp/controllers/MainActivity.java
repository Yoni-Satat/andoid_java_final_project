package codeclan.com.todoapp.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import codeclan.com.todoapp.DB.TaskRepo;
import codeclan.com.todoapp.R;
import codeclan.com.todoapp.models.Task;
import codeclan.com.todoapp.models.TaskList;
import codeclan.com.todoapp.models.TasksAdapter;

public class MainActivity extends AppCompatActivity {

    TaskRepo myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new TaskRepo(this);

        Task task = new Task(0, "derp", "desc", true);

        myDb.insert(task);

        TaskList taskList = new TaskList();

        ArrayList<Task> tasks = taskList.getTasksList();

        TasksAdapter tasksAdapter = new TasksAdapter(this, tasks);

        // get the list view back finding it by id:
        ListView listView = findViewById(R.id.list);
        // connect the list view to the adapter:
        listView.setAdapter(tasksAdapter);

        //TextView textView = findViewById(R.id.listView_mark_completed);
        //textView.setAdapter(tasksAdapter);
    }

    // add onClick event
    public void onClickToSeeDescription(View titleTextView) {


        Task selectedTask = (Task) titleTextView.getTag();
        Toast.makeText(this, selectedTask.getTitle(), Toast.LENGTH_SHORT).show();
    }

    public void onClickMarkComplete(View markCompletedtextView) {
        Task selectedTask = (Task) markCompletedtextView.getTag();
        selectedTask.toggleCompleted();

        //selectedTask.save();
        //TaskRepo.save(selectedTask);


        TaskList taskList = new TaskList();
        taskList.update(selectedTask);


        ArrayList<Task> tasks = taskList.getTasksList();

        TasksAdapter tasksAdapter = new TasksAdapter(this, tasks);

        // get the list view back finding it by id:
        ListView listView = findViewById(R.id.list);
        // connect the list view to the adapter:
        listView.setAdapter(tasksAdapter);


    }
}
