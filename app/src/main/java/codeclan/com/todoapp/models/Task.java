package codeclan.com.todoapp.models;

/**
 * Created by user on 18/11/2017.
 */

public class Task {

    private int id;
    private String title;
    private String description;
    private boolean completed;
    private String dueDate;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    public Task(int id, String title, String description, boolean completed, String dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.dueDate = dueDate;
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
            return "DONE";
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

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }


}
