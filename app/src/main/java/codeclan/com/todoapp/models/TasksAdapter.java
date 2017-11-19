package codeclan.com.todoapp.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

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
        TextView title = listItemsView.findViewById(R.id.title);
        title.setText(currentTaskItem.getTitle().toString());

        TextView completed = listItemsView.findViewById(R.id.listView_mark_completed);
        completed.setText(currentTaskItem.getTitle());


        // set tag for the onClick event:
        listItemsView.setTag(currentTaskItem);

        return listItemsView;

    }
}