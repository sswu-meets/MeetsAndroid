package com.example.meets;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

//calendarutil.selecteddate.getdaymonth...
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;

import java.io.Serializable;
import java.util.ArrayList;

public class PlusMoimActivity extends AppCompatActivity implements Serializable {
    SwitchCompat switchOnOff;
    TextView tvSwitchYes;
    TextView tvSwitchNo;

    TextView textView_Date;
    TextView textView_start_time;
    TextView textView_end_time;
    DatePickerDialog.OnDateSetListener date;
    TimePickerDialog.OnTimeSetListener time_start;
    TimePickerDialog.OnTimeSetListener time_end;
    Button btn_date;
    Button btn_start_time;
    Button btn_end_time;

    EditText txt_todo1;
    EditText txt_todo2;
    EditText txt_todo3;
    EditText txt_todo4;

    EditText txt_place1;
    Button btn_place1;
    EditText txt_place2;
    Button btn_place2;
    EditText txt_place3;
    Button btn_place3;
    LinearLayout listView_place;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plusmoim);

        Button moveBack = findViewById(R.id.pre_page_btn);

        switchOnOff = findViewById(R.id.switchOnOff);
        tvSwitchYes = findViewById(R.id.tvSwitchYes);
        tvSwitchNo = findViewById(R.id.tvSwitchNo);

        switchOnOff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                int white = ContextCompat.getColor(getApplicationContext(), R.color.white);
                int black = ContextCompat.getColor(getApplicationContext(), R.color.black);

                if(isChecked){
                    tvSwitchYes.setTextColor(black);
                    tvSwitchNo.setTextColor(white);
                }else{
                    tvSwitchYes.setTextColor(white);
                    tvSwitchNo.setTextColor(black);
                }
            }
        });

        textView_Date = findViewById(R.id.txt_date);
        textView_start_time = findViewById(R.id.tv_start);
        textView_end_time = findViewById(R.id.tv_end);
        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                textView_Date.setText(year + "년 " + month + "월 " + day + "일");
            }
        };

        btn_date = findViewById(R.id.btn_date);
        btn_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog date_dialog = new DatePickerDialog(PlusMoimActivity.this, date, 2022, 8, 13);
                date_dialog.show();
            }
        });

        time_start = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int h, int m) {
                textView_start_time.setText(h + "시" + m + "분");
            }
        };

        btn_start_time = findViewById(R.id.btn_start_time);
        btn_start_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog time_dialog_start = new TimePickerDialog(PlusMoimActivity.this, android.R.style.Theme_Holo_Light_Dialog, time_start, 10, 00, false);
                time_dialog_start.show();
            }
        });

        time_end = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int h, int m) {
                textView_end_time.setText(h + "시" + m + "분");
            }
        };
        btn_end_time = findViewById(R.id.btn_end_time);
        btn_end_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog time_dialog_end = new TimePickerDialog(PlusMoimActivity.this,android.R.style.Theme_Holo_Light_Dialog, time_end, 20, 00, false);
                time_dialog_end.show();
            }
        });

        Button btn_finish = (Button) findViewById(R.id.btn_finish);
        EditText txt_schedule = findViewById(R.id.txt_schedule);

        txt_todo1 = findViewById(R.id.txt_todo1);
        txt_todo2 = findViewById(R.id.txt_todo2);
        txt_todo3 = findViewById(R.id.txt_todo3);
        txt_todo4 = findViewById(R.id.txt_todo4);

        txt_place1 = findViewById(R.id.txt_place1);
        btn_place1 = findViewById(R.id.btn_place1);

        txt_place2 = findViewById(R.id.txt_place2);
        btn_place2 = findViewById(R.id.btn_place2);

        txt_place3 = findViewById(R.id.txt_place3);
        btn_place3 = findViewById(R.id.btn_place3);

        listView_place = findViewById(R.id.layout_place);

        btn_place1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textViewN = new TextView(getApplicationContext());
                textViewN.setText(txt_place1.getText());
                createTextView(textViewN, listView_place);
            }
        });

        btn_place2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textViewN = new TextView(getApplicationContext());
                textViewN.setText(txt_place2.getText());
                createTextView(textViewN, listView_place);
            }
        });

        btn_place3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textViewN = new TextView(getApplicationContext());
                textViewN.setText(txt_place3.getText());
                createTextView(textViewN, listView_place);
            }
        });



        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String place1 = txt_place1.getText().toString();
                String place2 = txt_place2.getText().toString();
                String place3 = txt_place3.getText().toString();
                String todo1 = txt_todo1.getText().toString();
                String todo2 = txt_todo2.getText().toString();
                String todo3 = txt_todo3.getText().toString();
                String todo4 = txt_todo4.getText().toString();
                String schedule = txt_schedule.getText().toString();
                Intent intent = new Intent(getApplicationContext(), MakeMoimActivity.class);
                intent.putExtra("schedule", schedule);
                intent.putExtra("place1", place1);
                intent.putExtra("place2", place2);
                intent.putExtra("place3", place3);
                intent.putExtra("todo1",todo1);
                intent.putExtra("todo2",todo2);
                intent.putExtra("todo3",todo3);
                intent.putExtra("todo4",todo4);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void createTextView(TextView textViewN, LinearLayout listview) {

        textViewN.setTextSize(12);
        //textViewN.setTypeface(null, );
        textViewN.setId(0);
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        param.leftMargin = 30;

        textViewN.setLayoutParams(param);
        listview.addView(textViewN);

    }

}
