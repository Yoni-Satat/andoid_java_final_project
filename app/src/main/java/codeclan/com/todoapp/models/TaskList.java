package codeclan.com.todoapp.models;

import java.util.ArrayList;

/**
 * Created by user on 18/11/2017.
 */

public class TaskList {

    private ArrayList<Task> tasksList;

    public TaskList() {
        tasksList = new ArrayList<>();
        tasksList.add(new Task(1, "do this", "do it again", false));
        tasksList.add(new Task(2, "done this", "done it again", true));
        tasksList.add(new Task(3, "wash", "wash the cats", false));
        tasksList.add(new Task(4, "hair", "go to the hair saloon", false));
        tasksList.add(new Task(5, "do this", "do do do do do it", false));
        tasksList.add(new Task(6, "nike", "just do it", true));
        tasksList.add(new Task(7, "nike", "just do it", false));
        tasksList.add(new Task(8, "nike", "just do it", true));
        tasksList.add(new Task(9, "nike", "just do it", false));
        tasksList.add(new Task(10, "nike", "just do it", false));
        tasksList.add(new Task(11, "nike", "just do it", true));
        tasksList.add(new Task(12, "nike", "just do it", false));
        tasksList.add(new Task(13, "nike", "just do it", false));
        tasksList.add(new Task(14, "nike", "just do it", true));
        tasksList.add(new Task(15, "nike", "just do it", false));
        tasksList.add(new Task(16, "nike", "just do it", false));
        tasksList.add(new Task(17, "nike", "just do it", false));
        tasksList.add(new Task(18, "nike", "just do it", false));
        tasksList.add(new Task(19, "nike", "just do it", false));
    }

    public void update(Task updatedTask) {

        //update  Task set title = $1, description = $2
        // where id = updatedTask.getId()

        for(Task task : this.tasksList) {
            if(task.getId() == updatedTask.getId()) {
                tasksList.set( task.getId() - 1 , updatedTask);
            }
        }
    }

    public ArrayList<Task> getTasksList() {
        return new ArrayList<Task>(tasksList);
    }
}
