package com.example.pr19kopylov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.text.format.DateUtils;
import android.view.View;

import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Button;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public void showDialog(View v){
        CustomDialogFragment dialog = new CustomDialogFragment();
        dialog.show(getSupportFragmentManager(),"custom");
    }

    TextView timePick;
    Button btnTime, btnDate, btnDialog;
    Calendar dateAndTime = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePick = findViewById(R.id.time_pick);

        btnTime = findViewById(R.id.btn_time);
        btnTime.setOnClickListener(this);

        btnDate = findViewById(R.id.btn_date);
        btnDate.setOnClickListener(this);

        setInitialDateTime();
    }
    private void setInitialDateTime(){
        timePick.setText(DateUtils.formatDateTime(this,dateAndTime.getTimeInMillis(), DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR
        | DateUtils.FORMAT_SHOW_TIME));
    }

    @Override
    public void onClick(View view){
        if (view.getId() == R.id.btn_date){
            new DatePickerDialog(MainActivity.this, d,
                    dateAndTime.get(Calendar.YEAR),
                    dateAndTime.get(Calendar.MONTH),
                    dateAndTime.get(Calendar.DAY_OF_MONTH))
                    .show();
        }
        else if(view.getId() == R.id.btn_time){
            new TimePickerDialog(MainActivity.this, t,
                    dateAndTime.get(Calendar.HOUR_OF_DAY),
                    dateAndTime.get(Calendar.MINUTE), true)
                    .show();
        }
    }
    TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener(){
        public void onTimeSet(TimePicker view, int hourOfDay, int minute){
            dateAndTime.set(Calendar.HOUR_OF_DAY,hourOfDay);
            dateAndTime.set(Calendar.MINUTE,minute);
            setInitialDateTime();
        }
    };
    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener(){
      public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth){
          dateAndTime.set(Calendar.YEAR,year);
          dateAndTime.set(Calendar.MONTH, monthOfYear);
          dateAndTime.set(Calendar.DAY_OF_MONTH,dayOfMonth);
          setInitialDateTime();
      }
    };
}