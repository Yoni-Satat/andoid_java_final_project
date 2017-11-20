package codeclan.com.todoapp.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.sql.SQLInput;

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
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TITLE + " TEXT, " + DESCRIPTION + " TEXT, " + COMPLETED + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insert(Task task) {
        SQLiteDatabase db = this.getWritableDatabase();

        SQLiteStatement prepStatement = db.compileStatement("INSERT INTO todo(title,description, completed) values(?,?,?)");

        prepStatement.bindString(1, task.getTitle());
        prepStatement.bindString(2, task.getDescription());
        prepStatement.bindString(3, task.markCompleted());

        prepStatement.execute();
    }
}
