package com.space.medicinescheduler;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class CreateScheduleActivity extends AppCompatActivity implements OnClickListener {
    private static final String TAG ="";
    private DatePicker datePicker;
    private TextView displayStartDate, displayEndDate;
    private Button changeStartDate, changeEndDate;
    private int dateFlag = 0;
    private int year;
    private int month;
    private int day;
    static final int DATE_DIALOG_ID = 999;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_schedule);
        setCurrentDateOnView();
    }

    public void setCurrentDateOnView() {
        displayStartDate = (TextView) findViewById(R.id.startDate);
        displayEndDate = (TextView) findViewById(R.id.endDate);

        datePicker = (DatePicker) findViewById(R.id.datePicker);
        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        displayStartDate.setText(new StringBuilder().append("Start Date : ")
                // Month is 0 based, just add 1
                .append(day).append("-").append(month + 1).append("-")
                .append(year).append(" "));
        displayEndDate.setText(new StringBuilder().append("Start Date : ")
                // Month is 0 based, just add 1
                .append(day).append("-").append(month + 1).append("-")
                .append(year).append(" "));
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                // set date picker as current date
                return new DatePickerDialog(this, datePickerListener,
                        year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener datePickerListener
            = new DatePickerDialog.OnDateSetListener() {
        // when dialog box is closed, below method will be called.
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            year = selectedYear;
            month = selectedMonth;
            day = selectedDay;
            // set selected date into textview
            if (dateFlag == 1) {
                displayStartDate.setText("Start Date : " + new StringBuilder().append(day).append("-").append(month + 1)
                        .append("-").append(year).append(" "));
            } else if (dateFlag == 2) {
                displayEndDate.setText("Start Date : " + new StringBuilder().append(day).append("-").append(month + 1)
                        .append("-").append(year).append(" "));
            }
            // set selected date into datepicker also
            datePicker.init(year, month, day, null);
            View datePickerView = findViewById(R.id.datePicker);
            datePickerView.setVisibility(View.INVISIBLE);
        }
    };

    @Override
    public void onClick(View view) {
        switch (view.getId()) //get the id which is an int
        {
            case R.id.changeStartDate: //if its change button for start date
                dateFlag = 1;
                changeStartDate = (Button) findViewById(R.id.changeStartDate);
                changeStartDate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d(TAG, "onClick: ChangeStartDate");
                        showDialog(DATE_DIALOG_ID);
                    }
                });
                break;
            case R.id.changeEndDate://if its change button for end date
                dateFlag = 2;
                changeEndDate = (Button) findViewById(R.id.changeEndDate);
                changeEndDate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d(TAG, "onClick: changeEndDate");
                        showDialog(DATE_DIALOG_ID);
                    }
                });
                break;
        }
    }
}
