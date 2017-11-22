package codeclan.com.todoapp.controllers;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import codeclan.com.todoapp.DB.TaskRepo;
import codeclan.com.todoapp.R;
import codeclan.com.todoapp.models.Task;

public class CalenderActivity extends AppCompatActivity implements DatePicker.OnDateChangedListener {

    TaskRepo myDb;
    private Task task;
    Date dateToCheck;
    TextView dateToChange;

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



        String date = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;

        task.setDueDate(date);

        //TaskRepo myDb = new TaskRepo(this);
        myDb.update(task);

        // trying to change color after comparing dates:
        //changeDateColor(dateToChange);


        finish();
    }

    public void changeDateColor(View dateView) {
        String dueDate = task.getDueDate();

        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dateToCheck = sdf.parse(dueDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        Date currentDate = new Date();
        if (currentDate.compareTo(dateToCheck) > 0) {
            dateToChange = findViewById(R.id.textView_dateDue);
//            Task selectedTask = (Task) dateView.getTag();
            dateToChange.setTextColor(Color.parseColor("#f44242"));
        }
    }


}
