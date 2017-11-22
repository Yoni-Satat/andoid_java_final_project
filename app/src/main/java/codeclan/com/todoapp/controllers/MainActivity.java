package codeclan.com.todoapp.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import codeclan.com.todoapp.DB.TaskRepo;
import codeclan.com.todoapp.R;
import codeclan.com.todoapp.models.Task;
import codeclan.com.todoapp.models.TasksAdapter;

public class MainActivity extends AppCompatActivity {

    TaskRepo myDb;
    private boolean showAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new TaskRepo(this);
        this.showAll = true;
    }

    @Override
    public void onResume() {
        super.onResume();

        ArrayList<Task> tasks = myDb.findAll();
        refresh(tasks);
    }

    // add onClick event
    public void onClickToSeeDescription(View titleTextView) {


        Task selectedTask = (Task) titleTextView.getTag();
        //Toast.makeText(this, selectedTask.getDescription(), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, ShowTaskDescription.class);
//        TextView showDesc = (TextView) findViewById(R.id.todo_description);

        intent.putExtra("id", selectedTask.getId());


        startActivity(intent);
    }

    public void onClickMarkComplete(View markCompletedtextView) {
        Task selectedTask = (Task) markCompletedtextView.getTag();
        selectedTask.toggleCompleted();


        myDb.update(selectedTask);


        ArrayList<Task> tasks = myDb.findAll();
        refresh(tasks);
    }

    // Button addNewTodo = (Button)findViewById(R.id.addNewTodo);

    public void onClickAddTodo(View view) {
        Intent addNewTodo = new Intent(this, AddTaskActivity.class);
        startActivity(addNewTodo);
    }

    public void onClickGoToCalender(View calenderTextView) {
        Task selectedTask = (Task) calenderTextView.getTag();
        Intent goToCalender = new Intent(this, CalenderActivity.class);
        goToCalender.putExtra("id", selectedTask.getId());
        startActivity(goToCalender);
    }

    public void onClickDeleteAll(View view) {
        myDb.deleteAll();

        ArrayList<Task> tasks = myDb.findAll();
        refresh(tasks);
    }

    public void onClickDeleteTask(View deleteTaskTextView) {
        Task selectedTask = (Task) deleteTaskTextView.getTag();
        myDb.deleteTask(selectedTask);

        ArrayList<Task> tasks = myDb.findAll();
        refresh(tasks);

    }

    public void toggleHideCompleted(View view) {
        ArrayList<Task> tasks = myDb.findAll();

        ArrayList<Task> tasksToShow = new ArrayList<>();

        if(showAll) {
            tasksToShow = tasks;
        } else {
            for(Task task: tasks) {
                if(!task.getCompleted()) {
                    tasksToShow.add(task);
                }
            }
        }
        refresh(tasksToShow);
        showAll = !showAll;

    }

    public void refresh(ArrayList<Task> tasks) {
        TasksAdapter tasksAdapter = new TasksAdapter(this, tasks);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(tasksAdapter);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.menu, menu);
//        return true;
//    }

    //@Override
    //public boolean onOptionsItemSelected(MenuItem item) {
        //if(item.getItemId() == R.id.todo_description) {
            //Intent intent = new Intent(this, ShowTaskDescription.class);
            //startActivity(intent);
        //}
        //return true;
    //}
}
