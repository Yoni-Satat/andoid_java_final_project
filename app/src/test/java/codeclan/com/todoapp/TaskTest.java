package codeclan.com.todoapp;

import org.junit.Before;
import org.junit.Test;

import codeclan.com.todoapp.models.Task;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 18/11/2017.
 */

public class TaskTest {

    Task task;

    @Before
    public void before() {
        task = new Task(0, "Finish app", "Finish todo list app", false);
    }

    @Test
    public void testGetId() {
        assertEquals(0, task.getId());
    }

    @Test
    public void testGetTitle() {
        assertEquals("Finish app", task.getTitle());
    }

    @Test
    public void testSetTitle() {
        task.setTitle("Do something");
        assertEquals("Do something", task.getTitle());
    }

    @Test
    public void testGetDescription() {
        assertEquals("Finish todo list app", task.getDescription());
    }

    @Test
    public void testSetDescription() {
        task.setDescription("read a java book to learn more");
        assertEquals("read a java book to learn more", task.getDescription());
    }

    @Test
    public void testCanToggleCompleted() {
        assertEquals(true, task.toggleCompleted());
    }

}
