package codeclan.com.todoapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import java.sql.SQLInput;
import java.util.ArrayList;

import codeclan.com.todoapp.models.Task;

/**
 * Created by user on 20/11/2017.
 */

public class TaskRepo extends SQLiteOpenHelper {

    public static final String DB_NAME = "todo_app.db";
    public static final String TABLE_NAME = "todo";
    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String COMPLETED = "completed";


    public TaskRepo(Context context) {
        // taken out from original constructor
        // String name, SQLiteDatabase.CursorFactory factory, int version
        super(context, DB_NAME, null, 2);
        SQLiteDatabase db = this.getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TITLE + " TEXT, " + DESCRIPTION + " TEXT, " + COMPLETED + " BOOLEAN)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void save(Task task) {
        SQLiteDatabase db = this.getWritableDatabase();

        SQLiteStatement prepStatement = db.compileStatement("INSERT INTO todo(title,description, completed) values(?,?,?)");

        prepStatement.bindString(1, task.getTitle());
        prepStatement.bindString(2, task.getDescription());
        prepStatement.bindString(3, "false");

        prepStatement.execute();
    }

    public ArrayList<Task> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM todo", null);

        ArrayList<Task> returnedTaskList = new ArrayList<>();

        if(result != null) {
            if(result.moveToFirst()) {
                do {

                    String completed = result.getString(3);
                    boolean complete = false;

                    if (completed.equals("true")) {
                        complete = true;
                    }

                    Task task = new Task(result.getInt(0), result.getString(1), result.getString(2), complete);
                    returnedTaskList.add(task);


                } while (result.moveToNext());
            }
        }

        return returnedTaskList;

    }

    public boolean update(Task task) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, task.getId());
        contentValues.put(TITLE, task.getTitle());
        contentValues.put(DESCRIPTION, task.getDescription());
        contentValues.put(COMPLETED, Boolean.toString(task.getCompleted()));
        int val = db.update(TABLE_NAME, contentValues, "id = " + task.getId(), null);

        return val != -1;
    }

    public void deleteAll() {
        SQLiteDatabase db = getReadableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
        db.close();
    }

    public Task findById(int id) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE id = ?", new String[] {String.valueOf(id)});

        if(cursor != null) {
            cursor.moveToFirst();

            boolean completed = cursor.getString(3).equals("true");

            Task task = new Task(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    completed
            );

            return task;
        }

        return null;
    }
}
