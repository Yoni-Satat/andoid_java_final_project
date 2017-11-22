package codeclan.com.todoapp.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;

import java.util.Calendar;

import codeclan.com.todoapp.DB.TaskRepo;
import codeclan.com.todoapp.R;
import codeclan.com.todoapp.models.Task;

public class CalenderActivity extends AppCompatActivity implements DatePicker.OnDateChangedListener {

    TaskRepo myDb;
    private Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        Intent intent = getIntent();

        Bundle extra = intent.getExtras();

        int id = extra.getInt("id");

        myDb = new TaskRepo(this);

        task = myDb.findById(id);

        DatePicker calendarView = findViewById(R.id.datePicker);

        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        //OnDateChangeListener

        calendarView.init(year, month, day, this);
    }


    @Override
    public void onDateChanged(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {

        String date = dayOfMonth + "/" + (monthOfYear + 1);

        task.setDueDate(date);

        //TaskRepo myDb = new TaskRepo(this);
        myDb.update(task);
        finish();
    }
}
