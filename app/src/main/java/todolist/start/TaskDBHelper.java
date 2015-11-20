package todolist.start;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by davis on 8/18/15.
 */
public class TaskDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Task.db";

    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + TaskContract.Task.TABLE_NAME + " (" + TaskContract.Task.COLUMN_NAME_TASK_ID +
            " INTEGER PRIMARY KEY, " + TaskContract.Task.COLUMN_NAME_TASK_NAME + " TEXT, " + TaskContract.Task.COLUMN_NAME_TASK_DESCRIPTION +
            " TEXT, " + TaskContract.Task.COLUMN_NAME_TASK_DUE_DATE + " TEXT, " + TaskContract.Task.COLUMN_NAME_TASK_DUE_TIME + " TEXT)";

    public TaskDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_ENTRIES);
    }


    public void onOpen(SQLiteDatabase db){

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
