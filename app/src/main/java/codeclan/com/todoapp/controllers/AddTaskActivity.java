package codeclan.com.todoapp.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import codeclan.com.todoapp.DB.TaskRepo;
import codeclan.com.todoapp.R;
import codeclan.com.todoapp.models.Task;

public class AddTaskActivity extends AppCompatActivity {

    TaskRepo myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        myDb = new TaskRepo(this);
    }



    public void onClickSaveNewTodo(View view) {

        EditText descriptionInput = findViewById(R.id.addTaskField);
        String description = descriptionInput.getText().toString();

        TextView titleInput = findViewById(R.id.editText2);
        String title = titleInput.getText().toString();

        Task task = new Task(title, description);
        myDb.save(task);
        finish();
    }
}
