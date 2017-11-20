package codeclan.com.todoapp.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import codeclan.com.todoapp.DB.TaskRepo;
import codeclan.com.todoapp.R;
import codeclan.com.todoapp.models.Task;
import codeclan.com.todoapp.models.TasksAdapter;

public class MainActivity extends AppCompatActivity {

    TaskRepo myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new TaskRepo(this);
//
//        Task task = new Task(0, "derp", "desc", true);
//
//        myDb.save(task);

        //finish();



        //TextView textView = findViewById(R.id.listView_mark_completed);
        //textView.setAdapter(tasksAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();

        ArrayList<Task> tasks = myDb.findAll();

        TasksAdapter tasksAdapter = new TasksAdapter(this, tasks);

        // get the list view back finding it by id:
        ListView listView = findViewById(R.id.list);
        // connect the list view to the adapter:
        listView.setAdapter(tasksAdapter);
    }

    // add onClick event
    public void onClickToSeeDescription(View titleTextView) {


        Task selectedTask = (Task) titleTextView.getTag();
        Toast.makeText(this, selectedTask.getTitle(), Toast.LENGTH_SHORT).show();
    }

    public void onClickMarkComplete(View markCompletedtextView) {
        Task selectedTask = (Task) markCompletedtextView.getTag();
        selectedTask.toggleCompleted();


        myDb.update(selectedTask);


        ArrayList<Task> tasks = myDb.findAll();

        TasksAdapter tasksAdapter = new TasksAdapter(this, tasks);



        // get the list view back finding it by id:
        ListView listView = findViewById(R.id.list);
        // connect the list view to the adapter:
        listView.setAdapter(tasksAdapter);
    }

    // Button addNewTodo = (Button)findViewById(R.id.addNewTodo);

    public void onClickAddTodo(View view) {
        Intent addNewTodo = new Intent(this, AddTaskActivity.class);
        startActivity(addNewTodo);
    }
}
