package todolist.start;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getTasks();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    private void getTasks(){
        TaskDBHelper tdbh = new TaskDBHelper(this.findViewById(android.R.id.content).getContext());
        SQLiteDatabase db = tdbh.getReadableDatabase();
        String[] projection = {TaskContract.Task._ID, TaskContract.Task.COLUMN_NAME_TASK_NAME, TaskContract.Task.COLUMN_NAME_TASK_DESCRIPTION, TaskContract.Task.COLUMN_NAME_TASK_DUE_DATE, TaskContract.Task.COLUMN_NAME_TASK_DUE_TIME};
        Cursor c = db.query(TaskContract.Task.TABLE_NAME, projection, "*", null, null, null, null);
        c.moveToFirst();
        String taskName = c.getString(c.getColumnIndexOrThrow(TaskContract.Task.COLUMN_NAME_TASK_NAME));
        TextView taskView = new TextView(this);
        taskView.setText(taskName);
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.activity_main);
        rl.addView(taskView);
    }

    public void newTask(MenuItem menuItem){
        Intent intent = new Intent(this, NewTaskActivity.class);
        startActivity(intent);
    }
}
