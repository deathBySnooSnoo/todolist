package todolist.start;

import android.app.DialogFragment;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by davis on 1/26/2016.
 */
public class EditTaskActivity extends ActionBarActivity {

    private String date;
    private String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);
        //GET TASK INFO FROM DB
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_task, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showDatePickerDialog(View v){
        DialogFragment datePicker = new DatePickerFragment();
        datePicker.show(getFragmentManager(), "datePicker");
    }

    public void showTimePickerDialog(View v){
        DialogFragment timePicker = new TimePickerFragment();
        timePicker.show(getFragmentManager(), "timePicker");
    }

    public void setDueDate(int year, int month, int day){
        date = month + "/" + day + "/" + year;
        Button dueDate = (Button) findViewById(R.id.button_task_due_date);
        dueDate.setText(date);

    }

    public void setDueTime(int hour, int minute){
        time = hour + ":" + minute;
        Button dueTime = (Button) findViewById(R.id.button_task_due_time);
        dueTime.setText(time);
    }

    public void done(View v){
        EditText taskName = (EditText) findViewById(R.id.edit_text_task_name);
        EditText taskDescription = (EditText) findViewById(R.id.edit_text_task_description);
        TaskDBHelper tdbh = new TaskDBHelper(v.getContext());
        SQLiteDatabase db = tdbh.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TaskContract.Task.COLUMN_NAME_TASK_NAME, taskName.getText().toString());
        values.put(TaskContract.Task.COLUMN_NAME_TASK_DESCRIPTION, taskDescription.getText().toString());
        values.put(TaskContract.Task.COLUMN_NAME_TASK_DUE_DATE, date);
        values.put(TaskContract.Task.COLUMN_NAME_TASK_DUE_TIME, time);
        long newRowId = db.insert(TaskContract.Task.TABLE_NAME, "null", values);
    }
}
