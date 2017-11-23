package codeclan.com.todoapp.models;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import codeclan.com.todoapp.R;

/**
 * Created by user on 18/11/2017.
 */

public class TasksAdapter extends ArrayAdapter<Task> {
    public TasksAdapter(Context context, ArrayList<Task> tasksList) {
        super(context, 0, tasksList);
    }

    @Override
    public View getView(int position, View listItemsView, ViewGroup parent) {

        if(listItemsView == null) {
            listItemsView = LayoutInflater.from(getContext()).inflate(R.layout.task_items, parent, false);
        }

        // get the current task item by position:
        Task currentTaskItem = getItem(position);


        // set views for title and completed columns:
        TextView title = listItemsView.findViewById(R.id.listView_title);
        title.setText(currentTaskItem.getTitle());

        TextView completed = listItemsView.findViewById(R.id.listView_mark_completed);
        completed.setText(currentTaskItem.markCompleted());

        TextView deleteTask = listItemsView.findViewById(R.id.deleteTodo);

        TextView goToCalender = listItemsView.findViewById(R.id.textView_dateDue);

        TextView dueDate = listItemsView.findViewById(R.id.textView_dateDue);
        dueDate.setTextColor(Color.parseColor("#FF303F9F"));

        String dueDateStr = currentTaskItem.getDueDate();
        if(dueDateStr != null) {
//            dueDateStr = "SELECT DATE";
            dueDate.setText(dueDateStr);
        }

        // set tag for the onClick event:
        completed.setTag(currentTaskItem);
        deleteTask.setTag(currentTaskItem);
        title.setTag(currentTaskItem);
        goToCalender.setTag(currentTaskItem);
        dueDate.setTag(currentTaskItem);

        String taskDueDate = currentTaskItem.getDueDate();

        if (taskDueDate == null) {
            return listItemsView;
        }

        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dateToCheck = null;

        try {
            dateToCheck = sdf.parse(taskDueDate);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }


        Date currentDate = new Date();
        if (currentDate.compareTo(dateToCheck) > 0) {
//            Task selectedTask = (Task) dateView.getTag();
            dueDate.setTextColor(Color.parseColor("#f44242"));
        }

        return listItemsView;
    }
}
