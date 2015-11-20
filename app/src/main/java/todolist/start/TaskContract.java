package todolist.start;

import android.provider.BaseColumns;

/**
 * Created by davis on 8/17/15.
 */
public final class TaskContract {

    public TaskContract(){}

    public static abstract class Task implements BaseColumns{
        public static final String TABLE_NAME = "Task";
        public static final String COLUMN_NAME_TASK_ID = "taskID";
        public static final String COLUMN_NAME_TASK_NAME = "taskName";
        public static final String COLUMN_NAME_TASK_DESCRIPTION = "description";
        public static final String COLUMN_NAME_TASK_DUE_DATE = "dueDate";
        public static final String COLUMN_NAME_TASK_DUE_TIME = "dueTime";
    }
}
