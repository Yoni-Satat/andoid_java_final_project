package codeclan.com.todoapp.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import codeclan.com.todoapp.DB.TaskRepo;
import codeclan.com.todoapp.R;
import codeclan.com.todoapp.models.Task;

public class ShowTaskDescription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_task_description);

        Intent intent = getIntent();

        Bundle extras = intent.getExtras();

        int id = extras.getInt("id");

        TaskRepo taskRepo = new TaskRepo(this);

        Task task = taskRepo.findById(id);

        TextView showDescription = (TextView) findViewById(R.id.todo_description);
        showDescription.setText(task.getDescription());
        //Toast.makeText(this, task.getDescription(), Toast.LENGTH_SHORT).show();
    }
}
