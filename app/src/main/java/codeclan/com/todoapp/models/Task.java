package codeclan.com.todoapp.models;

import java.util.ArrayList;

/**
 * Created by user on 18/11/2017.
 */

public class Task {

    private int id;
    private String title;
    private String description;
    private boolean completed;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    public Task(int id, String title, String description, boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    

    public String getDescription() {
        return description;
    }

    public boolean toggleCompleted() {
        this.completed = !this.completed;
        return completed;
    }

    public boolean getCompleted() {
        return this.completed;
    }

    public String markCompleted() {
        if (this.completed == false) {
            return "Get it done";
        } else {
            return "Completed";
        }
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
