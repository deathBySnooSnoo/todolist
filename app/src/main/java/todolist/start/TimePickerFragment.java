package todolist.start;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TimePicker;
import android.text.format.DateFormat;

import java.util.Calendar;

/**
 * Created by davis on 8/3/15.
 */
public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    private NewTaskActivity nta;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        nta = (NewTaskActivity) getActivity();
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute =  calendar.get(Calendar.MINUTE);
        return new TimePickerDialog(getActivity(), this, hour, minute, DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        nta.setDueTime(hourOfDay, minute);
    }
}
