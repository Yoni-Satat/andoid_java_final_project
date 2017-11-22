package codeclan.com.todoapp.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;

import codeclan.com.todoapp.DB.TaskRepo;
import codeclan.com.todoapp.R;
import codeclan.com.todoapp.models.Task;

public class CalenderActivity extends AppCompatActivity {


    private Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        Intent intent = getIntent();

        Bundle extra = intent.getExtras();

        int id = extra.getInt("id");

        TaskRepo taskRepo = new TaskRepo(this);

        task = taskRepo.findById(id);
    }

    public void onCalenderClick(View view) {
        CalendarView calenderView = (CalendarView) view;
        long date = calenderView.getDate();
        task.setDueDate(date);

        TaskRepo taskRepo = new TaskRepo(this);
        taskRepo.update(task);
    }
}
