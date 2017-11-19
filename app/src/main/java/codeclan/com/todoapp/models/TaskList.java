package codeclan.com.todoapp.models;

import java.util.ArrayList;

/**
 * Created by user on 18/11/2017.
 */

public class TaskList {

    private ArrayList<Task> tasksList;

    public TaskList() {
        tasksList = new ArrayList<>();
        tasksList.add(new Task(0, "do this", "do it again", false));
        tasksList.add(new Task(0, "done this", "done it again", false));
        tasksList.add(new Task(0, "wash", "wash the cats", false));
        tasksList.add(new Task(0, "hair", "go to the hair saloon", false));
        tasksList.add(new Task(0, "do this", "do do do do do it", false));
        tasksList.add(new Task(0, "nike", "just do it", false));
        tasksList.add(new Task(0, "nike", "just do it", false));
        tasksList.add(new Task(0, "nike", "just do it", false));
        tasksList.add(new Task(0, "nike", "just do it", false));
        tasksList.add(new Task(0, "nike", "just do it", false));
        tasksList.add(new Task(0, "nike", "just do it", false));
        tasksList.add(new Task(0, "nike", "just do it", false));
        tasksList.add(new Task(0, "nike", "just do it", false));
        tasksList.add(new Task(0, "nike", "just do it", false));
        tasksList.add(new Task(0, "nike", "just do it", false));
        tasksList.add(new Task(0, "nike", "just do it", false));
        tasksList.add(new Task(0, "nike", "just do it", false));
        tasksList.add(new Task(0, "nike", "just do it", false));
        tasksList.add(new Task(0, "nike", "just do it", false));
    }

    public ArrayList<Task> getTasksList() {
        return new ArrayList<Task>(tasksList);
    }
}
